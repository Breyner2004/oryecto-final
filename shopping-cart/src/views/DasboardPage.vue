<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Opciones</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content fullscreen>
      <div class="options-container">
        <ion-button class="animated-button" expand="block" href="/cliente">
          Editar Usuarios
        </ion-button>
        <ion-button class="animated-button" expand="block" href="/producto">
          Agregar/Editar Productos
        </ion-button>
        <ion-button class="animated-button" expand="block" href="/listap">
          Ver Todos Los Productos
        </ion-button>
        <ion-button class="animated-button" expand="block" href="/rcategoria">
          Agregar Categoría
        </ion-button>
        <ion-button class="animated-button" expand="block" href="/ordenes">
          registrar una Orden
        </ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar, IonButton } from '@ionic/vue';
</script>

<style scoped>
.options-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.animated-button {
  --background: linear-gradient(135deg, #6e8efb, #a777e3);
  --background-hover: linear-gradient(135deg, #a777e3, #6e8efb);
  --border-radius: 12px;
  --box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  --transition: all 0.3s ease;
  margin: 10px;
  width: 80%;
}

.animated-button:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.3);
}
</style>
