$(document)
		.ready(
				function() {
					var locationPage = $("#locationPage").val();
					$(".page:eq(" + locationPage + ")").css("background-color",
							"rgb(236, 119, 24)").css("border",
							"1px solid rgb(236, 119, 24)");
					var page = $("#pagecheck").val();
					for (var i = 0; i < 5; i++) {
						$(".page:eq(" + i + ")").text(
								Math.floor(page / 5) * 5 + i + 1);
					}
				});
$(document).ready(
		function() {
			$("#nextPage").on(
					'click',
					function(e) {
						var page = $(".page:eq(4)").text();
						for (var i = 0; i < 5; i++) {
							$(".page:eq(" + i + ")").text(
									Math.floor(page) + i + 1);
						}
						var pagecheck = $("#pagecheck").val();
						var locationPage = $("#locationPage").val();
						var flagPage = $(".page:eq(" + locationPage + ")")
								.text();
						if (pagecheck == flagPage) {
							$(".page:eq(" + locationPage + ")").css(
									"background-color", "rgb(236, 119, 24)")
									.css("border",
											"1px solid rgb(236, 119, 24)");
						} else {
							$(".page:eq(" + locationPage + ")").css(
									"background-color", "white").css("border",
									"1px solid #ddd");
						}
					});
			$("#previousPage").on(
					'click',
					function(e) {
						var page = $(".page:eq(0)").text();
						if (Math.floor(page) > 1) {
							for (var i = 0; i < 5; i++) {
								$(".page:eq(" + i + ")").text(
										Math.floor(page) - 5 + i);
							}
						}
						var pagecheck = $("#pagecheck").val();
						var locationPage = $("#locationPage").val();
						var flagPage = $(".page:eq(" + locationPage + ")")
								.text();
						if (pagecheck == flagPage) {
							$(".page:eq(" + locationPage + ")").css(
									"background-color", "rgb(236, 119, 24)")
									.css("border",
											"1px solid rgb(236, 119, 24)");
						} else {
							$(".page:eq(" + locationPage + ")").css(
									"background-color", "white").css("border",
									"1px solid #ddd");
						}
					});
		});

$(document)
		.ready(
				function() {
					$(".page")
							.on(
									'click',
									function(e) {
										var page = $(this).text();
										var producerid = $("#producerid").val();
										$
												.ajax({
													url : 'danh-sach-san-pham',
													type : 'GET',
													dataType : "html",
													data : {
														page : page,
														producerid : producerid
													},
													success : function(data) {
														var filteredData = $(
																data).find(
																"#pagecheck")
																.attr('value');
														$("#list-product-div")
																.html(
																		$(data)
																				.find(
																						"#list-product-div")
																				.html());
														var locationPage = $(
																"#locationPage")
																.val();
														for (var i = 0; i < 5; i++) {
															if (i == locationPage) {
																$(
																		".page:eq("
																				+ locationPage
																				+ ")")
																		.css(
																				"background-color",
																				"rgb(236, 119, 24)")
																		.css(
																				"border",
																				"1px solid rgb(236, 119, 24)");
															} else {
																$(
																		".page:eq("
																				+ i
																				+ ")")
																		.css(
																				"background-color",
																				"white")
																		.css(
																				"border",
																				"1px solid #ddd");
															}
														}
													}
												});
									});
				});
$(document).ready(function() {
	$(".dell-product-div").click(function() {		
		var idproduct=$(this).children("input").val();		
		var form = $('<form></form>');
		form.attr("method", "post");
		form.attr("action","san-pham");		
		var field = $('<input></input>');
		field.attr("type", "hidden");
		field.attr("name", "idproduct");
		field.attr("value", idproduct);
		form.append(field);
		$(form).appendTo('body').submit();
	});
});
