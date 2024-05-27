<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-button @click="goToDashboard">
            <ion-icon :icon="homeIcon"></ion-icon>
          </ion-button>
        </ion-buttons>
        <ion-title>Lista de Productos</ion-title>
        <ion-buttons slot="end">
          <ion-button @click="goToAddProduct">
            <ion-icon :icon="addIcon"></ion-icon>
          </ion-button>
        </ion-buttons>
      </ion-toolbar>
    </ion-header>
    
    <ion-content class="ion-padding">
      <ion-list>
        <ion-item v-for="product in products" :key="product.id" @click="goToProductDetail(product.id)">
          <ion-label>
            <h2>{{ product.nombre }}</h2>
            <p>{{ product.descripcion }}</p>
            <p>Precio: {{ product.precio }}</p>
          </ion-label>
        </ion-item>
      </ion-list>
    </ion-content>
  </ion-page>
</template>

<script>
import { IonPage, IonHeader, IonToolbar, IonTitle, IonButtons, IonButton, IonIcon, IonContent, IonList, IonItem, IonLabel } from '@ionic/vue';
import { ref, onMounted } from 'vue';
import { addOutline as addIcon, homeOutline as homeIcon } from 'ionicons/icons';
import { useRouter } from 'vue-router';

export default {
  name: 'ProductList',
  components: {
    IonPage,
    IonHeader,
    IonToolbar,
    IonTitle,
    IonButtons,
    IonButton,
    IonIcon,
    IonContent,
    IonList,
    IonItem,
    IonLabel,
  },
  setup() {
    const products = ref([]);
    const router = useRouter();

    const goToAddProduct = () => {
      router.push('/producto');
    };

    const goToProductDetail = (productId) => {
      router.push(`/producto/${productId}`);
    };

    const goToDashboard = () => {
      router.push('/dashboard');
    };

    // Fetch products from API on component mounted
    onMounted(async () => {
      try {
        const response = await fetch('http://localhost:9000/shopping-car/api/producto');
        const data = await response.json();
        products.value = data;
      } catch (error) {
        console.error('Error fetching products:', error);
      }
    });

    return {
      products,
      goToAddProduct,
      goToProductDetail,
      goToDashboard,
      addIcon,
      homeIcon,
    };
  },
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
