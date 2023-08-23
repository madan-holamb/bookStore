package com.onlinebookstore.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.onlinebookstore.pojo.Orders;
import com.onlinebookstore.utility.DBUtility;

public class OrdersDaoImpl implements OrdersDao {
	Connection conn=null;
	PreparedStatement ps=null;
	Orders o=new Orders();
	ResultSet rs;
	int OrdersId;
	Date d=null;



	/*public int placeOrders() 
	{
		double totalcost=0;
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select sum(b.prize * c.bookQuantity) as totalBill from Book_22263  b,Cart  c where b.bookId=c.bookId and c.emailId=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, emailId);
			rs=ps.executeQuery();
		if(rs.next())
			{
				totalcost=rs.getDouble("totalBill");
			}
		d=new Date();
		String today=d.toString();
		String sql1="insert into Orders(OrdersStatus,totalBill,emailId,OrdersDate)values(?,?,?,?)";
		PreparedStatement psc=conn.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
		psc.setString(1, "processing");
		psc.setDouble(2, totalcost);
		psc.setString(3, emailId);
		psc.setString(4, today);
		
		rs=psc.getGeneratedKeys();
		if(rs.next())
		{
			OrdersId=rs.getInt(1);
		}
		
			return OrdersId;
		
		
	     } 
		catch (Exception e) 
		{
		e.printStackTrace();
	}
		return 0;
	}*/

	@Override
	public List<Orders> getAllOrders() {
		try 
		{
			conn=DBUtility.getConnect();
			List<Orders>OrdersList=new ArrayList<Orders>();
			String sql="select * from Orders";
		    ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    { 
		    	Orders o=new Orders();
		    	o.setOrdersId(rs.getInt("OrdersId"));
		    	o.setOrdersStatus(rs.getString("OrdersStatus"));
		    	o.setTotalBill(rs.getDouble("totalBill"));
		    	o.setEmailId(rs.getString("emailId"));
		    	OrdersList.add(o);
		    }
		     return OrdersList;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String checkOrdersStatus(int OrdersId) {
		String status=null;
		try 
		{
			conn=DBUtility.getConnect();
			String sql="select OrdersStatus from Orders where OrdersId=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, OrdersId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				status=rs.getString("OrdersStatus");
			}
			return status;
			
		} 
		catch (Exception e)
        {
		
		}
		return null;
	}

	@Override
	public int placeOrders(Orders o) 
	{
		try 
		{
			conn=DBUtility.getConnect();
			String sql="insert into Orders(OrdersStatus,totalBill,emailId,OrdersDate)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "processing");
			ps.setDouble(2,o.getTotalBill());
			ps.setString(3, o.getEmailId());
			ps.setString(4, o.getOrdersDate());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
