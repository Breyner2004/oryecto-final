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
/* Add your scoped styles here */
</style>
