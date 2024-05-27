<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Agregar/Editar un producto</ion-title>
        <ion-buttons slot="end">
          <ion-button href="/dashboard">
            <ion-icon :icon="IonIcons.homeSharp"></ion-icon>
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
    <ion-content ref="content" class="dark-mode">
      <h1 >Lista de productos</h1>
      
      <ion-button color="secondary" @click="openModal('agregar')">Agregar</ion-button>
      <div class="lista-productos">
        <div class="producto" v-for="producto in productos" :key="producto.id">
          <h2>{{ producto.nombre }}</h2>
          <p><strong>Id :</strong> {{ producto.id }}</p>
          <p><strong>Código :</strong> {{ producto.codigo }}</p>
          <p><strong>Marca :</strong> {{ producto.marca }}</p>
          <p><strong>Precio :</strong> {{ producto.precio }}</p>
          <p><strong>Categoría :</strong> {{ getCategoryName(producto.categoriaId) }}</p>
          <p><strong>Stock:</strong> {{ producto.stock }}</p>
          <ion-button @click="openModal('editar', producto)" color="dark" class="large-button">Editar</ion-button>
          <ion-button @click="eliminarProducto(producto.id)" color="dark" class="large-button">Eliminar</ion-button>
        </div>
      </div>
      <ion-modal :is-open="modalIsOpen">
        <ion-content>
          <!-- Contenido del modal para agregar/editar -->
          <div class="formulario">
            <h2>{{ modalTitle }}</h2>
            <ion-item>
              <ion-label>Id:</ion-label>
              <ion-input v-model="formData.id"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label>Nombre:</ion-label>
              <ion-input v-model="formData.nombre"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label>Código:</ion-label>
              <ion-input v-model="formData.codigo" type="number"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label>Marca: </ion-label>
              <ion-input v-model="formData.marca"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label>Precio:</ion-label>
              <ion-input v-model="formData.precio" type="number"></ion-input>
            </ion-item>
            <ion-item>
              <ion-label>Categoría:</ion-label>
              <ion-select v-model="formData.categoriaId">
                <ion-select-option v-for="category in categories" :key="category.id" :value="category.id">{{ category.nombre }}</ion-select-option>
              </ion-select>
            </ion-item>
            <ion-item>
              <ion-label>Stock:</ion-label>
              <ion-input v-model="formData.stock" type="number"></ion-input>
            </ion-item>
            <ion-button @click="guardarProducto()" color="success" expand="block">{{ modalAction }}</ion-button>
            <ion-button @click="cerrarModal()" color="light" expand="block">Cancelar</ion-button>
          </div>
        </ion-content>
      </ion-modal>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonPage, IonContent, IonButton, IonModal, IonItem, IonInput, IonSelect, IonSelectOption, IonToolbar, IonButtons, IonIcon, IonTitle } from '@ionic/vue';
import axios from 'axios';
import { ref, onMounted } from 'vue';
import * as IonIcons from 'ionicons/icons'; // Importa los iconos de Ionic

const url = 'http://localhost:9000/shopping-car/api/producto';
const categoriesURL = 'http://localhost:9000/shopping-car/api/categorias'; // URL para obtener categorías
const modalIsOpen = ref(false);
const modalTitle = ref('');
const modalAction = ref('');
const formData = ref({
  id: '',
  nombre: '',
  codigo: '',
  marca: '',
  precio: '',
  categoriaId: '',
  stock: ''
});
const productos = ref([]);
const categories = ref([]);

onMounted(() => {
  obtenerProductos();
  obtenerCategorias(); // Llamada para obtener categorías
});

const obtenerProductos = () => {
  axios.get(url)
    .then(response => {
      productos.value = response.data;
    })
    .catch(error => {
      console.error("Estado de la petición: ", error);
      alert('No se pudo obtener la lista de productos');
    });
};

const obtenerCategorias = () => { // Función para obtener categorías
  axios.get(categoriesURL)
    .then(response => {
      categories.value = response.data;
    })
    .catch(error => {
      console.error("Estado de la petición de categorías: ", error);
      alert('No se pudo obtener la lista de categorías');
    });
};

const openModal = (action, producto = null) => {
  if (action === 'agregar') {
    modalTitle.value = 'Agregar Producto';
    modalAction.value = 'Agregar';
    formData.value = {
      id: '',
      nombre: '',
      codigo: '',
      marca: '',
      precio: '',
      categoriaId: '',
      stock: ''
    };
  } else if (action === 'editar' && producto) {
    modalTitle.value = 'Editar Producto';
    modalAction.value = 'Guardar Cambios';
    formData.value = { ...producto };
  }
  modalIsOpen.value = true;
};

const cerrarModal = () => {
  modalIsOpen.value = false;
};

const guardarProducto = () => {
  const data = { ...formData.value };
  delete data.id; // No enviar el ID al crear un nuevo producto

  axios.post(url, data)
    .then(response => {
      obtenerProductos();
      cerrarModal();
    })
    .catch(error => {
      console.error("Estado de la petición: ", error);
      alert('Error al guardar el producto');
    });
};

const eliminarProducto = (id) => {
  axios.delete(`${url}/${id}`)
    .then(response => {
      obtenerProductos();
    })
    .catch(error => {
      console.error("Estado de la petición: ", error);
      alert('Error al eliminar el producto');
    });
};

const getCategoryName = (categoryId) => {
  const category = categories.value.find(cat => cat.id === categoryId);
  return category ? category.nombre : 'Desconocida';
};
</script>



<style scoped>
.lista-productos {
  display: flex;
  flex-wrap: wrap;
}

.producto {
  width: 300px;
  padding: 20px;
  margin: 10px;
  border: 1px solid #ccc;
  border-radius: 10px;
}

.producto h2 {
  margin-bottom: 10px;
}

.producto p {
  margin: 5px 0;
}

.formulario {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border-radius: 10px;
  background-color: #ff9d9d;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* Estilo para los títulos */
h2 {
  color: #333;
  text-align: center;
  margin-bottom: 20px;
}

/* Estilo para los botones */
.boton {
  width: 100%;
  margin-top: 20px;
  padding: 10px;
  border: none;
  border-radius: 5px;
  background-color: #4caf50;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0
}
</style>