<template>
  <v-container class="home-container fill-height" fluid>
    <v-row
      class="fill-height"
      align="center"
      justify="center"
    >
      <v-col
        class="text-center"
        cols="12"
      >
        <div class="overlay">
          <h1>Welcome to Rollercoaster Tycoon</h1>
          <router-link to="/attractions">
            <v-btn color="primary">View Attractions</v-btn>
          </router-link>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Home'
};
</script>

<style scoped>
.home-container {
  background-image: url('@/assets/wallpaper2.jpeg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}

.overlay {
  background: rgba(0, 0, 0, 0.5); 
  padding: 20px;
  border-radius: 10px;
  text-align: center;
}

h1 {
  font-family: 'Roboto', sans-serif;
  font-size: 3rem;
  color: #fff;
  margin-bottom: 1.5rem;
}

.router-link {
  text-decoration: none;
  color: inherit;
}

.v-btn {
  margin-top: 1rem;
}
</style>
