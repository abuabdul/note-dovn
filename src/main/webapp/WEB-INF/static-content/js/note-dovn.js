$(function () {
	  $('[data-toggle="tooltip"]').tooltip({
		  trigger: 'focus' 
	  });
	  
	  //Editable fields
	  $('.editable').editable({
	        type: 'text',
	        pk: this.id,
	        url: '/',
	        title: 'Enter value'
	  });
	  
	  //Removing notes
	  $(".remove").click(function(){
          $.post(this.id);
          $(this).parent().fadeOut("slow");
       });
});