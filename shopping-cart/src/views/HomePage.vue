<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Bienvenido</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content class="ion-padding">
      <div id="home-container">
        <h1>Bienvenido a Nuestra Aplicación</h1>
        <ion-button expand="block" href="/rcliente">Registrarse</ion-button>
        <ion-button expand="block" href="/login">Iniciar Sesión</ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButton } from '@ionic/vue';
</script>


<style scoped>
#container {
  padding: 16px;
}

.nuevo-registro {
  margin-bottom: 16px;
}

.card-width {
  margin-bottom: 16px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.modal-content {
  padding: 16px;
  border-radius: 10px;
  background-color: #ffffff;
}

#data-form ion-item {
  margin-bottom: 16px;
}

ion-item ion-label {
  font-weight: bold;
}

table-container ion-list ion-card ion-card-content {
  padding: 16px;
}

ion-item ion-button {
  --background: #4caf50;
  --background-hover: #43a047;
  --color: #ffffff;
}

ion-item ion-button:hover {
  --background: #43a047;
}

</style>
