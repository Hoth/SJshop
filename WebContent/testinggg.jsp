<%@ page language="java" %>
<%@ page import="java.lang.*" %>
<%@ page contentType="text/html;charset=euc-kr" %>


 <html> 
 <head> 
 <title>상하(좌우) 3단 프레임</title> 
 </head> 
 <frameset rows="40,*" frameborder="0" border="0" scrolling="no" frameborder="0"> 
 <frame src="top.jsp" scrolling="no" noresize > <frameset cols="150,*" frameborder="0" border="0" > 
 <frame src="menu.jsp" scrolling="no" frameborder="0" border="0" framespacing="0" noresize> 
 <frame src="Main.jsp" name="main" id="main"> 
 </frameset></frameset>
 </html>

