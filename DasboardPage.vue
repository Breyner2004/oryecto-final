<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-accordion-group>
        <ion-accordion value="opciones">
          <ion-item slot="header" color="light">
            <ion-label>Opciones</ion-label>
          </ion-item>
          <div class="ion-padding" slot="content">
            <ion-button expand="block" href="/editar">Editar Usuarios</ion-button>
            <ion-button expand="block" href="/producto">Agregar/Editar Productos</ion-button>
          </div>
        </ion-accordion>
      </ion-accordion-group>
      </ion-toolbar>
    </ion-header>

    <ion-content>
      <ion-searchbar placeholder="Buscar..."></ion-searchbar>
     

      <div id="container">
        <ion-grid>
          <ion-row>
            <ion-col size="6" size-md="3" v-for="product in products" :key="product.id">
              <ion-card>
                <img :src="product.image" />
                <ion-card-header>
                  <ion-card-title>{{ product.title }}</ion-card-title>
                </ion-card-header>
                <ion-card-content>
                  {{ product.description }}
                </ion-card-content>
              </ion-card>
            </ion-col>
          </ion-row>
        </ion-grid>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonSearchbar, IonAccordionGroup, IonAccordion, IonItem, IonLabel, IonButton, IonGrid, IonRow, IonCol, IonCard, IonCardHeader, IonCardTitle, IonCardContent } from '@ionic/vue';

const products = ref([
  {
    id: 1,
    title: 'Producto 1',
    description: 'Descripción del producto 1',
    image: 'https://via.placeholder.com/150'
  },
  {
    id: 2,
    title: 'Producto 2',
    description: 'Descripción del producto 2',
    image: 'https://via.placeholder.com/150'
  },
  {
    id: 3,
    title: 'Producto 3',
    description: 'Descripción del producto 3',
    image: 'https://via.placeholder.com/150'
  },
  {
    id: 4,
    title: 'Producto 4',
    description: 'Descripción del producto 4',
    image: 'https://via.placeholder.com/150'
  }
]);
</script>

<style scoped>
#container {
  padding: 16px;
}

ion-card {
  margin: 8px;
}
</style>
