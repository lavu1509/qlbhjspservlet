package com.bookstore.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.AccountDAO;
import com.bookstore.entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		 request.setCharacterEncoding("UTF-8");
	        String username = request.getParameter("user");
	        String password = request.getParameter("pass");
	        AccountDAO dao = new AccountDAO();
	        Account a = dao.login(username, password);
	        
	        String err = "";
	        
				if (a == null) {
					err += "Tên đăng nhập hoặc mật khẩu không chính xác!";
				}
			
	        
			if (err.length() > 0) {
				request.setAttribute("err", err);
			} 
			
			try{
				if (err.length() == 0) {
				Cookie loginCookie = new Cookie("username",username);
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(30*60);
	            response.addCookie(loginCookie);
	            
	            
				HttpSession session = request.getSession();
	            session.setAttribute("acc", a);
	            session.setMaxInactiveInterval(30*60);
	            response.sendRedirect("home");}
				else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
	            }
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				response.sendRedirect("login.jsp");
			}
			
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
