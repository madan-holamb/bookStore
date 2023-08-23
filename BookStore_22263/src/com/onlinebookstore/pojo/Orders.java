package com.onlinebookstore.pojo;

public class Orders 
{
 private int OrdersId;
 private String OrdersStatus;
 private double totalBill;
 private String emailId;
 private String OrdersDate;
 
public String getOrdersDate() {
	return OrdersDate;
}
public void setOrdersDate(String OrdersDate) {
	this.OrdersDate = OrdersDate;
}
public int getOrdersId() {
	return OrdersId;
}
public void setOrdersId(int OrdersId) {
	this.OrdersId = OrdersId;
}
public String getOrdersStatus() {
	return OrdersStatus;
}
public void setOrdersStatus(String OrdersStatus) {
	this.OrdersStatus = OrdersStatus;
}
public double getTotalBill() {
	return totalBill;
}
public void setTotalBill(double totalBill) {
	this.totalBill = totalBill;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
@Override
public String toString() {
	return "Orders [OrdersId=" + OrdersId + ", OrdersStatus=" + OrdersStatus + ", totalBill=" + totalBill + ", emailId="
			+ emailId + ", OrdersDate=" + OrdersDate + "]";
}


}
