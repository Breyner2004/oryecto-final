<template>
    <ion-page>
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-title>Registro de Cliente</ion-title>
          <ion-buttons slot="end">
            <ion-button href="/">
              <ion-icon :icon="IonIcons.homeSharp"></ion-icon>
              <ion-label>Dashboard</ion-label>
            </ion-button>
          </ion-buttons>
        </ion-toolbar>
      </ion-header>
  
      <ion-content fullscreen class="ion-padding">
        <div class="form-container">
          <ion-card>
            <ion-card-header>
              <ion-card-title>Crear Cuenta</ion-card-title>
            </ion-card-header>
  
            <ion-card-content>
              <ion-item>
                <ion-label position="floating">Documento</ion-label>
                <ion-input v-model="documento" type="number" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="floating">Nombre</ion-label>
                <ion-input v-model="nombre" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="floating">Correo</ion-label>
                <ion-input v-model="email" type="email" required></ion-input>
              </ion-item>
              <ion-item>
                <ion-label position="floating">Password</ion-label>
                <ion-input v-model="password" type="password" required></ion-input>
              </ion-item>
  
              <div class="ion-padding-top">
                <ion-button expand="block" @click="createRecord">Registrar</ion-button>
              </div>
            </ion-card-content>
          </ion-card>
        </div>
      </ion-content>
    </ion-page>
  </template>
  
  <script setup lang="ts">
  import { IonPage, IonHeader, IonToolbar, IonTitle, IonButtons, IonButton, IonIcon, IonContent, IonCard, IonCardHeader, IonCardTitle, IonCardContent, IonItem, IonLabel, IonInput } from '@ionic/vue';
  import { ref } from 'vue';
  import * as IonIcons from 'ionicons/icons';
  import axios from 'axios';
  import { showSuccessMessage, showErrorMessage } from '../utils/alerts.js';
  
  const baseURL = 'http://localhost:9000/shopping-car/api/cliente';
  const documento = ref('');
  const nombre = ref('');
  const email = ref('');
  const password = ref('');
  
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
      await showSuccessMessage();
      clearData();
    } catch (error) {
      console.error('Error al crear el registro:', error);
      await showErrorMessage();
    }
  }
  
  function clearData() {
    documento.value = '';
    nombre.value = '';
    email.value = '';
    password.value = '';
  }
  </script>
  
  <style scoped>
  .form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
  }
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
  