<template>
  <v-container>
    <h1>Attractions</h1>
    <router-link to="/attractions/add">
      <v-btn color="primary" class="mb-4">
        Add New Attraction
      </v-btn>
    </router-link>
    <v-row>
      <v-col
        v-for="attraction in attractions"
        :key="attraction.id"
        cols="12"
        sm="6"
        md="4"
        class="mb-4"
      >
        <v-card>
          <v-img
            :src="attraction.imageUrl"
            height="200px"
            class="fill-image"
            cover
          ></v-img>
          <v-card-title>{{ attraction.name }}</v-card-title>
          <v-card-actions>
            <router-link :to="`/attractions/edit/${attraction.id}`">
              <v-btn text color="primary">Edit</v-btn>
            </router-link>
            <router-link :to="`/attractions/${attraction.id}/maintenance`">
              <v-btn text color="primary">Maintenance Records</v-btn>
            </router-link>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
    <loading v-model:active="isLoading" :is-full-page="true"></loading>
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
      error: null
    };
  },
  created() {
    this.fetchAttractions();
  },
  methods: {
    fetchAttractions() {
      this.isLoading = true;
      apiClient.get('/attractions')
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

<style scoped>
.v-card {
  border-radius: 15px;
}
.v-card-title {
  font-weight: bold;
}
.fill-image {
  object-fit: cover;
}
h1 {
  font-family: 'Roboto', sans-serif;
  font-size: 2.5rem;
  color: #3f51b5;
  text-align: center;
  margin-bottom: 1.5rem;
}
.v-btn {
  margin: 0.5rem;
}
</style>
