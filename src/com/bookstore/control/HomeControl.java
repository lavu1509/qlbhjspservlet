package com.bookstore.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Product;

/**
 * Servlet implementation class HomeControl
 */
@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeControl() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String indexpage = request.getParameter("index");
        if(indexpage == null) {
        	indexpage = "1";
        }
        int index = Integer.parseInt(indexpage);
		
		ProductDAO dao = new ProductDAO();
		CategoryDAO dao2 = new CategoryDAO();
		Product last = dao.getLast();
		List<Product> listp = dao.getProductPaging(index);
		List<Category> listc = dao2.getAllCategory();
		
		 int count = dao.getTotalPaging();
	        int end = count/6;
	        if(count%6!=0) {
	        	end++;
	        }
	        
	    request.setAttribute("count", count);
		request.setAttribute("end", end);
        request.setAttribute("tag", index);
		request.setAttribute("listp", listp);
		request.setAttribute("listc", listc);
		request.setAttribute("last", last);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	//404 -> url
    //500 -> jsp properties
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
