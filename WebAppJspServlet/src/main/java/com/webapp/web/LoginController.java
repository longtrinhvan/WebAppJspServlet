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

@WebServlet(urlPatterns = { "/dang-nhap" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	private userDao userdao;

	public void init() {
		userdao = new userDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String thongBao = request.getParameter("thongBao");
		if(thongBao !=null) {
			if(thongBao.equals("noSupport")) {
				thongBao = "Tài khoản không hỗ trợ chức năng này!!!";
			} else if(thongBao.equals("notloggedin")){
				thongBao = "Vui lòng đăng nhập!!!";
			}
			request.setAttribute("thongBao", thongBao);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/login/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDangnhap = request.getParameter("tenDangnhap");
		String matKhau = request.getParameter("matKhau");
		userModel usermodel = userdao.findUser(tenDangnhap);
		String thongBao = "";
		if (usermodel == null) {
			System.out.println("Tên đăng nhập không chính xác!!!");
			thongBao = "Tên đăng nhập không chính xác!!!";
		} else if (usermodel != null) {
			if (tenDangnhap.equals(usermodel.getUsername()) && matKhau.equals(usermodel.getPassword())) {
				SessionUtil.getInstance().putValue(request, "usermodel", usermodel);
				if (usermodel.getRoleid() == 1) {
					response.sendRedirect(request.getContextPath() + "/trang-chu");
					return;
				} else if (usermodel.getRoleid() == 2) {
					response.sendRedirect(request.getContextPath() + "/admin-trang-chu");
					return;
				}
			} else {
				if (matKhau.equals(usermodel.getPassword()) == false) {
					System.out.println("Mật khẩu không chính xác!!!");
					thongBao = "Mật khẩu không chính xác!!!";
				}
			}
		}
		request.setAttribute("thongBao", thongBao);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
		rd.forward(request, response);
	}
}
