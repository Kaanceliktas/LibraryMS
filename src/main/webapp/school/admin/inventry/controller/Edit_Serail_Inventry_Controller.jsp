<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<%@page import="common.Common_Things"%>
<%@page import="Librepository_Table_Model.Librepository_Table_Model"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<jsp:useBean id="obj_Book_Use_Bean" class="common_use_bean.Book_Use_Bean"></jsp:useBean>
	<jsp:setProperty property="*" name="obj_Book_Use_Bean"/>
	
	<%
			
	
	  
	   
	   
	Librepository_Table_Model obj_Librepository_Table_Model=new Librepository_Table_Model();
	      
	   int flag=obj_Librepository_Table_Model.edit_serial_status(obj_Book_Use_Bean);
	   
	   if(flag==1){
		   
			
			session.setAttribute("edit_librepository_message","Editted Successfully");
		
	   }else{

			 session.setAttribute("edit_librepository_message","Failed");
		 
	   } 
	   
	    
	   
		%>
		
		
		 
		  
		  		 <script type="text/javascript">
						window.location.href="<%=Common_Things.url%>/edit-librepository-serial/?s=<%=obj_Book_Use_Bean.getSl_no()%>";
				</script>
	
	
	  
</body>
</html>