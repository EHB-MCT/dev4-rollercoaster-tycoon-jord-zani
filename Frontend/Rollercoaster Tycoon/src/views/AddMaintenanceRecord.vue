<!-- src/views/AddMaintenanceRecord.vue -->
<template>
    <div>
      <h1>Add Maintenance Record for {{ attraction.name }}</h1>
      <form @submit.prevent="addMaintenanceRecord">
        <div>
          <label for="date">Date:</label>
          <input v-model="maintenance.date" id="date" required type="date">
        </div>
        <div>
          <label for="description">Description:</label>
          <input v-model="maintenance.description" id="description" required>
        </div>
        <button type="submit">Add Record</button>
      </form>
      <loading v-model:active.sync="isLoading" :is-full-page="true"></loading>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script>
  import apiClient from '@/apiClient';
  import 'vue-loading-overlay/dist/css/index.css';
  
  export default {
    name: 'AddMaintenanceRecord',
    data() {
      return {
        attraction: {},
        maintenance: {
          date: '',
          description: '',
          resolved: false
        }
      };
    },
    created() {
      const id = this.$route.params.id;
      apiClient.get(`/attractions/${id}`)
        .then(response => {
          this.attraction = response.data;
        })
        .catch(error => {
            this.error = 'There was an error fetching the attraction!';
          console.error('There was an error fetching the attraction!', error);
        });
    },
    methods: {
      addMaintenanceRecord() {
        this.error = null;
        const id = this.$route.params.id;
        apiClient.post(`/attractions/${id}/maintenance`, this.maintenance)
          .then(() => {
            this.$router.push(`/attractions/${id}/maintenance`);
          })
          .catch(error => {
            this.error = 'There was an error adding the maintenance record!';
            console.error('There was an error adding the maintenance record!', error);
          });
      }
    }
  };
  </script>
  