<%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Join</title>  
     
   </head>  
    <body>  
   	<form action="addMember.do"  method="post">  
      
    	<table>  
    	<tr><td>이름</td><td><input type="text" name="studno"/></td></tr>  
    	<tr><td>ID</td><td><input type="text"  name="name"/></td></tr>  
    	<tr><td>PW<input type="text"  name="grade"/></td></tr>  
    	<tr><td>PW재입력    	<select name="deptno">  
    		<c:forEach items="${QUESTION_LIST}" var="Q">  
    			<option value="${Q.qNum}">${Q.qName}</option>  
    		</c:forEach>  
    	</select></td></tr>  
    	<tr><td>비밀번호 질문<input type=""  name="grade"/></td></tr>  
    	<tr><td>답변<input type="text"  name="grade"/></td></tr>  
    	<tr><td>연락처<input type="text"  name="grade"/></td></tr>  
    	<tr><td>주소<input type="text"  name="grade"/></td></tr>  
    	  
    	 
  
    	<br/>  
    	<input type="submit"  value="학생추가"/>  
   	</form>	  
      
    </body>  
    </html>  
