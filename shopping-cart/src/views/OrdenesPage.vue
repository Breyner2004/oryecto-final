<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Ordenes</ion-title>
        <ion-buttons slot="start">
          <ion-button @click="goToDashboard">
            <ion-icon :icon="homeIcon"></ion-icon>
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>

    <ion-content fullscreen>
      <div class="container">
        <div class="order-form">
          <!-- Renderizar cada producto en el formulario -->
          <div class="product-item" v-for="(product, index) in order.products" :key="index">
            <ion-input v-model="product.id" placeholder="ID del producto"></ion-input>
            <ion-input v-model="product.stock" type="number" placeholder="Stock"></ion-input>
            <ion-button @click="removeProduct(index)">Eliminar</ion-button>
          </div>
          <ion-button @click="addProduct">Agregar Producto</ion-button>
        </div>
        <!-- Botón para guardar la orden -->
        <ion-button @click="saveOrder">Guardar Orden</ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { IonPage, IonHeader, IonToolbar, IonTitle, IonButtons, IonButton, IonIcon, IonContent, IonInput } from '@ionic/vue';
import { homeOutline as homeIcon } from 'ionicons/icons';
import axios from 'axios';

// URL base de tu backend
const baseURL = 'http://localhost:9000/shopping-car/api/ordenes';
// Estado reactivado para almacenar los productos de la orden
const order = ref({
  products: [{ id: '', stock: 0 }]
});

// Enrutador de Vue
const router = useRouter();

// Función para agregar un nuevo producto al formulario
const addProduct = () => {
  order.value.products.push({ id: '', stock: 0 });
};

// Función para eliminar un producto del formulario
const removeProduct = (index) => {
  order.value.products.splice(index, 1);
};

// Función para guardar la orden
const saveOrder = async () => {
  try {
    // Realizar la solicitud POST al backend
    const response = await axios.post(baseURL, order.value.products);
    console.log('Orden guardada exitosamente:', response.data);
    // Aquí podrías mostrar un mensaje de éxito o redirigir a otra página
  } catch (error) {
    console.error('Error al guardar la orden:', error);
    // Aquí podrías mostrar un mensaje de error al usuario
  }
};

// Función para redirigir al dashboard
const goToDashboard = () => {
  // Redireccionar al dashboard
  router.push('/dashboard');
};
</script>

<style scoped>
.container {
  padding: 16px;
}

.product-item {
  margin-bottom: 16px;
}
</style>
