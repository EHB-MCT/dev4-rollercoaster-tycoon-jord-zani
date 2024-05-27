<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <v-toolbar-title>Rollercoaster Tycoon</v-toolbar-title>
      <v-spacer></v-spacer>
      <router-link to="/" class="router-link">
        <v-btn text>Home</v-btn>
      </router-link>
      <router-link to="/attractions" class="router-link">
        <v-btn text>Attractions</v-btn>
      </router-link>
      <router-link to="/categories" class="router-link">
        <v-btn text>Categories</v-btn>
      </router-link>
    </v-app-bar>
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
export default {
  name: 'App'
};
</script>

<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

.router-link {
  text-decoration: none;
  color: inherit;
}

.router-link:hover {
  text-decoration: underline;
}

/* .v-app-bar {
  background-color: #3f51b5 !important;
} */

.v-btn {
  margin: 0.5rem;
}
</style>
