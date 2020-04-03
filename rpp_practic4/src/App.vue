<template>
  <div id="app">
    <b-navbar toggleable="lg" type="dark" variant="success" >
      <b-navbar-brand href="#">Практическое занятие 4</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/">Задание 1</b-nav-item>
          <b-nav-item to="/task2">Задание 2</b-nav-item>
          <b-nav-item to="/task3">Задание 3</b-nav-item>
          <b-nav-item to="/task4">Задание 4</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
    <router-view/>
  </div>
</template>

<style lang="scss">
@import 'node_modules/bootstrap/scss/bootstrap';
@import 'node_modules/bootstrap-vue/src/index.scss';

.selector-for-some-widget {
  box-sizing: content-box;
}
</style>
