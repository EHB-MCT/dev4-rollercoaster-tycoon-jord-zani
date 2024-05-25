<!-- src/views/Attractions.vue -->
<template>
  <v-container>
    <h1>Attractions</h1>
    <router-link to="/attractions/add">Add New Attraction</router-link>
    <ul v-if="!isLoading">
      <li v-for="attraction in attractions" :key="attraction.id">
        {{ attraction.name }}
        <router-link :to="`/attractions/edit/${attraction.id}`">Edit</router-link>
        <router-link :to="`/attractions/${attraction.id}/maintenance`">Maintenance Records</router-link>
      </li>
    </ul>
    <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
    <v-alert v-if="error" type="error">{{ error }}</v-alert>
  </v-container>
</template>

<script>
import apiClient from '@/apiClient';
import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/css/index.css';

export default {
  name: 'Attractions',
  components: {
    Loading
  },
  data() {
    return {
      attractions: [],
      isLoading: false,
      error: null,
    };
  },
  created() {
    this.fetchAttractions();
  },
  methods: {
    fetchAttractions() {
      this.isLoading = true;
      apiClient.get('/api/attractions')
        .then(response => {
          this.attractions = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error fetching the attractions!';
          console.error('There was an error fetching the attractions!', error);
        });
    }
  }
};
</script>
