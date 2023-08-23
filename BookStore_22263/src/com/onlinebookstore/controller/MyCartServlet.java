package com.onlineboostore.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebookstore.dao.CartDao;
import com.onlinebookstore.dao.CartDaoImpl;
import com.onlinebookstore.dao.OrdersDao;
import com.onlinebookstore.dao.OrdersDaoImpl;
import com.onlinebookstore.pojo.Cart;
import com.onlinebookstore.pojo.Orders;

/**
 * Servlet implementation class MyCartServlet
 */
public class MyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       boolean flag;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String operation=request.getParameter("action");
		
		String usermail=(String) session.getAttribute("customerId");
		CartDao cartdao=new CartDaoImpl();
		if(operation!=null&& operation.equals("addToCart"))
		{
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		Cart c=new Cart();
		c.setEmailId(usermail);
		c.setBookId(bookId);
		c.setBookQuantity(1);
		flag=cartdao.addToCart(c);
		request.setAttribute("success", "book added to cart");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
		}
		else if(operation!=null&& operation.equals("delete"))
		{
		int cartId=Integer.parseInt(request.getParameter("cartId"));
		
		flag=cartdao.deleteFromCart(cartId);
		if(flag)
		{
			session.setAttribute("success", "book deleted from cart");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
		else {
			session.setAttribute("success", "book not deleted from cart");
		RequestDispatcher rd=request.getRequestDispatcher("cartList.jsp");
		rd.forward(request, response);
		}
		}
		
		else
		{
			List<Cart> mycart=cartdao.showCart(usermail);
			session.setAttribute("userCart",mycart);
			RequestDispatcher rd=request.getRequestDispatcher("cartList.jsp");
			rd.forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String price[]=request.getParameterValues("price");
		String quantity[]=request.getParameterValues("bookQuantity");
		HttpSession session=request.getSession();
		String userMail=(String)session.getAttribute("customerId");
		double total=0;
		if(!price.equals(null)) {
		for(int i=0;i<price.length;i++)
		{
			total=total+Double.parseDouble(price[i])*Integer.parseInt(quantity[i]);
		}
		Orders o=new Orders();
		o.setEmailId(userMail);
		o.setTotalBill(total);
		o.setOrdersStatus("placed");
		o.setOrdersDate(new Date().toString());
		OrdersDao orderDao=new OrdersDaoImpl();
		int orderId=orderDao.placeOrders(o);
		System.out.println(orderId);
		if(orderId>0)
		{
			CartDao cartdao=new CartDaoImpl();
			cartdao.clearCart(userMail);
			session.setAttribute("success","your order is placed"+orderId+" "+total);
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			
		}
		}
	}

}
