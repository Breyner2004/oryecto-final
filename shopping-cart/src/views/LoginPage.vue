<template>
  <ion-page>
    <ion-content>
      <div class="background-container"></div>
      <div style="display: flex; flex-direction: column; justify-content: center; align-items: center; position: relative;">
        <!-- Asegúrate de que ImagenComponent esté correctamente implementado -->
        <ImagenComponent id="miImagen" imageUrl="/public/logo.png" altText="imagen" class="logo-image" />
      </div>

      <ion-card class="custom-rounded" color="">
        <div class="segment">
          <ion-segment v-model="selectedOption">
            <ion-segment-button color="light" value="login">
              <ion-label>Login</ion-label>
            </ion-segment-button>
          </ion-segment>
        </div>
        <p class="parafo">holi</p>
        <div v-if="selectedOption === 'login'" class="input">
          <ion-item>
            <InputComponent id="email" name="email" type="email" label="E-mail" placeholder="email@domain.com"
              label-placement="floating" counter="true" v-model="email">
            </InputComponent>
          </ion-item>
          <ion-item>
            <InputComponent id="password" name="password" type="password" placeholder="Password" label="Password"
              label-placement="floating" v-model="password">
            </InputComponent>
          </ion-item>
          <ion-item>
            <ButtonComponent id="login" value="login" fill="solid" color="medium" expand="block" size="large" class="custom-button-width"
              @click="login">
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
.logo-image {
  width: 200px;
  height: auto;
  margin: 0 auto;
}

.input {
  margin-top: 20px;
}

.parafo {
  text-align: center;
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
