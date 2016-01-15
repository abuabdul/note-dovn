//Inline mode
$.fn.editable.defaults.mode = 'inline';

$(function () {
	  
	  $('[data-toggle="tooltip"]').tooltip({
		  trigger: 'focus' 
	  });
	  
	  //Editable fields
	  $('.editable').editable({
	        type: 'text',
	        pk: $(this).id,
	        url: baseURL + '/secure/scratch/'+$(this).id+'/updateNote.go',
	        title: 'Enter value',
	        name:  'category' //name of field (column in db)
	  });
	  
	  //Removing notes
	  $(".remove").click(function(){
          $.post(this.id);
          $(this).parent().fadeOut("slow");
       });
});