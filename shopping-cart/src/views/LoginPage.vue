<template>
  <ion-page>
    <ion-content class="dark-mode">
      <div class="logo-container">
        <!-- Asegúrate de que ImagenComponent esté correctamente implementado -->
        <center><img src="C:\Users\PROPIETARIO\Desktop\oryecto-final\shopping-cart\src\theme\the-business-of-fashion-bof-logo-B19514A78D-seeklogo.com.png" alt="Easy Store Logo" class="logo" /></center>
      </div>

      <ion-card class="custom-rounded" color="dark">
        <div class="segment">
          <ion-segment v-model="selectedOption" color="danger">
            <ion-segment-button value="login">
              <ion-label>Login</ion-label>
            </ion-segment-button>
          </ion-segment>
        </div>

        <div v-if="selectedOption === 'login'" class="input">
          <ion-item lines="none">
            <InputComponent id="email" name="email" type="email" label="E-mail" placeholder="email@domain.com"
              label-placement="floating" counter="true" v-model="email">
            </InputComponent>
          </ion-item>

          <ion-item lines="none">
            <InputComponent id="password" name="password" type="password" placeholder="Password" label="Password"
              label-placement="floating" v-model="password">
            </InputComponent>
          </ion-item>

          <ion-item lines="none">
            <ButtonComponent id="login" value="login" fill="outline" color="danger" expand="block" size="large"
              class="custom-button-width" @click="login">
              Login
            </ButtonComponent>
          </ion-item>
        </div>
      </ion-card>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonPage } from '@ionic/vue';
import InputComponent from '@/components/InputComponent.vue';
import ButtonComponent from '@/components/ButtonComponent.vue';
import axios from 'axios';
import { ref } from 'vue';

const selectedOption = ref('login');
const email = ref('');
const password = ref('');

const login = async () => {
  try {
    const response = await axios.post('http://localhost:9000/shopping-car/api/cliente/validar', {
      email: email.value,
      password: password.value
    });

    if (response.status === 200) {
      // Redirigir al usuario a la página de dashboard
      window.location.href = '/dashboard';
    } else {
      alert('Usuario o contraseña incorrectos');
    }
  } catch (error) {
    console.error(error);
    alert('Error');
  }
}
</script>

<style scoped>
/* Estilos generales */
body {
  background-color: #333; /* Fondo oscuro */
  color: rgb(0, 0, 0); /* Texto blanco */
}

.dark-mode {
  background-color: #333; /* Fondo oscuro */
  color: white; /* Texto blanco */
}

.dark-mode ion-button {
  --background: #ff4d4d; /* Color de fondo rojo */
  --color: rgb(255, 146, 146); /* Color del texto blanco */
}

.dark-mode ion-button:hover {
  --background: #ff3333; /* Cambio de color al pasar el ratón */
}

.dark-mode ion-item {
  --background: #444; /* Fondo del item */
  --color: rgb(0, 0, 0); /* Color del texto blanco */
}

.dark-mode ion-label {
  color: rgb(0, 0, 0); /* Color del texto blanco */
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
  --color: rgb(0, 0, 0); /* Color del texto del encabezado de la tarjeta */
}

.dark-mode ion-card-title {
  --color: rgb(253, 179, 179); /* Color del título de la tarjeta */
}

.dark-mode ion-card-content {
  --color: rgb(255, 109, 109); /* Color del contenido de la tarjeta */
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