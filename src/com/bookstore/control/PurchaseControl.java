package com.bookstore.control;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.BillDAO;
import com.bookstore.dao.BillDetailDAO;
import com.bookstore.entity.Account;
import com.bookstore.entity.Bill;
import com.bookstore.entity.BillDetail;
import com.bookstore.entity.Cart;
import com.bookstore.entity.CartItems;

/**
 * Servlet implementation class PurchaseControl
 */
@WebServlet("/purchase")
public class PurchaseControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession();
		
		Account account = (Account) s.getAttribute("acc");
		 Cart cart = (Cart) s.getAttribute("order");
		  int total = (int) s.getAttribute("total");
		   List<CartItems> cartItems = cart.getCartitem();
		   
		 if(cartItems.size() > 0) {
			 Bill bill = new Bill();
			 
			 bill.setAccID(account.getUid());
			 bill.setTotal(total);
			
			 int dd = Calendar.DATE;
			 int MM = Calendar.MONTH;
			 int YYYY = Calendar.YEAR;
			 @SuppressWarnings("deprecation")
			Date date = new Date(YYYY, MM, dd);
			 bill.setDatebuy(date);
			 //bill dao
			 BillDAO bd = new BillDAO();
			 bd.addBill(bill.getAccID(), bill.getTotal(), bill.getDatebuy());
			 int id = bd.getLast().getBillID();
			 
			 for(int i = 0; i<cartItems.size();i++) {
				 CartItems ci = cartItems.get(i);
				 
				 BillDetail billDetail = new BillDetail();
				 
				 billDetail.setBillID(id);
				 billDetail.setProid(ci.getProduct().getPid());
				 billDetail.setQuatity(ci.getSoluong());
				 billDetail.setBprice(ci.getGia());
				 //bill detail dao
				 BillDetailDAO bdd = new BillDetailDAO();
				 bdd.addBill(billDetail.getBillID(), billDetail.getProid(), billDetail.getQuatity(), billDetail.getBprice());
			 }
		 }
		 s.setAttribute("order", null);
		 response.sendRedirect("home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
