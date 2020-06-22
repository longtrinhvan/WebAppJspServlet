$(document)
	.ready(
		function () {
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
	function () {
		$("#nextPage").on(
			'click',
			function (e) {
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
			function (e) {
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
		function () {
			$(".page")
				.on(
					'click',
					function (e) {
						var page = $(this).text();
						var idproduct = $("#idproduct").val();
						$
							.ajax({
								url: 'san-pham',
								type: 'POST',
								dataType: "html",
								data: {
									page: page,
									idproduct: idproduct
								},
								success: function (data) {
									$(".comment-rw")
										.html(
											$(data)
												.find(
													".comment-rw")
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


$(document).ready(function () {
	$(".response").hide();
	$('.comment-rw').on('click', '.a-morereply', function() {
		var page = $('#pagecheck').val();
		var idproduct = $('#idproduct').val();
		var idcommentreply = $(this).children('.idcommentreply').val();
		var maxLocationreply = $(this).children('.maxLocationreply').val();
		maxLocationreply = Math.floor(maxLocationreply) + 2;
		$(this).children('.maxLocationreply').val(maxLocationreply);
		$.ajax({
			url: 'san-pham',
			type: 'GET',
			dataType: "html",
			data: {
				page: page,
				idproduct: idproduct,
				idcommentreply: idcommentreply,
				maxLocationreply: maxLocationreply
			},
			success: function (data) {
				$('.more').each(function (index) {
					if (idcommentreply == $(data).find('.idcommentreply').eq(index).val()) {
						var datareply = $(data).find('.more').eq(index).html();
						if ($('.more').eq(index).children('.comment-rw-rs-002-1').length != $(data).find('.more').eq(index).children('.comment-rw-rs-002-1').length) {
							$(".svg-rl").eq(index).hide();
							$(".response").eq(index).show().delay(200).fadeOut().queue(function () {
								$('.more').eq(index).html(datareply).queue(function () {
									$(".svg-rl").eq(index).show().queue(function () {
										if ($(data).find('.more').eq(index).children('.comment-rw-rs-002-1').length % 2) {
											$('.a-morereply').eq(index).children('a').html("Thu gọn").dequeue();
										}
									}).stop();
								}).stop();
							}).stop();
						}
						else {
							$(".svg-rl").eq(index).hide();
							$(".response").eq(index).show().delay(400).fadeOut().queue(function () {
								$('.more').eq(index).html(null).queue(function () {
									$(".svg-rl").eq(index).show().queue(function () {
										$('.a-morereply').eq(index).children('a').html("Xem thêm bình luận").queue(function () {
											$('.maxLocationreply').eq(index).val(0).dequeue();
										}).stop();
									}).stop();
								}).stop();
							}).stop();
						}
					}
				});
			}
		});

	});
	
	$('body').on('click', '.reply-comment', function() {
		if($(this).parent().next().is(":visible") == false){
			$(this).text("Ẩn");
			$(this).parent().next().css("display", "block");
		}else {
			 $(this).text("Trả lời");
			 $(this).parent().next().css("display", "none");
		}
	});
});

$(document).ready(function () {
	var cart = [];
	$(function() {
		if (localStorage.cart) {
			cart = JSON.parse(localStorage.cart);
		}
	});
	function addToCart() {
		var idproduct = $("#idproduct").val();
		var nameproduct = $("#nameproduct").val();
		var price = $("#price").val();
		var marketprice = $("#marketprice").val();
		var image = $("#image").val();
		var total = $("#total").val();
				for ( var i in cart) {
					if (cart[i].idProduct == idproduct) {
						cart[i].Total =Math.floor(cart[i].Total)+ Math.floor(total);
						saveCart();
						return;
					}
				}
		var item = {
			idProduct : idproduct,
			nameProduct : nameproduct,
			Price : price,
			marketPrice : marketprice,
			Image : image,
			Total : total
		};
		cart.push(item);
		saveCart();
	}
	function saveCart() {
		if (window.localStorage) {
			localStorage.cart = JSON.stringify(cart);
		}
	}
	$(".addCart").on('click', function(e) {
		addToCart();
		alert(cart[0].Total);
	});
});
