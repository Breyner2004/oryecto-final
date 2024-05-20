<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Dashboard</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content>
      <br>
      <div id="container">
        <strong><a href="/editar">Ir a editar usuarios</a></strong>
        <br>
        <strong><a href="/producto">Ir agregar o editar productos</a></strong>

      </div>

    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/vue';
</script>


<style scoped src="../theme/container.css"></style>