<!-- src/views/EditAttraction.vue -->
<template>
    <div>
      <h1>Edit Attraction</h1>
      <form @submit.prevent="editAttraction">
        <div>
          <label for="name">Name:</label>
          <input v-model="attraction.name" id="name" required>
        </div>
        <div>
          <label for="category">Category:</label>
          <input v-model="attraction.category" id="category" required>
        </div>
        <div>
          <label for="capacity">Capacity:</label>
          <input v-model="attraction.capacity" id="capacity" required>
        </div>
        <div>
          <label for="yearBuilt">Year Built:</label>
          <input v-model="attraction.yearBuilt" id="yearBuilt" required>
        </div>
        <div>
          <label for="imageUrl">Image URL:</label>
          <input v-model="attraction.imageUrl" id="imageUrl">
        </div>
        <div>
          <label for="videoUrl">Onride Video URL:</label>
          <input v-model="attraction.videoUrl" id="videoUrl">
        </div>
        <button type="submit" :disabled="isLoading">Save Changes</button>
      </form>
    <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
      <p v-if="error">{{ error }}</p>
    </div>
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
  