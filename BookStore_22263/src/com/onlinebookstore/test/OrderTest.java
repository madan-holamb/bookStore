package com.onlinebookstore.test;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.onlinebookstore.dao.OrdersDao;
import com.onlinebookstore.dao.OrdersDaoImpl;
import com.onlinebookstore.pojo.Orders;

public class OrderTest 
{
public static void main(String[] args) 
{
	String emailId;
	Scanner sc=new Scanner(System.in);
    OrdersDao OrdersDao=new OrdersDaoImpl();
	Orders o=new Orders();
    while(true)
    {
    	System.out.println("1.Place Orders");
    	System.out.println("2.Show all Orderss");
    	System.out.println("3.Check Status");
    	System.out.println("4.EXIT");
    System.out.println("Enter your choice");
    int ch=sc.nextInt();
    
    switch(ch)
    {
    case 1:
    	System.out.println("Please enter EmailId");
    	emailId=sc.next();
    int i=OrdersDao.placeOrders(o);
    	
    	if(i>0)
    	{
    		System.out.println("Orders placed..!! ");
    	}
    	else
    	{
    		System.out.println("Orders not placed..!!");
    	}
    	break;
    case 2:
    	List<Orders>al=OrdersDao.getAllOrders();
    	Iterator<Orders>itr=al.iterator();
    	while(itr.hasNext())
    	{
    		System.out.println(itr.next());
    	}
    	break;
    case 3:
    	System.out.println("Enter Orders id");
    	int OrdersId=sc.nextInt();
    	String OrdersStatus=OrdersDao.checkOrdersStatus(OrdersId);
    	System.out.println(OrdersStatus);
    	break;
    case 4:
    	System.exit(0);
    	break;
    	default:
    		System.out.println("Invalid Choice");
    }
}
}
}
