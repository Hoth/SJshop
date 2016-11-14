<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<%
response.setHeader("cache-control","no-cache"); 
%>

<!DOCTYPE html> 
<html> 
	<head> 
		<title>물건 상세 정보</title> 
		
		
	</head>
	<body> 
	<div id="phonedetail" data-role="page" data-theme="a">
	<div data-role="header" data-theme="a">
		<h1>물건상세 내용</h1>
	</div>  

	<div data-role="content">
		<ul data-role="listview">
			<li>
				<table>
					<tr>
						<td style="padding-right: 5px">
						
							<img src="photo/${GOOD.img}"/>
						
						
						</td>
						<td style="padding-left: 5px">
							<table>
								<tr style="padding: 5px">
									<td style="padding: 5px">물건정보 : </td>
									<td>
									
									${GOOD.detail}
									
									</td>
								</tr>
								
								<tr style="padding: 5px">
									<td style="padding: 5px">상품가 : </td>
									<td>
									
									${GOOD.price}
									</td>
								</tr>
								<tr>
									<td>

								
								<form action="addCart.do"  method="post">
								<input type="hidden"  name="method"  value="addCart"/>
    							<input type="hidden"  name="gnum"  value="${GOOD.gnum}"/>
								<input type="hidden"  name="name"  value="${GOOD.name}"/>
								<input type="hidden" name="price" value="${GOOD.price}"/>
								<input type="hidden" name="img" value="${GOOD.img}"/>
  								<!-- 장바구니에 담을 물건의 개수 입력 -->
  								<input type="text" name="qty"  value="1"/>
 								<!-- 장바구니 추가 버튼 -->
 								<input type="submit"  value="장바구니 추가"  />
								</form>
								

								</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</li>
		</ul>
    </div>
    
	<div data-role="footer" data-position="fixed" data-theme="a">
	<div data-role="navbar">
	
	<ul>
		<li>
		

			<a href="viewGoodList.do" data-icon="grid">
			목록
			</a>
		</li>
		<li>
			<a href="viewCartList.do" data-icon="grid">
			장바구니
			</a>
		</li>
	</ul>
	</div>	
    </div>
</div>
</body>
</html>