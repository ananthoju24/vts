package com.gov.vill.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginrequest")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login Request ");

		String userId = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("userId " + userId + " pwd " + password);
		if ("admin".equals(userId) && "1234".equals(password)) {
			request.setAttribute("username", userId);
			System.out.println(" Success login and redirect to home ");
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession();
			session.setAttribute("username", userId);
			session.setMaxInactiveInterval(30 * 60); // 30 mins
			//request.getRequestDispatcher("/admin/home").forward(request, response);
			response.sendRedirect("admin/home");
		} else {
			System.out.println(" login failed so redirect to login page");
			request.setAttribute("errorMsg", "Invalid username or password.");
			RequestDispatcher rDispatcher = request.getRequestDispatcher("/");
			rDispatcher.forward(request, response);
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
