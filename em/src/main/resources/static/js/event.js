/**
 * 
 */

$(document).ready(function(){
	
	$('.nBtn, .table .eBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if(text=='Edit'){
		$.get(href,function(event,status){
			$('.myForm #id').val(event.id)
			$('.myForm #name').val(event.name)
			$('.myForm #description').val(event.description)
			$('.myForm #date').val(event.date)
			$('.myForm #place').val(event.place)
			$('.myForm #price').val(event.price)
			$('.myForm #seatsNumber').val(event.seatsNumber)

			
		});
		
		$('.myForm #exampleModal').modal();
		}else {
			$('.myForm #id').val('')
			$('.myForm #name').val('')
			$('.myForm #description').val('')
			$('.myForm #date').val('')
			$('.myForm #place').val('')
			$('.myForm #price').val('')
			$('.myForm #seatsNumber').val('')
			
			$('.myForm #exampleModal').modal();
		}
	});
	
	$('.table .delBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');

		$('#myModal #delRef').attr('href',href);
		$('#myModal').modal();

		
	});
	
});