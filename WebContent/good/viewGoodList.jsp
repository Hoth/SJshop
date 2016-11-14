<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%
response.setHeader("cache-control","no-cache"); 
%>

<!DOCTYPE html> 
<html> 
	<body>
	<div id="phonelist" data-role="page" data-theme="a">
	<div data-role="header" data-position="fixed" data-theme="a">
		<h1>물건리스트</h1>
		<a href="#" data-icon="arrow-l" data-rel="back">이전</a>
		<a href="#" data-role="button" data-icon="arrow-r">다음</a>     
	</div> 
	
	<div data-role="content">
		<ul data-role="listview">
			<c:forEach items="${GOOD_LIST}"
			   var="GOOD">
			   <li>
			   	  <a href="viewGood.do?gnum=${GOOD.gnum}">
					<img src="photo/${GOOD.img}"/>
					<!-- /home/hosting_users/feelk22/photo -->
					${GOOD.name}
			   	  </a>
			   	</li>  	 
			</c:forEach>
		</ul>
    </div>

	<div data-role="footer" data-position="fixed" data-theme="a">
	
	<div data-role="navbar">
		<ul>
		<li>
				<a href="addCustomerForm.do" data-icon="plus" rel="external">
				회원가입
				</a>
			</li>
			<li>
			
				<c:if test="${sessionScope.LOGIN_CUSTOMER==null}">
				
				<a href="loginCustomerForm.do" data-icon="gear" rel="external">
				로그인
				</a>
				</c:if>
				
				<c:if test="${sessionScope.LOGIN_CUSTOMER!=null}">
				<a href="logoutCustomer.do" data-icon="gear" rel="external">
				로그아웃
				</a>
				</c:if>
			 	
			</li>
			<li>
				<a href="viewCartList.do" data-icon="plus" rel="external">
				장바구니 조회
				</a>
			</li>
		</ul>		
	</div>
	</div>
</div>
</body>
</html>