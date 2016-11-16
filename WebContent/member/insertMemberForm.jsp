<%@ page language="java" contentType="text/html; charset=UTF-8"  
        pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Join</title>  
     <script language="javascript">

function getSelectValue(frm)
{
 frm.qNum.value = frm.qNums.options[frm.qNums.selectedIndex].text;
 frm.qNum.value = frm.qNums.options[frm.qNums.selectedIndex].value;
 //alert(frm.qNum.value);
}

</script>

<script>
function check() {
  if(IM.mId.value == "") {
    alert("아이디를 입력하세요");
    IM.mID.focus();
    return false;
  }
  else if(IM.mPw.value == "") {
    alert("비번을 입역하세요");
    IM.mPw.focus();
    return false;
  }
  else return true;
}
</script>	


   </head>  
    <body>  
   	<form action="/www/insertMember.do" name="IM"  method="post" onsubmit="return check()">  
      
    	<table>  
    	<tr><td>이름</td><td><input type="text" name="mName"/></td></tr>  
    	<tr><td>ID</td><td><input type="text"  name="mId"/></td></tr>  
    	<tr><td>PW</td><td><input type="text"  name="mPw"/></td></tr>  
    	<tr><td>PW재입력 </td><td><input type="text"  name="mPw2"/></td></tr>
    	<tr><td>비밀번호 질문 </td><td> <select name="qNums" onChange="getSelectValue(this.form);">  
    		<c:forEach items="${QUESTION_LIST}" var="Q">  
    			<option value="${Q.qNum}">${Q.qName}</option>  
    		</c:forEach>  
    	</select></td></tr>  
    	<input type ="hidden" name = "qNum" value="1"/>
    	<tr><td>답변</td><td><input type="text"  name="mAnswer"/></td></tr>  
    	<tr><td>연락처</td><td><input type="text"  name="mPhone"/></td></tr> 
    	<tr><td>이메일</td><td><input type="text"  name="mEmail"/></td></tr>  
    	<tr><td>주소</td><td><input type="text"  name="mAddress"/></td></tr>  
    	<br/>  
    	</table>
    	<input type="submit"  value="회원가입"/><input type="reset" value="초기화">
   	</form>	  
      
      
      <script>
		<c:if test="${ERROR!=null}">
		alert("${ERROR}");
		</c:if>	
	</script>
      
    </body>  
    </html>  
