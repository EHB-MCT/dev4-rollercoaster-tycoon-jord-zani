<template>
  <v-container>
    <h1>Add New Attraction</h1>
    <v-form ref="form" v-model="valid">
      <v-text-field
        v-model="attraction.name"
        label="Name"
        :rules="[v => !!v || 'Name is required']"
        required
      ></v-text-field>
      <v-select
        v-model="attraction.categoryId"
        :items="categories"
        item-title="name"
        item-value="id"
        label="Category"
        :rules="[v => !!v || 'Category is required']"
        required
      ></v-select>
      <v-text-field
        v-model="attraction.capacity"
        label="Capacity"
        :rules="[v => !!v || 'Capacity is required']"
        required
      ></v-text-field>
      <v-text-field
        v-model="attraction.yearBuilt"
        label="Year Built"
        :rules="[v => !!v || 'Year Built is required']"
        required
      ></v-text-field>
      <v-text-field v-model="attraction.imageUrl" label="Image URL"></v-text-field>
      <v-text-field v-model="attraction.videoUrl" label="Onride Video URL"></v-text-field>
      <v-btn @click="submit" :loading="isLoading">Add Attraction</v-btn>
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
  name: 'AddAttraction',
  components: {
    Loading
  },
  data() {
    return {
      attraction: {
        name: '',
        categoryId: null,
        capacity: '',
        yearBuilt: '',
        imageUrl: '',
        videoUrl: ''
      },
      categories: [],
      isLoading: false,
      error: null,
      valid: false
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
          console.error('Error fetching categories:', error);
        });
    },
    submit() {
      if (this.$refs.form.validate()) {
        this.addAttraction();
      }
    },
    addAttraction() {
      this.error = null;
      this.isLoading = true;
      const newAttraction = {
        name: this.attraction.name,
        category: { id: this.attraction.categoryId },
        capacity: this.attraction.capacity,
        yearBuilt: this.attraction.yearBuilt,
        imageUrl: this.attraction.imageUrl,
        videoUrl: this.attraction.videoUrl
      };
      apiClient.post('/attractions', newAttraction)
        .then(() => {
          this.isLoading = false;
          this.$router.push('/attractions');
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error adding the attraction!';
          console.error('There was an error adding the attraction!', error);
        });
    }
  }
};
</script>
