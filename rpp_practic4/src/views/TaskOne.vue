<template>
	<b-container>
		<br/>
		<b-row>
			<b-col lg="6">
				<b-form-select v-model="selected" :options="options"></b-form-select>
		  		<br/>
		        <br/>
				<div v-if="selected === 'moroz'">
				  <img center src="../assets/img/taskone/dedmoroz.jpg" alt="Center image" width="350px"></img>
				</div>
				<div v-if="selected === 'santa'">
				  <img center src="../assets/img/taskone/santa.jpg" alt="Center image" width="350px"></img>
				</div>
				<div v-if="selected === 'per'">
					<img center src="../assets/img/taskone/pernoel.jpg" alt="Center image" width="500px"></img>
				</div>
			</b-col>
		</b-row>
	</b-container>
</template>

<script>
export default{
  data() {
    return{
      selected: 'moroz',
      options: [
          { value: 'moroz', text: 'Дед Мороз'},
          { value: 'santa', text: 'Санта Клауз'},
          { value: 'per', text: 'Пер Ноэль'},
        ]
    }
  }
}
</script>