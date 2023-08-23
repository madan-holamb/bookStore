<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>search</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js"
	type="text/javascript"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryyui/1.7.2/jquery.-ui-min.js"
	type="text/javascript"></script>
	
<script type="text/javascript">
$(document).ready(function()
{
	$("table").hide();
	$("button").click(function(e)
	{
		e.preventDefault();
		 var Bookname=$("#bookname").val();
		 alert("hello:::"+Bookname);
		 $.ajax({
			 url:"BookServlet?action=searchByName&bookname="+Bookname,
	         type:"get",
	         data: Bookname,
	         dataType:"json",
	         
	         success: function(responseJson){
	        	 if(responseJson!=null)
	        		 {
	        		 alert("hhhhh");
	        		 $("tbody").html("");
	        		 $.each(responseJson,function(index,obj){
	        			 
	        			 if(obj!=null)
	        				 {
	        				 $("table").css("display","block");
	        				 
	        				 $("tbody").append("<tr><td>"+obj.bookId+"<td>");
	        				 $("tbody").append("<td>"+obj.bookName+"<td>");
	        				 $("tbody").append("<td>"+obj.prize+"<td>");
	        				 $("tbody").append("<td>"+obj.authorName+"<td>");
	        				 $("tbody").append("<td>"+obj.publisher+"<td>");
	        				 $("tbody").append("<td>"+obj.bookDesc+"<td>");
	        				 $("tbody").append("<td>"+obj.category+"<td>");
	        				 $("tbody").append("<td>"+obj.quantity+"<td></tr>")
	        				 
	        				 }
	        		 });
	        		 
	        		 
	        		 
	        		 }
	        	 
	        	 
	        	 
	         }
			 
		 });
		
		
		
		

	});
	
	
});






</script>

</head>
<body>

<center>
<jsp:include page="header.jsp" ></jsp:include>


<h1><u><b>Search</b></u></h1>
<input type="text" name="bookname" id="bookname">
<button>Search</button>
<form action="" method="" >
<table  border="1">
<tbody>
</tbody>
<thead>
<tr>
<td>Book Id</td>
<td>Book name</td>
<td>Price</td>
<td>Author</td>
<td>Publisher</td>
<td>Book Description</td>
<td>Category</td>
<td>Quantity</td>
</tr>
</thead>


</table>


 <jsp:include page="footer.jsp" ></jsp:include>
 </form>
</center>

</body>
</html>