<template>
  <v-container>
    <h1>Categories</h1>
    <v-row>
      <v-col cols="12">
        <router-link to="/categories/add">
          <v-btn color="primary">Add Category</v-btn>
        </router-link>
      </v-col>
    </v-row>
    <v-row>
      <v-col v-for="category in categories" :key="category.id" cols="12" md="4">
        <v-card>
          <v-list-item-content>
            <v-card-title>
              {{ category.name }}
              <v-icon class="ml-2">{{ getIcon(category.name) }}</v-icon>
            </v-card-title>
          </v-list-item-content>
          <v-card-actions>
            <router-link :to="'/categories/edit/' + category.id">
              <v-btn color="blue">Edit</v-btn>
            </router-link>
            <v-btn @click="deleteCategory(category.id)" color="red">Delete</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
    <v-alert v-if="error" type="error">{{ error }}</v-alert>
  </v-container>
</template>

<script>
import apiClient from '@/apiClient';

export default {
  name: 'Categories',
  data() {
    return {
      categories: [],
      error: null
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
    deleteCategory(id) {
      apiClient.delete(`/categories/${id}`)
        .then(() => {
          this.fetchCategories();
        })
        .catch(error => {
          this.error = 'There was an error deleting the category!';
          console.error('There was an error deleting the category!', error);
        });
    },
    getIcon(categoryName) {
      switch (categoryName) {
        case 'Thrill Rides':
          return 'mdi-fire';
        case 'Family Rides':
          return 'mdi-account-group';
        case 'Water Rides':
          return 'mdi-water';
        case 'Shows':
          return 'mdi-theater';
        default:
          return 'mdi-human-greeting';
      }
    }
  }
};
</script>

<style scoped>
.v-list-item-title {
  display: flex;
  align-items: center;
}

.ml-2 {
  margin-left: 10px;
}
</style>
