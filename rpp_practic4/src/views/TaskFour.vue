<template>
  	<b-container>
  		<br/>
		<b-row>
			<b-col lg="5">
				<h2>Переставь фигуры</h2>
				<br/>
			  <table class="table table-bordered table-padding">
			    <tbody>
			      <tr>
			      	<td class="chess-td-horizontal">3</td>
			      	<td><b-button variant="secondary" class="chess-btn" @click="ClickButton(0, 0)">
			      		<img v-if="items[0][0] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-else-if="items[0][0] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      	<td><b-button variant="light" class="chess-btn" @click="ClickButton(0, 1)">
			      		<img v-if="items[0][1] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-else-if="items[0][1] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      	<td><b-button variant="secondary" class="chess-btn" @click="ClickButton(0, 2)"  v-model="items">
			      		<img v-if="items[0][2] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[0][2] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      </tr>
			      <tr>
			      	<td class="chess-td-horizontal">2</td>
			      	<td><b-button variant="light" class="chess-btn"@click="ClickButton(1, 0)">
			      		<img v-if="items[1][0] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[1][0] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      	<td><b-button variant="secondary" class="chess-btn" @click="ClickButton(1, 1)"  v-model="items">
			      		<img v-if="items[1][1] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[1][1] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      	<td><b-button variant="light" class="chess-btn" @click="ClickButton(1, 2)"  v-model="items">
			      		<img v-if="items[1][2] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[1][2] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      </tr>
			      <tr>
			      	<td class="chess-td-horizontal">1</td>
			      	<td><b-button variant="secondary" class="chess-btn" @click="ClickButton(2, 0)">
			      		<img v-if="items[2][0] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[2][0] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      	<td><b-button variant="light" class="chess-btn" @click="ClickButton(2, 1)">
			      		<img v-if="items[2][1] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[2][1] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      	<td><b-button variant="secondary" class="chess-btn" @click="ClickButton(2, 2)">
			      		<img v-if="items[2][2] == 2" src="../assets/img/taskfour/elephant_white.svg" alt="" height="40px">
			      		<img v-if="items[2][2] == 1" src="../assets/img/taskfour/pawn_black.svg" alt="" height="40px">
			      	</b-button></td>
			      </tr>
			      <tr>
			      	<td></td>
			      	<td class="chess-td-line">a</td>
			      	<td class="chess-td-line">b</td>
			      	<td class="chess-td-line">c</td>
			      </tr>
			    </tbody>
			  </table>
			</b-col>
		</b-row>
		<b-modal id="modal-1" title="Игра законченна">
			<p class="my-4">Фигуры переставленны!!!</p>
		</b-modal>
	</b-container>
</template>

<script>
export default{
  data() {
    return{
      items: [],
      select_figure: null,
      select_item_x: null,
      select_item_y: null,
      change_item_x: null,
      change_item_y: null
    }
  },
  created(){
  	this.InitGame();
  },
  methods: {
    InitGame: function () {
    	this.items = [];
    	this.$set(this.items, 0, [2, 2, 2]);
    	this.$set(this.items, 1, [0, 0, 0]);
    	this.$set(this.items, 2, [1, 1, 1]);
    	// this.items.push();
    	// this.items.push([0, 0, 0]);
    	// this.items.push([1, 1, 1]);
    },
    ClickButton: function(x, y){
    	if(this.select_item_x == null &&
    		this.select_item_y == null
    		){
    		this.select_item_x = x;
    		this.select_item_y = y;
    		this.select_figure = this.items[x][y];
    	}
    	else if(this.select_item_x == x &&
    		this.select_item_y == y
    		){
    		this.ClearSelect();
    	}
    	else{
    		if(this.items[x][y] == 0){
    			this.change_item_x = x;
	    		this.change_item_y = y;
	    		this.items[this.select_item_x][this.select_item_y] = 0;
	    		this.$set(this.items[x], y, this.select_figure);
	    		console.log(this.items);
    		}
    		this.ClearSelect();
    		this.СheckEndGame();
    	}
    	
    },
    ClearSelect: function(){
    	this.select_item_x = null;
    	this.select_item_y = null;
    	this.select_figure = null;
    	this.change_item_x = null;
    	this.change_item_y = null;
    },
    СheckEndGame: function(){
    	if(this.items[0][0] == 1 &&
    		this.items[0][1] == 1 &&
    		this.items[0][2] == 1 &&
    		this.items[2][0] == 2 &&
    		this.items[2][1] == 2 &&
    		this.items[2][2] == 2
    		){
    		this.$bvModal.show('modal-1');
    		this.InitGame();
    	}
    }
  },
}
</script>



<style lang="scss">

.chess-btn{
	width: 143px;
	height: 143px;
	border-radius: 0;
}

.table-padding{
	td{
		padding: 0;
	}
	.chess-td-horizontal{
		line-height: 143px;
		font-weight: bold;
		padding: 0 10px;
	}
	.chess-td-line{
		font-weight: bold;
		text-align: center;
		padding: 5px 0;
	}
}


	
</style>