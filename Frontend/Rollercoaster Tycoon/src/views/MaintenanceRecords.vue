<template>
  <v-container>
    <h1>Maintenance Records for {{ attraction.name }}</h1>
    <router-link :to="`/maintenance/add/${attraction.id}`">
      <v-btn color="primary" class="mb-4">Add Maintenance Record</v-btn>
    </router-link>
    <v-row>
      <v-col v-for="record in maintenanceRecords" :key="record.id" cols="12" md="6">
        <v-card class="mb-4">
          <v-card-title>{{ record.date }}</v-card-title>
          <v-card-subtitle>{{ record.description }}</v-card-subtitle>
          <v-card-text>{{ record.resolved ? 'Resolved' : 'Unresolved' }}</v-card-text>
          <v-card-actions>
            <v-btn @click="resolveRecord(record.id)" v-if="!record.resolved" color="success">Resolve</v-btn>
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
      apiClient.put(`/attractions/${this.attraction.id}/maintenance/${recordId}/resolve`)
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
