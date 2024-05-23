<!-- src/views/MaintenanceRecords.vue -->
<template>
    <div>
      <h1>Maintenance Records for {{ attraction.name }}</h1>
      <router-link :to="`/maintenance/add/${attraction.id}`">Add Maintenance Record</router-link>
      <ul>
        <li v-for="record in maintenanceRecords" :key="record.id">
          {{ record.date }} - {{ record.description }} - {{ record.resolved ? 'Resolved' : 'Unresolved' }}
          <button @click="resolveRecord(record.id)" v-if="!record.resolved">Resolve</button>
        </li>
      </ul>
      <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script>
  import apiClient from '@/apiClient';
  import 'vue-loading-overlay/dist/css/index.css';
  
  export default {
    name: 'MaintenanceRecords',
    data() {
      return {
        attraction: {},
        maintenanceRecords: []
      };
    },
    created() {
      const id = this.$route.params.id;
      apiClient.get(`/attractions/${id}`)
        .then(response => {
          this.attraction = response.data;
          this.fetchMaintenanceRecords(id);
        })
        .catch(error => {
            this.error = 'There was an error fetching the attraction!';
          console.error('There was an error fetching the attraction!', error);
        });
    },
    methods: {
      fetchMaintenanceRecords(attractionId) {
        this.error = null;
        apiClient.get(`/attractions/${attractionId}/maintenance`)
          .then(response => {
            this.maintenanceRecords = response.data;
          })
          .catch(error => {
            this.error = 'There was an error fetching the maintenance record!';
            console.error('There was an error fetching the maintenance records!', error);
          });
      },
      resolveRecord(recordId) {
        this.error = null;
        apiClient.put(`/maintenance/${recordId}/resolve`)
          .then(() => {
            this.fetchMaintenanceRecords(this.attraction.id);
          })
          .catch(error => {
            this.error = 'There was an error resolving the maintenance record!';
            console.error('There was an error resolving the maintenance record!', error);
          });
      }
    }
  };
  </script>
  