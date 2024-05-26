<template>
  <v-container class="home-container">
    <div class="overlay">
      <h1>Welcome to Rollercoaster Tycoon</h1>
      <router-link to="/attractions">
        <v-btn color="primary">View Attractions</v-btn>
      </router-link>
    </div>
  </v-container>
</template>

<script>
export default {
  name: 'Home'
};
</script>

<style scoped>
.home-container {
  background-image: url('@/assets/Rollercoasterpark-Wallpaper.jpeg');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  text-align: center;
}

.overlay {
  background: rgba(0, 0, 0, 0.5); /* Optional: add a dark overlay for better text visibility */
  padding: 20px;
  border-radius: 10px;
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
