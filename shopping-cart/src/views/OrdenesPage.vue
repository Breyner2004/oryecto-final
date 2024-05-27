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

