<%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>          
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Join</title>  
     
   </head>  
    <body>  
   	<form action="/www/insertMember.do"  method="post">  
      
    	<table>  
    	<tr><td>이름</td><td><input type="text" name="mName"/></td></tr>  
    	<tr><td>ID</td><td><input type="text"  name="mId"/></td></tr>  
    	<tr><td>PW</td><td><input type="text"  name="mPw"/></td></tr>  
    	<tr><td>PW재입력 </td><td><input type=""  name="mPw2"/></td></tr>
    	<tr><td>비밀번호 질문 </td><td> <select name="qNum">  
    		<c:forEach items="${QUESTION_LIST}" var="Q">  
    			<option value="${Q.qNum}">${Q.qName}</option>  
    		</c:forEach>  
    	</select></td></tr>  
    	<tr><td>답변</td><td><input type="text"  name="mAnswer"/></td></tr>  
    	<tr><td>연락처</td><td><input type="text"  name="mPhone"/></td></tr>  
    	<tr><td>주소</td><td><input type="text"  name="mAddress"/></td></tr>  
    	<br/>  
    	</table>
    	<input type="submit"  value="회원가입"/><input type="reset" value="초기화">
   	</form>	  
      
    </body>  
    </html>  
