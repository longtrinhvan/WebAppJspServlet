<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href='<c:url value="template/web/css/login.css"/>'>
	<link href="https://fonts.googleapis.com/css?family=Poppins&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Mukta&display=swap" rel="stylesheet">
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
			<input class="seach" type="text" placeholder="" id="CafeF_SearchKeyword_Company" autocomplete="off">
			<button class="btn-seach">
				<svg id="svg-search" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="search"
					class="svg-inline--fa fa-search fa-w-16" role="img" xmlns="http://www.w3.org/2000/svg"
					viewBox="0 0 512 512">
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
				<a href="gio-hang"><svg id="icon-gio-hang" aria-hidden="true" focusable="false" data-prefix="fal"
						data-icon="cart-plus" class="svg-inline--fa fa-cart-plus fa-w-18" role="img"
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
				<li><svg id="menu-rw" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="bars"
						class="svg-inline--fa fa-bars fa-w-14" role="img" xmlns="http://www.w3.org/2000/svg"
						viewBox="0 0 448 512">
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
	<div class="login">
		<div class="well-come-rw">
			<img src='<c:url value="template/web/image/login.jpg"/>'>

		</div>
		<form class="form_login" action="" method="post">
			<div class="login-rw-1010">
				<p>ĐĂNG NHẬP</p>
			</div>
			<div class="thong-bao">
				<p>${thongBao}</p>
			</div>
			<div class="container">
				<div class="login-rw">
					<input type="text" placeholder="    Nhập tên đăng nhập " name="tenDangnhap" required>
				</div>

				<div class="login-rw">
					<input type="password" placeholder="    Nhập mật khẩu" name="matKhau" required>
				</div>
				<button class="btn_login" type="submit">Đăng nhập</button>
				<div class="login-rw-or">
					<p>hoặc</p>
					<svg id="icon-fb" aria-hidden="true" focusable="false" data-prefix="fab" data-icon="facebook"
						class="svg-inline--fa fa-facebook fa-w-16" role="img" xmlns="http://www.w3.org/2000/svg"
						viewBox="0 0 512 512">
						<path fill="currentColor"
							d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z">
						</path>
					</svg>
					<svg id="icon-mail" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="mail-bulk"
						class="svg-inline--fa fa-mail-bulk fa-w-18" role="img" xmlns="http://www.w3.org/2000/svg"
						viewBox="0 0 576 512">
						<path fill="currentColor"
							d="M160 448c-25.6 0-51.2-22.4-64-32-64-44.8-83.2-60.8-96-70.4V480c0 17.67 14.33 32 32 32h256c17.67 0 32-14.33 32-32V345.6c-12.8 9.6-32 25.6-96 70.4-12.8 9.6-38.4 32-64 32zm128-192H32c-17.67 0-32 14.33-32 32v16c25.6 19.2 22.4 19.2 115.2 86.4 9.6 6.4 28.8 25.6 44.8 25.6s35.2-19.2 44.8-22.4c92.8-67.2 89.6-67.2 115.2-86.4V288c0-17.67-14.33-32-32-32zm256-96H224c-17.67 0-32 14.33-32 32v32h96c33.21 0 60.59 25.42 63.71 57.82l.29-.22V416h192c17.67 0 32-14.33 32-32V192c0-17.67-14.33-32-32-32zm-32 128h-64v-64h64v64zm-352-96c0-35.29 28.71-64 64-64h224V32c0-17.67-14.33-32-32-32H96C78.33 0 64 14.33 64 32v192h96v-32z">
						</path>
					</svg>
					<span class="psw">Quên <a href="#">mật khẩu?</a></span>
				</div>
				<div class="signup">
					<span class="psw">Bạn chưa có tài khoản?<a href="dang-ky">Đăng
							Ký</a></span>
				</div>
			</div>
		</form>
	</div>
	<div class="about"></div>
</body>

</html>