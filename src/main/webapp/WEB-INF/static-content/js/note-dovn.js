//Inline mode
$.fn.editable.defaults.mode = 'inline';

$(function () {
	  
	  $('[data-toggle="tooltip"]').tooltip({
		  trigger: 'focus' 
	  });
	  
	  //Editable fields
	  $('.editable').editable({
	        type: 'text',
	        url: baseURL + '/secure/scratch/updateNote.go',
	        success: function(response, newValue){
	            if(response.status == 'error') return response.msg;
	        }
	  });
	  
	  //Removing notes
	  $(".remove").click(function(){
          $.post(this.id);
          $(this).parent().fadeOut("slow");
       });
});