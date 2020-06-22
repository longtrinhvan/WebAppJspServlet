package com.webapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.userDao;
import com.webapp.model.userModel;
import com.webapp.utils.SessionUtil;

@WebServlet(urlPatterns = { "/dang-ky" })
public class SignUpController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	private userDao userdao;

	public void init() {
		userdao = new userDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/signup/signup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDangnhap = request.getParameter("tenDangnhap");
		String matKhau = request.getParameter("matKhau");
		String kiemTramatkhau = request.getParameter("kiemTramatkhau");
		int test  =userdao.findNameUser(tenDangnhap);
		String thongBao="";
		if (test == 1) {
			System.out.println("Tên đăng nhập đã được sử dụng!!!");
			thongBao ="Tên đăng nhập đã được sử dụng!!!";
		} else {
			if (kiemTramatkhau.equals(matKhau)) {
				System.out.println("Đăng ký thành công!!!");
				userdao.InsertUser(tenDangnhap, matKhau,null);
				userModel usermodel =  userdao.findUser(tenDangnhap);
				SessionUtil.getInstance().putValue(request, "usermodel", usermodel);
				response.sendRedirect(request.getContextPath() + "/trang-chu");
				return;
			} else {
				System.out.println("Mật khẩu không chính xác!!!");
				thongBao ="Mật khẩu không chính xác!!!";
			}
		}
		request.setAttribute("thongBao", thongBao);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/signup/signup.jsp");
		rd.forward(request, response);
	}
}
