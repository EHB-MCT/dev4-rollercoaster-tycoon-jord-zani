<!-- src/views/MaintenanceRecords.vue -->
<template>
  <v-container>
    <h1>Maintenance Records for {{ attraction.name }}</h1>
    <router-link :to="`/maintenance/add/${attraction.id}`">Add Maintenance Record</router-link>
    <ul v-if="!isLoading">
      <li v-for="record in maintenanceRecords" :key="record.id">
        {{ record.date }} - {{ record.description }} - {{ record.resolved ? 'Resolved' : 'Unresolved' }}
        <v-btn @click="resolveRecord(record.id)" v-if="!record.resolved">Resolve</v-btn>
      </li>
    </ul>
    <loading v-model:active="isLoading" :is-full-page="true"></loading>
    <v-alert v-if="error" type="error">{{ error }}</v-alert>
  </v-container>
</template>

<script>
import apiClient from '@/apiClient';
import Loading from 'vue-loading-overlay';
import 'vue-loading-overlay/dist/css/index.css';

export default {
  name: 'MaintenanceRecords',
  components: {
    Loading
  },
  data() {
    return {
      attraction: {},
      maintenanceRecords: [],
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
        this.fetchMaintenanceRecords(id);
      })
      .catch(error => {
        this.isLoading = false;
        this.error = 'There was an error fetching the attraction!';
        console.error('There was an error fetching the attraction!', error);
      });
  },
  methods: {
    fetchMaintenanceRecords(attractionId) {
      this.isLoading = true;
      apiClient.get(`/attractions/${attractionId}/maintenance`)
        .then(response => {
          this.maintenanceRecords = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error fetching the maintenance records!';
          console.error('There was an error fetching the maintenance records!', error);
        });
    },
    resolveRecord(recordId) {
      this.isLoading = true;
      apiClient.put(`/maintenance/${recordId}/resolve`)
        .then(() => {
          this.fetchMaintenanceRecords(this.attraction.id);
          this.isLoading = false;
        })
        .catch(error => {
          this.isLoading = false;
          this.error = 'There was an error resolving the maintenance record!';
          console.error('There was an error resolving the maintenance record!', error);
        });
    }
  }
};
</script>
