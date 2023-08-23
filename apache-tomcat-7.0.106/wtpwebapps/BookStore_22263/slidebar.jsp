<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.onlinebookstore.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Slidebar</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="templatemo_content_left_section">
            	<h1>Categories</h1>
            	<%-- <%
List<Book>categoryList=(List<Book>)session.getAttribute("bookCategory");
 if(categoryList!=null && categoryList.size()>0)
 {
	 for(int i=0;i<categoryList.size();i++)
	 {
		 Book book=(Book)categoryList.get(i);
		 
%> --%>
            <c:forEach var="f" items="${bookCategory}">	
            <img src="images/${f.filename}" alt="" width="100" height="100" />
                <ul>
                    <li><a href="BookServlet?action=searchByCategory&category=${f.category}">${f.category}</a></li>
                    
                   
            	</ul>
            	</c:forEach>
            	<%-- <%}} %> --%>
            	
            </div>
			<div class="templatemo_content_left_section">
            	<h1>Publisher</h1>
            	<%-- <%
List<Book>publisherList=(List<Book>)session.getAttribute("bookPublisher");
 if(publisherList!=null && publisherList.size()>0)
 {
	 for(int i=0;i<publisherList.size();i++)
	 {
		 Book book=(Book)publisherList.get(i);
		 
%> --%>
 <c:forEach var="f" items="${bookPublisher}">	
  <img src="images/${f.filename}" alt="" width="100" height="100" />
                <ul>
                    <li><a href="BookServlet?action=searchByPublisher&publisher=${f.publisher}">${f.publisher}</a></li>
            	</ul>
            	</c:forEach>
            	<%-- <%}} %> --%>
            </div>
</body>
</html>