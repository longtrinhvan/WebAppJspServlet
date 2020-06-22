$(document).ready(function () {
	var cart = [];
	$(function() {
		if (localStorage.cart) {
			cart = JSON.parse(localStorage.cart);
		}
	});
	function addToCart() {
		var idproduct = $("#idproduct").val();
		var total = $("#total").val();
		for ( var i in cart) {
			if (cart[i].idProduct == idproduct) {
				cart[i].Total =Math.floor(cart[i].Total)+ Math.floor(total);
				saveCart();
				return;
			}
		}
	}
	function saveCart() {
		if (window.localStorage) {
			localStorage.cart = JSON.stringify(cart);
		}
	}
	function deleteItem(index) {
		cart.splice(index, 1); 
		showCart();
		saveCart();
	}
	function showCart() {

		for ( var i in cart) {
			var row = '<div class="f01-rw">'
				+'<div class="f02-rw">'
					+'<img src="<c:url value="template/web/image/acer-1.jpg"/>">'
					+'<div class="f02--p-rw">'
						+'<div class="f022--p-rw">'
							+'<p>Laptop Asus Zenbook UX333FA-A4011T</p>'
						+'</div>'
						+'<div class="f023--p-rw">'
							+'<svg id="delete-icon" aria-hidden="true" focusable="false" data-prefix="fas"'
								+'data-icon="trash-alt" class="svg-inline--fa fa-trash-alt fa-w-14" role="img"'
								+'xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">'
								+'<path fill="currentColor"'
									+'d="M32 464a48 48 0 0 0 48 48h288a48 48 0 0 0 48-48V128H32zm272-256a16 16 0 0 1 32 0v224a16 16 0 0 1-32 0zm-96 0a16 16 0 0 1 32 0v224a16 16 0 0 1-32 0zm-96 0a16 16 0 0 1 32 0v224a16 16 0 0 1-32 0zM432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16z">'
								+'</path>'
							+'</svg>'
							+'<h4>Xóa sản phẩm khỏi giỏ hàng</h4>'
						+'</div>'
					+'</div>'
					+'<div class="f02--p-01-rw">'
						+'<p>12000000đ</p>'
					+'</div>'
					+'<div class="f02--p-02-rw">'
						+'<div class="f02--p-02-rw-c">'
							+'<svg id="f02--p-02-rw-cw01" aria-hidden="true" focusable="false" data-prefix="fas"'
								+'data-icon="minus" class="svg-inline--fa fa-minus fa-w-14" role="img"'
								+'xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">'
								+'<path fill="currentColor"'
									+'d="M416 208H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h384c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z">'
								+'</path>'
							+'</svg>'
							+'<input type="text" value="5">'
							+'<svg id="f02--p-02-rw-cw02" aria-hidden="true" focusable="false" data-prefix="fas"'
								+'data-icon="plus" class="svg-inline--fa fa-plus fa-w-14" role="img"'
								+'xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">'
								+'<path fill="currentColor"'
									+'d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z">'
								+'</path>'
							+'</svg>'
						+'</div>'
					+'</div>'
				+'</div>'
			+'</div>';
			$(".left").append(row);
		}
	}
});