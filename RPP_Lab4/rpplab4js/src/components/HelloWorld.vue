<template>
  <div>
    <p>Исходный массив</p>
    <table border="1">
       <tr>
        <th>Индексы</th>
        <th>0</th>
        <th>1</th>
        <th>2</th>
        <th>3</th>
        <th>4</th>
        <th>5</th>
       </tr>
       <tr>
        <td></td>
        <td><input type="text" v-model="a"></td>
        <td><input type="text" v-model="b"></td>
        <td><input type="text" v-model="c"></td>
        <td><input type="text" v-model="d"></td>
        <td><input type="text" v-model="e"></td>
        <td><input type="text" v-model="f"></td>
      </tr>
      </table>
      <br/>
      <button v-on:click="HelloMessage">Выполнить</button>
      <br/>
      <p>Отсортированный массив</p>
      <table border="1">
      <tr>
        <th>Индексы</th>
        <th>0</th>
        <th>1</th>
        <th>2</th>
        <th>3</th>
        <th>4</th>
        <th>5</th>
       </tr>
       <tr>
        <td></td>
        <td v-for="item in items" v-bind:key="item.id">{{ item.item}}</td>
      </tr>
      </table>
      <p>Произведение положительных: {{ result }}</p>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return{
      a: "",
      b: "",
      c: "",
      d: "",
      f: "",
      e: "",
      result: "",
      items: []
    }
  },
  methods: {
    HelloMessage: function () {
      this.items = [];
      this.items.push({id: 0, item: this.a});
      this.items.push({id: 1, item: this.b});
      this.items.push({id: 2, item: this.c});
      this.items.push({id: 3, item: this.d});
      this.items.push({id: 4, item: this.f});
      this.items.push({id: 5, item: this.e});
      this.ArraySort();
    },
    ArraySort: function(){
        for(var i=0; i<6; i++){
          if(this.items[i].item > 0){
            if(this.result == "")
              this.result = 1;
            this.result *= this.items[i].item; 
          }
        }
        for(i=0; i<6; i++){
          for(var j=0; j<6; j++){
            if(this.items[i].item < this.items[j].item){
              var buffer = this.items[i].item;
              this.items[i].item = this.items[j].item;
              this.items[j].item = buffer;
            }
          }
        }
    },
  }
}
</script>

<style>
  
</style>
