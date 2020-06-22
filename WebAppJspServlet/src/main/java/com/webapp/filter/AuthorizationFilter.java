package com.webapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.model.userModel;
import com.webapp.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		userModel model = (userModel) SessionUtil.getInstance().getValue(request, "usermodel");
		String thongBao="";
		if (url.startsWith("/admin")) {
			if (model != null) {
				if (model.getRoleid() == 2) {
					filterChain.doFilter(servletRequest, servletResponse);
				} else if (model.getRoleid() == 1) {
					thongBao="Tài khoản không được phép truy cập!!!";
					request.setAttribute("thongBao", thongBao);
					RequestDispatcher rd = request.getRequestDispatcher("/views/web/login/login.jsp");
					rd.forward(request, response);
				}
			} else {
				thongBao="Vui lòng đăng nhập!!!";
				request.setAttribute("thongBao", thongBao);
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/login/login.jsp");
				rd.forward(request, response);
			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	public void destroy() {

	}
}
