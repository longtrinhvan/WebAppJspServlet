package com.webapp.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.dao.producerDao;

@WebServlet(urlPatterns = { "/trang-chu"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;
	private producerDao producerdao;
	public void init() {
		producerdao = new producerDao();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("producerModel", producerdao.SelectAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
}
