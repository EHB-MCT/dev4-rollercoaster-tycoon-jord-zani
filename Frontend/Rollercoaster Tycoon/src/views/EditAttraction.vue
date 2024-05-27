<template>
  <v-container>
    <h1>Edit Attraction</h1>
    <v-form @submit.prevent="editAttraction">
      <v-text-field v-model="attraction.name" label="Name" required></v-text-field>
      <v-text-field v-model="attraction.category" label="Category" required></v-text-field>
      <v-text-field v-model="attraction.capacity" label="Capacity" required></v-text-field>
      <v-text-field v-model="attraction.yearBuilt" label="Year Built" required></v-text-field>
      <v-text-field v-model="attraction.imageUrl" label="Image URL"></v-text-field>
      <v-text-field v-model="attraction.videoUrl" label="Onride Video URL"></v-text-field>
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
  name: 'EditAttraction',
  components: {
    Loading
  },
  data() {
    return {
      attraction: {
        name: '',
        category: '',
        capacity: '',
        yearBuilt: '',
        imageUrl: '',
        videoUrl: ''
      },
      isLoading: false,
      error: null
    };
  },
  created() {
    const id = this.$route.params.id;
    this.isLoading = true;
    apiClient.get(`/attractions/${id}`)
      .then(response => {
        this.attraction = response.data;
        this.isLoading = false;
      })
      .catch(error => {
        this.isLoading = false;
        this.error = 'There was an error fetching the attraction!';
        console.error('There was an error fetching the attraction!', error);
      });
  },
  methods: {
    editAttraction() {
      this.error = null;
      this.isLoading = true;
      const id = this.$route.params.id;
      apiClient.put(`/attractions/${id}`, this.attraction)
        .then(() => {
          this.isLoading = false;
          this.$router.push('/attractions');
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error editing the attraction!';
          console.error('There was an error editing the attraction!', error);
        });
    }
  }
};
</script>
