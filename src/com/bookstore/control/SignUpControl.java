package com.bookstore.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.AccountDAO;
import com.bookstore.entity.Account;

/**
 * Servlet implementation class SignUpControl
 */
@WebServlet(name = "SignUpControl", urlPatterns = {"/signup"})
public class SignUpControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        String user = request.getParameter("user");
	        String pass = request.getParameter("pass");
	        String email = request.getParameter("email");
	        
	        String fullname = request.getParameter("name");
	        String phone = request.getParameter("phone");
	        String address = request.getParameter("address");
	        
	        String re_pass = request.getParameter("repass");
	        if(!pass.equals(re_pass)){
	            response.sendRedirect("login.jsp");
	        }else{
	            AccountDAO dao = new AccountDAO();
	            Account a = dao.checkAccountExist(user);
	            if(a == null){
	                //dc signup
	                dao.singup(user, pass,email,fullname,phone,address);
	                response.sendRedirect("home");
	            }else{
	                //day ve trang login.jsp
	                response.sendRedirect("login.jsp");
	            }
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
