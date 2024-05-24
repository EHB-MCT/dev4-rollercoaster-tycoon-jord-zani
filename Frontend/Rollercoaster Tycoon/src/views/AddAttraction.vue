<!-- src/views/AddAttraction.vue -->
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
      <v-text-field
        v-model="attraction.category"
        label="Category"
        :rules="[v => !!v || 'Category is required']"
        required
      ></v-text-field>
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
        category: '',
        capacity: '',
        yearBuilt: '',
        imageUrl: '',
        videoUrl: ''
      },
      isLoading: false,
      error: null,
      valid: false
    };
  },
  methods: {
    submit() {
      if (this.$refs.form.validate()) {
        this.addAttraction();
      }
    },
    addAttraction() {
      this.error = null;
      this.isLoading = true;
      apiClient.post('/attractions', this.attraction)
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
