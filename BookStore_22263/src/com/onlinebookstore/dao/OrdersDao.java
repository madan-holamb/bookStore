package com.onlinebookstore.dao;

import java.util.List;

import com.onlinebookstore.pojo.Orders;

public interface OrdersDao 
{
public int placeOrders(Orders o);
//public int placeOrders(String emailId,double totalBill);
public List<Orders>getAllOrders();
public String checkOrdersStatus(int OrdersId);
}
