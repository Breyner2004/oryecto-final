import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue'
import ClientePage from '../views/ClientePage.vue'
import LoginPage from '../views/LoginPage.vue'
import DasboardPage from '../views/DasboardPage.vue'
import ProductoPage from '@/views/ProductoPage.vue';
import RCategoriaPage from '@/views/RCategoriaPage.vue';
import RClientesPage from '@/views/RClientesPage.vue';
import OrdenesPage from '@/views/OrdenesPage.vue';
import ListaPPage from '@/views/ListaPPage.vue';
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },{
    path: '/cliente',
    name: 'Cliente',
    component: ClientePage
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginPage
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: DasboardPage
  },
  {
    path: '/producto',
    name: 'Producto',
    component: ProductoPage
  },
  {
    path: '/rcategoria',
    name: 'RCategoria',
    component: RCategoriaPage
  },
  {
    path: '/rcliente',
    name: 'RCliente',
    component: RClientesPage
  },
  {
    path: '/ordenes',
    name: 'Ordenes',
    component: OrdenesPage
  },
  {
    path: '/listap',
    name: 'ListaP',
    component: ListaPPage
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
