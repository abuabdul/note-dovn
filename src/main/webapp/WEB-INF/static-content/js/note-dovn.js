$(function () {
	  $('[data-toggle="tooltip"]').tooltip({
		  trigger: 'focus' 
	  });
	  
	  //Removing notes
	  $(".remove").click(function(){
          $.post(this.id);
          $(this).parent().fadeOut("slow");
       });
});