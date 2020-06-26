package com.webapp.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.billDao;
import com.webapp.dao.detailbillDao;
import com.webapp.model.userModel;
import com.webapp.utils.SessionUtil;

@WebServlet(urlPatterns = { "/gio-hang" })
public class CartController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;
	private detailbillDao detailbilldao;
	private billDao billdao;

	public void init() {
		billdao = new billDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart/cart.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userModel model = (userModel) SessionUtil.getInstance().getValue(request, "usermodel");
		checklogin(request, response);
		int idbill = billdao.FUNCTION_findBillwithIdUser(model.getIduser());
		try {
			if (request.getParameter("statusBill") != null) {
				int statusBill =Integer.parseInt(request.getParameter("statusBill"));
				if (statusBill == 0) {
					java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					billdao.insertBill(model.getIduser(), model.getUsername(), 0, 0, sqlDate, 0);
				} else if (statusBill == 2) {
					String idProduct = request.getParameter("idProduct");
					String nameProduct = request.getParameter("nameProduct");
					String Total = request.getParameter("Total");
					String Totalmoney = request.getParameter("Totalmoney");
					idbill = billdao.FUNCTION_findBillwithIdUser(model.getIduser());
					detailbilldao.insertDetailBill(idbill, Integer.parseInt(idProduct), nameProduct,
							Integer.parseInt(Total), Integer.parseInt(Totalmoney));
				}else if (statusBill == 1) {
					billdao.updateStatusBill(idbill, 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void checklogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userModel model = (userModel) SessionUtil.getInstance().getValue(request, "usermodel");
		String thongBao = "";
		if (model != null) {
			if (model.getRoleid() == 2) {
				thongBao = "Tài khoản không hỗ trợ chức năng này!!!";
				request.setAttribute("thongBao", thongBao);
				response.sendRedirect(request.getContextPath() + "/dang-nhap?thongBao=noSupport");
				return;
			}
		} else {
			thongBao = "Vui lòng đăng nhập!!!";
			request.setAttribute("thongBao", thongBao);

			response.sendRedirect(request.getContextPath() + "/dang-nhap?thongBao=notloggedin");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart/cart.jsp");
		rd.forward(request, response);
	}

}
