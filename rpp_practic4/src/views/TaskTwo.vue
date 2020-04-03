<template>
  	<b-container>
  		<b-row>
  			<b-col lg="6">
		    	<br/>
		  		<b-form-group label="Извечный вопрос философии. Что было в начале? Курица или яйцо?">
			      <b-form-radio v-model="selected" name="some-radios" value="chicken">Курица</b-form-radio>
			      <b-form-radio v-model="selected" name="some-radios" value="egg">Яйцо</b-form-radio>
			    </b-form-group>
		  		<br/>
		        <br/>
				<div  v-if="selected === 'chicken'">
				  <img src="../assets/img/tasktwo/Chicken 08.jpg" alt="Center image" width="300px"></img>
				</div>
				<div v-if="selected === 'egg'">
				  <img center src="../assets/img/tasktwo/dstulle_white_egg_clip_art_23732/Dstulle_White_Egg_clip_art.svg" alt="Center image"></img>
				</div>
  			</b-col>
  		</b-row>
	</b-container>
</template>

<script>
export default{
  data() {
    return{
      selected: 'chicken',
    }
  }
}
</script>