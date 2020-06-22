package com.webapp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.commentDao;
import com.webapp.dao.productDao;
import com.webapp.dao.replyDao;
import com.webapp.model.commentModel;
import com.webapp.model.replyModel;

@WebServlet(urlPatterns = { "/san-pham" })
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	private commentDao commentdao;
	private productDao productdao;
	private replyDao replydao;

	public void init() {
		commentdao = new commentDao();
		productdao = new productDao();
		replydao = new replyDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idproduct = request.getParameter("idproduct");
		request.setAttribute("product", productdao.find_Product(idproduct));
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		String maxLocationreply = request.getParameter("maxLocationreply");
		List<commentModel> commentModels = commentdao.CommentInPage(Integer.parseInt(idproduct), "1", 0,1);
		request.setAttribute("idproduct", idproduct);
		request.setAttribute("commentModels", commentModels);
		String idcommentreply = request.getParameter("idcommentreply");
		List<replyModel> replymodel = replydao.ReplyInPage1(Integer.parseInt(idcommentreply),1,Integer.parseInt(maxLocationreply));
		request.setAttribute("reply", replymodel);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/product/product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idproduct = request.getParameter("idproduct");
		request.setAttribute("product", productdao.find_Product(idproduct));
		String page = request.getParameter("page");
		request.setAttribute("page", page);
		String maxLocationreply = request.getParameter("maxLocationreply");
		request.setAttribute("maxLocationreply", maxLocationreply);
		List<commentModel> commentModels = commentdao.CommentInPage(Integer.parseInt(idproduct), page, 0, 1);
		request.setAttribute("idproduct", idproduct);
		request.setAttribute("locationPage", commentdao.locationPage(page));
		request.setAttribute("commentModels", commentModels);

		RequestDispatcher rd = request.getRequestDispatcher("/views/web/product/product.jsp");
		rd.forward(request, response);
	}

}
