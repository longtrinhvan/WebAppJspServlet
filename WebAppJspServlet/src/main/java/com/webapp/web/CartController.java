package com.webapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.model.userModel;
import com.webapp.utils.SessionUtil;

@WebServlet(urlPatterns = { "/gio-hang"})
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		userModel model = (userModel) SessionUtil.getInstance().getValue(request, "usermodel");
		String thongBao="";
		if (model != null) {
			if (model.getRoleid() == 2) {
				thongBao="Tài khoản không hỗ trợ chức năng này!!!";
				request.setAttribute("thongBao", thongBao);
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/login/login.jsp");
				rd.forward(request, response);
				return;
			} 
		} else {
			thongBao="Vui lòng đăng nhập!!!";
			request.setAttribute("thongBao", thongBao);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login/login.jsp");
			rd.forward(request, response);
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart/cart.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
