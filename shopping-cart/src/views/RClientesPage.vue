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
        <center><img src="C:\Users\PROPIETARIO\Desktop\oryecto-final\shopping-cart\src\theme\the-business-of-fashion-bof-logo-B19514A78D-seeklogo.com.png" alt="Easy Store Logo" class="logo" /></center>
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
  /* Estilos generales */
  body {
    background-color: #333; /* Fondo oscuro */
    color: white; /* Texto blanco */
  }

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

  .dark-mode .form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
  }
</style>
