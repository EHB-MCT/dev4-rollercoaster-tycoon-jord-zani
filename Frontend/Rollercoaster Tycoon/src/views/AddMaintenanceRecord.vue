<template>
  <v-container>
    <h1>Add Maintenance Record for {{ attraction.name }}</h1>
    <v-form @submit.prevent="addMaintenanceRecord">
      <v-text-field v-model="maintenance.date" label="Date" required type="date"></v-text-field>
      <v-text-field v-model="maintenance.description" label="Description" required></v-text-field>
      <v-btn type="submit" :loading="isLoading">Add Record</v-btn>
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
  name: 'AddMaintenanceRecord',
  components: {
    Loading
  },
  data() {
    return {
      attraction: {},
      maintenance: {
        date: '',
        description: '',
        resolved: false
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
    addMaintenanceRecord() {
      this.error = null;
      this.isLoading = true;
      const id = this.$route.params.id;
      apiClient.post(`/attractions/${id}/maintenance`, this.maintenance)
        .then(() => {
          this.isLoading = false;
          this.$router.push(`/attractions/${id}/maintenance`);
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error adding the maintenance record!';
          console.error('There was an error adding the maintenance record!', error);
        });
    }
  }
};
</script>
