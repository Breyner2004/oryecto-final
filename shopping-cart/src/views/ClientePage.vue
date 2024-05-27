<template>
  <ion-page @ionViewDidEnter="findAllRecords">
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Carrito de compra</ion-title>
        <ion-buttons slot="end">
          <ion-button href="/dashboard">
            <ion-icon :icon="IonIcons.homeSharp"></ion-icon>
            
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
  
    <ion-content fullscreen>
      <div id="container">
        <div class="nuevo-registro">
          <ion-button @click="openModalAdd"><ion-icon :icon="IonIcons.addSharp"></ion-icon></ion-button>
        </div>

        <!-- Modal para agregar o editar registros -->
        <ion-modal :is-open="modalIsOpen" @didDismiss="modalIsOpen = false" :css-class="['my-custom-modal']">
          <div class="modal-content">
            <div id="data-form">
              
              <InputComponent v-model="documento" type="number" id="documento" name="documento" label="Documento: " />
              <InputComponent v-model="nombre" id="nombre" name="nombre" label="Nombre: " />
              <InputComponent v-model="email" id="email" name="email" label="Correo: " />
              <InputComponent v-model="password" id="password" name="password" label="Password: " />
            </div>
            <div>
              <!-- Botones de CRUD dentro del modal -->
              <CrudButtonComponent :showFind="showFind" :showCreated="showCreated" :showUpdated="showUpdated"
                :showDeleted="showDeleted" @findAllRecords="findAllRecords" @createRecord="createRecord"
                @updateRecord="updateRecord" @deleteRecordPhysical="deleteRecordPhysical" />
            </div>
          </div>
        </ion-modal>


        <!-- Mostrar datos -->
        <div class="table-container">
          <ion-list>
            <!-- Iterar sobre items para mostrar los datos en tarjetas -->
            <ion-card v-for="(item, index) in items" :key="index" class="card-width">
              <ion-card-content>
                <ion-item>
                  <ion-label>Documento: </ion-label>
                  <ion-label>{{ item.documento }}</ion-label>
                </ion-item>
                <ion-item>
                  <ion-label>Nombre: </ion-label>
                  <ion-label>{{ item.nombre }}</ion-label>
                </ion-item>
                <ion-item>
                  <ion-label>Email: </ion-label>
                  <ion-label>{{ item.email }}</ion-label>
                </ion-item>
                <ion-item>
                  <ion-label>Password: </ion-label>
                  <ion-label>********</ion-label>
                </ion-item>
              </ion-card-content>
              <ion-item>
                <!-- Botones de editar y eliminar -->
                <ion-button @click="findById(item.id)">
                  <ion-icon :icon="IonIcons.createOutline"></ion-icon>
                </ion-button>
                <ion-button @click="deleteRecordPhysical(item.id)">
                  <ion-icon :icon="IonIcons.trash"></ion-icon>
                </ion-button>
              </ion-item>
            </ion-card>
          </ion-list>
        </div>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonIcon, IonModal } from '@ionic/vue';
import InputComponent from '@/components/InputComponent.vue';
import CrudButtonComponent from '@/components/CrudButtonComponent.vue';
import { showSuccessMessage, showErrorMessage } from '../utils/alerts.js';
import { onMounted, ref } from 'vue';
import * as IonIcons from 'ionicons/icons';
import axios from 'axios';


// Rutas de la API
const baseURL = 'http://localhost:9000/shopping-car/api/cliente';
const modalIsOpen = ref(false);
const items = ref<Array<ItemType>>([]);
const id = ref('');
const documento = ref('');
const nombre = ref('');
const email = ref('');
const password = ref('');

const showFind = ref<boolean>(false);
const showCreated = ref<boolean>(true);
const showUpdated = ref<boolean>(false);
const showDeleted = ref<boolean>(false);


// Tipos
interface ItemType {
  id: string;
  tipoDocumento: string;
  documento: string;
  nombre: string;
  email: string;
  password: string;
}

onMounted(() => {
  findAllRecords();
});

// Métodos
async function findAllRecords() {
  try {
    const response = await axios.get(baseURL);
    items.value = response.data;
  } catch (error) {
    console.error('Error al obtener todos los registros:', error);
    throw error;
  }
}

//Cargar los datos para edición
async function findById(recordId: string) {
  try {
    await openModalAdd();
    const response = await axios.get(`${baseURL}/${recordId}`);
    const data = response.data;

    id.value = data.id;
    documento.value = data.documento;
    nombre.value = data.nombre;
    email.value = data.email;
    password.value = data.password;

    // Controlar la visibilidad de los botones
    showCreated.value = false;
    showUpdated.value = true;


  } catch (error) {
    console.error('Error al encontrar el registro por ID:', error);
    throw error;
  }
}

async function createRecord() {
  const data = {
    documento: documento.value,
    nombre: nombre.value,
    email: email.value,
    password: password.value
  };

  try {
    const response = await axios.post(baseURL, data);
    console.log('Registro creado exitosamente:', response.data);
    await findAllRecords();
    await clearData();
    await showSuccessMessage();
    await closeModal();
  } catch (error) {
    console.error('Error al crear el registro:', error);
    await showErrorMessage();
  }
}

async function updateRecord() {
  const data = {
    id: id.value,
    documento: documento.value,
    nombre: nombre.value,
    email: email.value,
    password: password.value
  };

  try {
    const response = await axios.put(`${baseURL}/${data.id}`, data);
    console.log('Registro actualizado exitosamente:', response.data, id);

    await findAllRecords();
    await clearData();

    showCreated.value = true;
    showUpdated.value = false;

    await closeModal();

    return response.data;
  } catch (error) {
    console.error('Error al actualizar el registro:', error);
    throw error;
  }
}


async function deleteRecordPhysical(id: String) {
  try {
    const response = await axios.delete(`${baseURL}/${id}`);
    await findAllRecords();
    return response.data;
  } catch (error) {
    console.error('Error al eliminar el registro físico:', error);
    throw error;
  }
}



async function clearData() {
  documento.value = '';
  nombre.value = '';
  email.value = '';
  password.value = '';
}


const openModalAdd = () => {
  modalIsOpen.value = true;
};

const closeModal = () => {
  modalIsOpen.value = false;
};
</script>

<style scoped>
  /* Estilos generales */
  body {
    background-color: #333; /* Fondo oscuro */
    color: white; /* Texto blanco */
  }

  /* Estilos para dispositivos móviles */
  @media only screen and (max-width: 600px) {
    .container {
      padding: 8px; /* Reducir el padding en pantallas pequeñas */
    }

    .modal-content {
      padding: 8px; /* Reducir el padding del modal en pantallas pequeñas */
    }

    .card-width {
      margin-bottom: 8px; /* Reducir el margen inferior de las tarjetas en pantallas pequeñas */
    }
  }

  /* Estilos específicos para modo oscuro */
  .dark-mode {
    background-color: #333; /* Fondo oscuro */
    color: white; /* Texto blanco */
  }

  .dark-mode ion-button {
    --background: #ff4d4d; /* Color de fondo rojo */
    --color: white; /* Color del texto blanco */
  }

  .dark-mode ion-button:hover {
    --background: #ff3333; /* Cambio de color al pasar el ratón */
  }

  .dark-mode ion-item {
    --background: #444; /* Fondo del item */
    --color: white; /* Color del texto blanco */
  }

  .dark-mode ion-label {
    color: white; /* Color del texto blanco */
  }

  .dark-mode ion-input {
    --background: #555; /* Fondo del input */
    --color: white; /* Color del texto blanco */
  }

  .dark-mode ion-card {
    --background: #555; /* Fondo de la tarjeta */
    --border-radius: 10px; /* Radio de borde de la tarjeta */
    --box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Sombra de la tarjeta */
  }

  .dark-mode ion-card-header {
    --background: #666; /* Fondo del encabezado de la tarjeta */
    --color: white; /* Color del texto del encabezado de la tarjeta */
  }

  .dark-mode ion-card-title {
    --color: white; /* Color del título de la tarjeta */
  }

  .dark-mode ion-card-content {
    --color: white; /* Color del contenido de la tarjeta */
  }

  .dark-mode .ion-padding {
    padding: 16px; /* Añadir relleno */
  }

  .dark-mode .ion-padding-top {
    padding-top: 16px; /* Añadir relleno en la parte superior */
  }

  .dark-mode .ion-padding-bottom {
    padding-bottom: 16px; /* Añadir relleno en la parte inferior */
  }

  .dark-mode .ion-padding-horizontal {
    padding-left: 16px; /* Añadir relleno horizontal */
    padding-right: 16px;
  }

  .dark-mode .ion-padding-vertical {
    padding-top: 16px; /* Añadir relleno vertical */
    padding-bottom: 16px;
  }

  .dark-mode .ion-padding-start {
    padding-left: 16px; /* Añadir relleno en el inicio (izquierda) */
  }

  .dark-mode .ion-padding-end {
    padding-right: 16px; /* Añadir relleno en el final (derecha) */
  }

  .dark-mode .container {
    padding: 16px; /* Añadir relleno al contenedor principal */
  }

  .dark-mode .product-item {
    margin-bottom: 16px; /* Margen inferior para cada elemento de producto */
  }
</style>
