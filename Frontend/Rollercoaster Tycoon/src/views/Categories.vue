<!-- src/views/Categories.vue -->
<template>
    <div>
      <h1>Categories</h1>
      <router-link to="/categories/add">Add New Category</router-link>
      <ul>
        <li v-for="category in categories" :key="category.id">
          {{ category.name }}
          <button @click="editCategory(category.id)">Edit</button>
          <button @click="deleteCategory(category.id)">Delete</button>
        </li>
      </ul>
      <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script>
  import apiClient from '@/apiClient';
  import 'vue-loading-overlay/dist/css/index.css';
  
  export default {
    name: 'Categories',
    data() {
      return {
        categories: []
      };
    },
    created() {
      this.fetchCategories();
    },
    methods: {
      fetchCategories() {
        apiClient.get('/categories')
          .then(response => {
            this.categories = response.data;
          })
          .catch(error => {
            this.error = 'There was an error fetching the categories!';
            console.error('There was an error fetching the categories!', error);
          });
      },
      editCategory(id) {
        this.$router.push(`/categories/edit/${id}`);
      },
      deleteCategory(id) {
        this.error = null;
        apiClient.delete(`/categories/${id}`)
          .then(() => {
            this.fetchCategories();
          })
          .catch(error => {
            this.error = 'There was an error deleting the attraction!';
            console.error('There was an error deleting the category!', error);
          });
      }
    }
  };
  </script>
  