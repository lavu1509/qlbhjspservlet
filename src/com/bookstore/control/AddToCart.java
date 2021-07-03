package com.bookstore.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.dao.ProductDAO;
import com.bookstore.entity.Cart;
import com.bookstore.entity.CartItems;
import com.bookstore.entity.Product;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet(name = "AddToCart",urlPatterns = {"/addtocart"})
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int quality = 1;
		String id;
		int total=0;
		ProductDAO dao = new ProductDAO();
		if(request.getParameter("pid")!=null) {
			id = request.getParameter("pid");
			Product pro = dao.getProductByID(id);
			if(pro!=null) {
				HttpSession httpSession = request.getSession();
				
				if(httpSession.getAttribute("order")==null) {
					Cart cart = new Cart();
					List<CartItems> cartItems = new ArrayList<CartItems>();
					CartItems item = new CartItems();
					item.setSoluong(quality);
					item.setProduct(pro);
					item.setGia(pro.getPrice());
					
					cartItems.add(item);
					cart.setCartitem(cartItems);
					total = total + item.getGia()*item.getSoluong();
					httpSession.setAttribute("total", total);
					httpSession.setAttribute("order", cart);
				}else {
					Cart cart = (Cart) httpSession.getAttribute("order");
					total = (int) httpSession.getAttribute("total");
					List<CartItems> cartItems = cart.getCartitem();
					boolean check = false;
					
					for(CartItems i : cartItems) {
						if(i.getProduct().getPid()==pro.getPid()) {
							i.setSoluong(i.getSoluong()+quality);
							total = total + i.getGia()*quality;
							check = true;
						}
					}
					if(check == false) {
						CartItems item = new CartItems();
						item.setSoluong(quality);
						item.setProduct(pro);
						item.setGia(pro.getPrice());
						
						cartItems.add(item);
						total = total + item.getGia()*item.getSoluong();
					}
					httpSession.setAttribute("total", total);
					httpSession.setAttribute("order", cart);
				}
				
			}
			response.sendRedirect("home");
		}else {
			response.sendRedirect("home");
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
