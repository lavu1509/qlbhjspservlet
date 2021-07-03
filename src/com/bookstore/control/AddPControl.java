package com.bookstore.control;

import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Account;


/**
 * Servlet implementation class AddPControl
 */
@WebServlet(name = "AddControl", urlPatterns = {"/addp"})
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AddPControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPControl() {
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
        String pname = request.getParameter("name");
//        Part path = request.getPart("image");
        
//        String filename = Path.of(path.getSubmittedFileName()).toString();
        
        String pprice = request.getParameter("price");
        String pauthor = request.getParameter("author");
        String ptitle = request.getParameter("title");
        String pdescription = request.getParameter("description");
        String pdetail = request.getParameter("detail");
        String pcid = request.getParameter("category");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        int sid = a.getUid();
        
        
        String realPath = request.getServletContext().getRealPath("/upload");
        Part filePart = request.getPart("image");
        String fileName = Path.of(filePart.getSubmittedFileName()).toString();
        	
        if(!Files.exists(Path.of(realPath))) {
        	Files.createDirectory(Path.of(realPath));
        }
          filePart.write(realPath+"/" + fileName);
        
        
        ProductDAO dao = new ProductDAO();
        dao.insertProduct(pname, fileName, pprice, pauthor, ptitle, pdescription, pdetail, pcid, sid);
        response.sendRedirect("managerp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
