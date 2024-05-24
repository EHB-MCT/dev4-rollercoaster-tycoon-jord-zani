<!-- src/views/EditCategory.vue -->
<template>
  <v-container>
    <h1>Edit Category</h1>
    <v-form @submit.prevent="editCategory">
      <v-text-field v-model="category.name" label="Name" required></v-text-field>
      <v-btn type="submit" :loading="isLoading">Save Changes</v-btn>
    </v-form>
    <loading v-model:active="isLoading" :is-full-page="true"></loading>
    <v-alert v-if="error" type="error">{{ error }}</v-alert>
  </v-container>
</template>

<script>
import apiClient from '@/apiClient';
import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/css/index.css';

export default {
  name: 'EditCategory',
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
  created() {
    const id = this.$route.params.id;
    this.isLoading = true;
    apiClient.get(`/categories/${id}`)
      .then(response => {
        this.category = response.data;
        this.isLoading = false;
      })
      .catch(error => {
        this.isLoading = false;
        this.error = 'There was an error fetching the category!';
        console.error('There was an error fetching the category!', error);
      });
  },
  methods: {
    editCategory() {
      this.error = null;
      this.isLoading = true;
      const id = this.$route.params.id;
      apiClient.put(`/categories/${id}`, this.category)
        .then(() => {
          this.isLoading = false;
          this.$router.push('/categories');
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error editing the category!';
          console.error('There was an error editing the category!', error);
        });
    }
  }
};
</script>
