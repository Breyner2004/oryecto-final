<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <!-- Coloca el logo en el centro del encabezado -->
        <ion-title>
         easystore
        </ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content class="ion-padding">
      <div id="home-container">
        <img src="C:\Users\PROPIETARIO\Desktop\oryecto-final\shopping-cart\src\theme\the-business-of-fashion-bof-logo-B19514A78D-seeklogo.com.png" alt="Easy Store Logo" class="logo" />
        <h1>Bienvenido a Easy Store</h1>
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

  /* Estilos para el logo */
  .logo {
    max-width: 200px; /* Tamaño máximo del logo */
    display: block; /* Hacer que el logo se centre */
    margin: 0 auto; /* Centrar el logo horizontalmente */
    margin-top: 20px; /* Espacio superior para separar del contenido */
  }
</style>
