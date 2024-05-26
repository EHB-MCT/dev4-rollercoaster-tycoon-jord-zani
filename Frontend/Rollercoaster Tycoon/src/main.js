import { createApp } from 'vue';
import App from './App.vue';
import axios from 'axios';
import router from './router';
import vuetify from './plugins/vuetify';
import { loadFonts } from './plugins/webfontloader';

loadFonts();

// Set the base URL for Axios
axios.defaults.baseURL = 'http://localhost:8080/api';
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';

createApp(App)
  .use(router)
  .use(vuetify)
  .mount('#app');
