<template>
  	<b-container>
      <br/>
      <b-row>
        <b-col lg="6">
          <p>Введите целое число от 0 до 255 и нажмите ок</p>
          <b-form-input
              id="input-1"
              v-model="number"
              type="text"
              required
              placeholder="0"
            ></b-form-input>
            <br/>
            <div>
          <b-button @click="CalcFunc">ОК</b-button>
          </div>
          <br/>
          <p>Представление числа в памяти компьютера</p>
          <table class="table table-bordered">
            <thead>
              <tr>
              <th scope="col">Вес бита</th>
              <th scope="col">128</th>
              <th scope="col">64</th>
              <th scope="col">32</th>
              <th scope="col">16</th>
              <th scope="col">8</th>
              <th scope="col">4</th>
              <th scope="col">2</th>
              <th scope="col">1</th>
              </tr>
            </thead>
            <tbody>
              <tr>
              <td>Значене бита</td>
              <td v-for="item in items" v-bind:key="item">{{ item.item}}</td>
              </tr>
            </tbody>
          </table>
        </b-col>
      </b-row>
      <b-modal id="modal-1" title="Ошибка ввода">
        <p class="my-4">Вы допустили ошибку при вводе число должно быть больше 0 и меньше 255</p>
      </b-modal>
	</b-container>
</template>

<script>
export default{
  data() {
    return{
      number: null,
      items: [],
      showDismissibleAlert: false
    }
  },
  created(){
    for(var i=0; i<8; i++)
      this.items.push({item: 0});
  },
  methods: {
    CalcFunc: function () {
      this.items = [];
      for(var i=0; i<8; i++)
        this.items.push({item: 0});
      if(this.number>= 0 && this.number<=255)
        this.Perevod();
      else{
        this.$bvModal.show('modal-1');
      }
    },
    Perevod: function() {
      var arr = [];
      var num = this.number;
      while(num != 0){
        arr.push({item: num%2});
        num = Math.floor(num/ 2);
      }
      var arrresverse = arr.reverse();
      while(arrresverse.length != 0){
        this.items.push({item: arrresverse.shift().item});
        this.items.shift();
      }
    }
  }
}
</script>