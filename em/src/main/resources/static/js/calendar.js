/**
 * 
 */
$(document).ready(function(){

	 var date_input=$('input[name="date"]'); ///our date input has the name "date"
    var container=$('.date #date').length>0 ? $('.myForm #date').parent() : "body";
   // debugger;
    date_input.datepicker({
        format: 'mm/dd/yyyy',
        container: container,
        orientation:"bottom right",
        todayHighlight: true,
        autoclose: true,
    });
});