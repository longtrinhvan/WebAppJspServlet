$(document).ready(function() {
	$(".ListBnn").click(function() {		
		var producerid=$(this).children("input").val();		
		var form = $('<form></form>');
		form.attr("method", "post");
		form.attr("action","danh-sach-san-pham");		
		var field = $('<input></input>');
		field.attr("type", "hidden");
		field.attr("name", "producerid");
		field.attr("value", producerid);
		form.append(field);
		$(form).appendTo('body').submit();
	});
});