<!-- src/views/AddCategory.vue -->
<template>
  <v-container>
    <h1>Add New Category</h1>
    <v-form @submit.prevent="addCategory">
      <v-text-field v-model="category.name" label="Name" required></v-text-field>
      <v-btn type="submit" :loading="isLoading">Add Category</v-btn>
    </v-form>
    <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
    <v-alert v-if="error" type="error">{{ error }}</v-alert>
  </v-container>
</template>

<script>
import apiClient from '@/apiClient';
import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/css/index.css';

export default {
  name: 'AddCategory',
  components: {
    Loading
  },
  data() {
    return {
      category: {
        name: ''
      },
      isLoading: false,
      error: null
    };
  },
  methods: {
    addCategory() {
      this.error = null;
      this.isLoading = true;
      apiClient.post('/categories', this.category)
        .then(() => {
          this.isLoading = false;
          this.$router.push('/categories');
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error adding the category!';
          console.error('There was an error adding the category!', error);
        });
    }
  }
};
</script>
