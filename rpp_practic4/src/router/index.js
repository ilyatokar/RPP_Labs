import Vue from 'vue'
import VueRouter from 'vue-router'
import TaskOne from '../views/TaskOne.vue'
import TaskTwo from '../views/TaskTwo.vue'
import TaskTree from '../views/TaskTree.vue'
import TaskFour from '../views/TaskFour.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'TaskOne',
    component: TaskOne
  },
  {
    path: '/task2',
    name: 'TaskTwo',
    component: TaskTwo
  },
  {
    path: '/task3',
    name: 'TaskTree',
    component: TaskTree
  },
  {
    path: '/task4',
    name: 'TaskFour',
    component: TaskFour
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
