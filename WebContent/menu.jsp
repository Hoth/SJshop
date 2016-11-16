<%@ page language="java" %>
<%@ page import="java.lang.*" %>
<%@ page contentType="text/html;charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <body>

  <p>MENU</p>
  	<ul data-role="listview">
  				<li>
			   	  <a href="/www/InsertGood.do" target="main">등록</a>
			   	</li>
			   <li>
			   	  <a href="viewGoodList.do?cNum=${1}" target="main">TOP</a>
			   	</li> 
			   	<li>
			   	  <a href="viewGoodList.do?cNum=${2}" target="main">OUTER</a>
			   	</li>
			   	<li>
			   	  <a href="viewGoodList.do?cNum=${3}" target="main">BUTTOM</a>
			   	</li>
			   	<li>
			   	  <a href="viewGoodList.do?cNum=${4}" target="main">ACC</a>
			   	</li> 	 
		</ul>
  
  <!-- 
  <a href="/www/viewGoodList.do" target="main">상품보기</a><p>
  <a href="/www/Main.jsp" target="main">처음화면</a><p>
  <a href="/www/InsertGood.do" target="main">등록</a><p>
  -->
  </body>
</html>

 