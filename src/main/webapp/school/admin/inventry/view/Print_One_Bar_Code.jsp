<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 

<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.pdf.PdfDocument"%>
<%@page import="java.io.File"%>
<%@page import="com.itextpdf.text.pdf.PdfPage"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.Element"%>



<%@page import="com.itextpdf.text.Image"%>
<%@page import="java.net.URL"%>
<%@page import="com.itextpdf.text.Font"%>
<%@page import="com.itextpdf.text.Phrase"%>
<%@page import="com.itextpdf.text.Chunk"%>
<%@page import="com.itextpdf.text.Rectangle"%>
<%@page import="com.itextpdf.text.pdf.PdfContentByte"%>
<%@page import="com.itextpdf.text.pdf.BaseFont"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.itextpdf.text.pdf.Barcode128"%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.DocWriter"%>
<%@page import="common_use_bean.Book_Use_Bean"%>
<%@page import="Librepository_Table_Model.Librepository_Table_Model"%><html>

<head>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	

<br style="clear: both;" />
<center>

	


		
		<%
				
		
		response.setContentType("application/pdf");
		 String l=(String)request.getParameter("l");
		 String h=(String)request.getParameter("h");
		 String bar=(String)request.getParameter("bar");
		 float lf = Float.parseFloat(l);
		 float lh = Float.parseFloat(h);
		
		
		Rectangle pageSize = new Rectangle(lf,lh);                
	    Document document = new Document(pageSize);
	    PdfWriter writer=PdfWriter.getInstance(document, response.getOutputStream());
	    
		
		 document.open();
		
		 
		  
		
	    
	   
	    
	    
   //PdfWriter.getInstance(document, response.getOutputStream());
  
		
   
   
 		
   //document.add(new Paragraph("Name"));
   
   Barcode128 code128 = new Barcode128();
    code128.setX(2.4f);  
       
    code128.setBaseline(10f);    
   code128.setGenerateChecksum(true); 
   code128.setSize(35f);  
        
   code128.setBarHeight(50f);           
   code128.setCode(bar);        
   code128.setBaseline(30f);   
   	document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
   	 
	 
	  
				
				
				/*
				  PdfContentByte cb = writer.getDirectContent();
				    cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, false), 24);
				    cb.setLineWidth(3);
				    cb.moveTo(10, 515);
				    cb.lineTo(770,515 );
				    cb.moveTo(10, 10);
				    cb.lineTo(770,10 );
				    cb.moveTo(770, 515);
				    cb.lineTo(770, 10);
				    cb.moveTo(10, 515);
				    cb.lineTo(10, 10);
				    cb.stroke();

				    */  
				
				    document.close();

								
				
				
	  
	%>
		
		
			
				
				
	








</center>
</body>
</html>