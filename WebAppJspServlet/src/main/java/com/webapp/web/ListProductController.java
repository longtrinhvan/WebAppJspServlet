package com.webapp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.productDao;
import com.webapp.model.productModel;

@WebServlet(urlPatterns = { "/danh-sach-san-pham" })
public class ListProductController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	private productDao productdao;

	public void init() {
		productdao = new productDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		String producerid = request.getParameter("producerid");
		List<productModel> productmodel = null;
		productmodel = productdao.PRO_Pagination(Integer.parseInt(producerid), page);
		if (productmodel.size() == 0) {
			producerid = productdao.producerid(Integer.parseInt(producerid));
		}
		request.setAttribute("page", page);
		request.setAttribute("locationPage", productdao.locationPage(page));
		request.setAttribute("producerid", producerid);
		request.setAttribute("productmodel", productmodel);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/listProduct/listProduct.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request, response);
	}
}
