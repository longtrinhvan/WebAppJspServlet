<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/web/css/styles-list-product.css' />">
<link
	href="https://fonts.googleapis.com/css?family=Poppins&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab&display=swap"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Mukta&display=swap"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value='/template/web/js/jquery-3.5.1.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/views/web/listProduct/listProduct.js' />"></script>
</head>

<body>
	<div class="menu">
		<div class="logo">
			<h4>Duy Long</h4>
			<h3>
				<a href="trang-chu">Computer</a>
			</h3>
		</div>
		<div class="seach-div">
			<input class="seach" type="text" placeholder=""
				id="CafeF_SearchKeyword_Company" autocomplete="off">
			<button class="btn-seach">
				<svg id="svg-search" aria-hidden="true" focusable="false"
					data-prefix="fas" data-icon="search"
					class="svg-inline--fa fa-search fa-w-16" role="img"
					xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
          <path fill="currentColor"
						d="M505 442.7L405.3 343c-4.5-4.5-10.6-7-17-7H372c27.6-35.3 44-79.7 44-128C416 93.1 322.9 0 208 0S0 93.1 0 208s93.1 208 208 208c48.3 0 92.7-16.4 128-44v16.3c0 6.4 2.5 12.5 7 17l99.7 99.7c9.4 9.4 24.6 9.4 33.9 0l28.3-28.3c9.4-9.4 9.4-24.6.1-34zM208 336c-70.7 0-128-57.2-128-128 0-70.7 57.2-128 128-128 70.7 0 128 57.2 128 128 0 70.7-57.2 128-128 128z">
          </path>
        </svg>
				<p>
					<a class="search-01-rw" href="#">Tìm kiếm</a>
				</p>
			</button>
		</div>
		<div class="gio-hang">
			<p>
				<a href="gio-hang"><svg id="icon-gio-hang" aria-hidden="true"
						focusable="false" data-prefix="fal" data-icon="cart-plus"
						class="svg-inline--fa fa-cart-plus fa-w-18" role="img"
						xmlns="http://www.w3.org/2000/svg" viewBox="0 0 576 512">
        <path fill="currentColor"
							d="M504.717 320H211.572l6.545 32h268.418c15.401 0 26.816 14.301 23.403 29.319l-5.517 24.276C523.112 414.668 536 433.828 536 456c0 31.202-25.519 56.444-56.824 55.994-29.823-.429-54.35-24.631-55.155-54.447-.44-16.287 6.085-31.049 16.803-41.548H231.176C241.553 426.165 248 440.326 248 456c0 31.813-26.528 57.431-58.67 55.938-28.54-1.325-51.751-24.385-53.251-52.917-1.158-22.034 10.436-41.455 28.051-51.586L93.883 64H24C10.745 64 0 53.255 0 40V24C0 10.745 10.745 0 24 0h102.529c11.401 0 21.228 8.021 23.513 19.19L159.208 64H551.99c15.401 0 26.816 14.301 23.403 29.319l-47.273 208C525.637 312.246 515.923 320 504.717 320zM408 168h-48v-40c0-8.837-7.163-16-16-16h-16c-8.837 0-16 7.163-16 16v40h-48c-8.837 0-16 7.163-16 16v16c0 8.837 7.163 16 16 16h48v40c0 8.837 7.163 16 16 16h16c8.837 0 16-7.163 16-16v-40h48c8.837 0 16-7.163 16-16v-16c0-8.837-7.163-16-16-16z">
        </path>
      </svg></a>
			</p>
		</div>
		<div class="dang-nhap">
			<c:if test="${ empty usermodel }">
				<a class="dn" href="dang-nhap">Đăng nhập</a>
				<a class="dk" href="dang-ky">Đăng Ký</a>
			</c:if>
			<c:if test="${ not empty usermodel }">
				<a class="dn" href="dang-nhap">${usermodel.username}</a>
				<a class="dk" href="dang-xuat">Đăng Xuất</a>
			</c:if>
		</div>
		<div class="danh-muc">
			<ul>
				<li><svg id="menu-rw" aria-hidden="true" focusable="false"
						data-prefix="fas" data-icon="bars"
						class="svg-inline--fa fa-bars fa-w-14" role="img"
						xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512">
            <path fill="currentColor"
							d="M16 132h416c8.837 0 16-7.163 16-16V76c0-8.837-7.163-16-16-16H16C7.163 60 0 67.163 0 76v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16zm0 160h416c8.837 0 16-7.163 16-16v-40c0-8.837-7.163-16-16-16H16c-8.837 0-16 7.163-16 16v40c0 8.837 7.163 16 16 16z">
            </path>
          </svg></i><a>Danh mục sản phẩm</a></li>
				<li><a>Chương trình khuyến mãi</a></li>
				<li><a>Chăm sóc khách hàng</a></li>
				<li><a>Chính sách bảo hành</a></li>
				<li><a>Chính sách đổi trả 30 ngày</a></li>
				<li><a>Mục tư vấn công nghệ</a></li>
			</ul>
		</div>
	</div>
	<div class="collections"></div>
	<div class="product-div">
		<div class="left-product-div">
			<div class="left-seach-product-div">
				<div class="color"></div>
				<div class="loc-theo-gia-div">
					<h4>Giá:</h4>
					<input class="loc-theo-gia-input" type="text" placeholder=""
						id="CafeF_SearchKeyword_Company" autocomplete="off"> <input
						class="loc-theo-gia-input" type="text" placeholder=""
						id="CafeF_SearchKeyword_Company" autocomplete="off">
					<button class="loc-theo-gia-button">Dưới 10 tr</button>
					<button class="loc-theo-gia-button">Dưới 15 tr</button>
					<button class="loc-theo-gia-button">Dưới 20 tr</button>
					<button class="loc-theo-gia-button">Trên 20 tr</button>
				</div>
				<div class="loc-theo-thuong-hieu-div">
					<h4>Thương hiệu:</h4>
					<button class="loc-theo-thuong-hieu-button">DELL</button>
					<button class="loc-theo-thuong-hieu-button">SAMSUNG</button>
					<button class="loc-theo-thuong-hieu-button">LENOVO</button>
					<button class="loc-theo-thuong-hieu-button">APPLE</button>
				</div>
				<div class="loc-theo-ram-div">
					<h4>Số khe Ram:</h4>
					<button class="loc-theo-ram-button">2 Khe cắm</button>
					<button class="loc-theo-ram-button">1 Khe cắm</button>
					<button class="loc-theo-ram-button">4 Khe cắm</button>
				</div>
				<div class="loc-theo-HDD-div">
					<h4>Dung lượng ổ đĩa HDD:</h4>
					<button class="loc-theo-HDD-button">500 GB</button>
					<button class="loc-theo-HDD-button">1 TB</button>
					<button class="loc-theo-HDD-button">2 TB</button>
				</div>
				<div class="loc-theo-ban-phim-div">
					<h4>Bàn phím số của lap top:</h4>
					<button class="loc-theo-ban-phim-button">Có phím số</button>
					<button class="loc-theo-ban-phim-button">Không phím số</button>
				</div>
			</div>
		</div>
		<div class="center-banner-product-div">
			<img src='<c:url value="/template/web/image/unnamed.jpg" />'>
		</div>
		<div class="center-product-div-rw">
			<div class="center-product-div" id="center-product-div">
				<div class="list-product-div" id="list-product-div">
					<c:forEach var="item" items="${productmodel}">
						<div class="dell-product-div">
							<p id="i-tags">-17%</p>
							<img class="img-dell-product-div"
								src='<c:url value="/template/web/image/${item.image}" />'>
							<h4>
								<a >${item.nameproduct}</a>
							</h4>
							<h5>${item.price}đ</h5>
							<input type="hidden" value="${item.idproduct}" id="idproduct" />
						</div>
					</c:forEach>
					<input type="hidden" value="${producerid}" id="producerid" /> <input
						type="hidden" value="${locationPage}" id="locationPage" /> <input
						type="hidden" value="${page}" id="pagecheck" />
				</div>
				<div class="pagination">
					<div class="pagination-child">
						<a id="previousPage">&laquo;</a> <a class="page" id="active">1</a>
						<a class="page">2</a> <a class="page">3</a> <a class="page">4</a>
						<a class="page">5</a> <a id="nextPage">&raquo;</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="about"></div>
</body>
</html>