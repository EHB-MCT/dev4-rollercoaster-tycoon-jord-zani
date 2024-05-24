<!-- src/views/Categories.vue -->
<template>
  <v-container>
    <h1>Categories</h1>
    <router-link to="/categories/add">Add New Category</router-link>
    <v-list v-if="!isLoading">
      <v-list-item v-for="category in categories" :key="category.id">
        <v-list-item-content>
          <v-list-item-title>{{ category.name }}</v-list-item-title>
        </v-list-item-content>
        <v-list-item-action>
          <v-btn small color="primary" @click="editCategory(category.id)">Edit</v-btn>
          <v-btn small color="error" @click="deleteCategory(category.id)">Delete</v-btn>
        </v-list-item-action>
      </v-list-item>
    </v-list>
    <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
    <v-alert v-if="error" type="error">{{ error }}</v-alert>
  </v-container>
</template>

<script>
import apiClient from '@/apiClient';
import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/css/index.css';

export default {
  name: 'Categories',
  components: {
    Loading
  },
  data() {
    return {
      categories: [],
      isLoading: false,
      error: null
    };
  },
  created() {
    this.fetchCategories();
  },
  methods: {
    fetchCategories() {
      this.isLoading = true;
      apiClient.get('/categories')
        .then(response => {
          this.categories = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error fetching the categories!';
          console.error('There was an error fetching the categories!', error);
        });
    },
    editCategory(id) {
      this.$router.push(`/categories/edit/${id}`);
    },
    deleteCategory(id) {
      this.isLoading = true;
      apiClient.delete(`/categories/${id}`)
        .then(() => {
          this.fetchCategories();
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error deleting the category!';
          console.error('There was an error deleting the category!', error);
        });
    }
  }
};
</script>
