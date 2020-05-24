<template>
  <div class="hello">
    <div>
      <p>
        <label >Значение a </label>
        <input type="text" v-model="a">
      </p>
      <p>
        <label >Значение b </label>
        <input type="text" v-model="b">
      </p>
      <p>
        <label >Значение c </label>
        <input type="text" v-model="c">
      </p>
      <p>
        <label > Начальное x </label>
        <input type="text" v-model="start_point">
        <label > Конечное x </label>
        <input type="text" v-model="end">
        <label > Шаг </label>
        <input type="text" v-model="step">
      </p>
      <button v-on:click="HelloMessage">Вычислить</button>
    </div>
    <br>
    <br>
    <table border="1">
       <tr>
        <th>a</th>
        <th>b</th>
        <th>c</th>
        <th>x</th>
        <th>y</th>
       </tr>
       <tr v-for="item in items" v-bind:key="item.id">
        <td>{{ item.a }}</td>
        <td>{{ item.b }}</td>
        <td>{{ item.c }}</td>
        <td>{{ item.x }}</td>
        <td>{{ item.y }}</td>
      </tr>
      </table>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return{
      test: "Hello, world!",
      a: null,
      b: null,
      c: null,
      start_point: null,
      end: null,
      step: null,
      items: []
    }
  },
  methods: {
    HelloMessage: function () {
      this.items = []
      for(var j = Number(this.start_point); j < Number(this.end); j+=Number(this.step)){
        this.items.push({
          id: j,
          a: this.a,
          b: this.b,
          c: this.c,
          x: Math.trunc(j * 100) / 100,
          y: this.MathMethod(this.a,this.b, this.c, j)
        });
      }
      console.log(this.items);
    },
    MathMethod: function(a,b,c,j){
      var result = (Math.sqrt(a/(1+(b*Math.pow(j,2)))))+(b*Math.atan(j))+(Math.exp(c*j))

      return Math.trunc(result * 100) / 100
    }
  }
}
</script>
