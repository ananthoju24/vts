package com.gov.vill.login;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {
	ServletContext context;

	public SessionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("================= Session");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		request.setCharacterEncoding("UTF-8");
		if (null != session) {
			/*try {
				String userId = (String) session.getAttribute("username");
				System.out.println("User id " + userId);
				if (null != userId  || "".equals(userId)) {
					this.context.log("Invalid request");
					resp.sendRedirect("../login");
				} else {*/
					chain.doFilter(request, response);
		/*		}
			} catch (Exception e) {
				System.out.println("Session Exception");
				resp.sendRedirect("../login");
			}*/
		} else {
			System.out.println("Session is null");
			resp.sendRedirect("../login");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("================= Session Filter initialized");
		this.context = fConfig.getServletContext();
		this.context.log("Session management filter initialized");
	}

}
