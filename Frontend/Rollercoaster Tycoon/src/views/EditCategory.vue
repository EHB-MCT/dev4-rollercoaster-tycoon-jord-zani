<!-- src/views/EditCategory.vue -->
<template>
    <div>
      <h1>Edit Category</h1>
      <form @submit.prevent="editCategory">
        <div>
          <label for="name">Name:</label>
          <input v-model="category.name" id="name" required>
        </div>
        <button type="submit">Save Changes</button>
      </form>
      <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script>
  import apiClient from '@/apiClient';
  import 'vue-loading-overlay/dist/css/index.css';
  
  export default {
    name: 'EditCategory',
    data() {
      return {
        category: {
          name: ''
        }
      };
    },
    created() {
      const id = this.$route.params.id;
      apiClient.get(`/categories/${id}`)
        .then(response => {
          this.category = response.data;
        })
        .catch(error => {
            this.error = 'There was an error fetching the category!';
          console.error('There was an error fetching the category!', error);
        });
    },
    methods: {
      editCategory() {
        this.error = null;
        const id = this.$route.params.id;
        apiClient.put(`/categories/${id}`, this.category)
          .then(() => {
            this.$router.push('/categories');
          })
          .catch(error => {
            this.error = 'There was an error editing the category!';
            console.error('There was an error editing the category!', error);
          });
      }
    }
  };
  </script>
  