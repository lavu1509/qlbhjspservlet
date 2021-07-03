package com.bookstore.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Account;
import com.bookstore.entity.Category;
import com.bookstore.entity.Product;

/**
 * Servlet implementation class ManagerPControl
 */
@WebServlet(name = "ManagerPControl", urlPatterns = {"/managerp"})
public class ManagerPControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String indexpage = request.getParameter("index");
        if(indexpage == null) {
        	indexpage = "1";
        }
        int index = Integer.parseInt(indexpage);
        
        Account a = (Account) session.getAttribute("acc");
        int id = a.getUid();
        ProductDAO dao = new ProductDAO();
        CategoryDAO dao1 = new CategoryDAO();
        List<Product> listp = dao.getProductPagingBySellID(index, id);
        List<Category> listc = dao1.getAllCategory();
        
        int count = dao.getTotalPagingBySellID(id);
        int end = count/5;
        if(count%5!=0) {
        	end++;
        }
        request.setAttribute("count", count);
        request.setAttribute("end", end);
        request.setAttribute("tag", index);
        request.setAttribute("listc", listc);
        request.setAttribute("listp", listp);
        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
