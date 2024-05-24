import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/views/Home.vue';
import Attractions from '@/views/Attractions.vue';
import AddAttraction from '@/views/AddAttraction.vue';
import EditAttraction from '@/views/EditAttraction.vue';
import Categories from '@/views/Categories.vue';
import AddCategory from '@/views/AddCategory.vue';
import EditCategory from '@/views/EditCategory.vue';
import MaintenanceRecords from '@/views/MaintenanceRecords.vue';
import AddMaintenanceRecord from '@/views/AddMaintenanceRecord.vue';
import process from 'process';

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/attractions',
    name: 'Attractions',
    component: Attractions
  },
  {
    path: '/attractions/add',
    name: 'AddAttraction',
    component: AddAttraction
  },
  {
    path: '/attractions/edit/:id',
    name: 'EditAttraction',
    component: EditAttraction
  },
  {
    path: '/categories',
    name: 'Categories',
    component: Categories
  },
  {
    path: '/categories/add',
    name: 'AddCategory',
    component: AddCategory
  },
  {
    path: '/categories/edit/:id',
    name: 'EditCategory',
    component: EditCategory
  },
  {
    path: '/attractions/:id/maintenance',
    name: 'MaintenanceRecords',
    component: MaintenanceRecords
  },
  {
    path: '/maintenance/add/:id',
    name: 'AddMaintenanceRecord',
    component: AddMaintenanceRecord
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

export default router;
