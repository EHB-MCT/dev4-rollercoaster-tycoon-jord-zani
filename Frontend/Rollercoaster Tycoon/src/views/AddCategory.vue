<!-- src/views/AddCategory.vue -->
<template>
    <div>
      <h1>Add New Category</h1>
      <form @submit.prevent="addCategory">
        <div>
          <label for="name">Name:</label>
          <input v-model="category.name" id="name" required>
        </div>
        <button type="submit">Add Category</button>
      </form>
      <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script>
  import apiClient from '@/apiClient';
  import 'vue-loading-overlay/dist/css/index.css';
  
  export default {
    name: 'AddCategory',
    data() {
      return {
        category: {
          name: ''
        }
      };
    },
    methods: {
      addCategory() {
        this.error = null;
        apiClient.post('/categories', this.category)
          .then(() => {
            this.$router.push('/categories');
          })
          .catch(error => {
            this.error = 'There was an error adding the category!';
            console.error('There was an error adding the category!', error);
          });
      }
    }
  };
  </script>
  