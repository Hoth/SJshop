<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/www/se2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="/www/se2/photo_uploader/plugin/hp_SE2M_AttachQuickPhoto.js" charset="utf-8"></script>

</head>
<body>
등록페이지.<p>
	
<form name="upload" method="post"  action="/www/insertGood.do" onSubmit="return submitContents(this)" enctype="multipart/form-data" > 
"WebContent/member/insertMemberForm.jsp"
<table> 
<tr><td>제목 </td><td> <input type="text" name="gName"></td></tr>
<tr><td>가격 </td><td> <input type="text" name="gPrice">원.</td></tr>
<tr><td>카테고리 </td><td> <select name="qNums" onChange="getSelectValue(this.form);">  
    		<c:forEach items="${CATEGORY_LIST}" var="C">  
    			<option value="${C.cNum}">${C.cName}</option>  
    		</c:forEach>  
    	</select></td></tr>
<tr><td>대표파일 </td><td> <input type="file" name="file"></td></tr>
<tr><td>대표설명 </td><td> <input type="text" name="gMainDetail"></td></tr>
</table>
	<!-- Smart Editor -->
<textarea style="width: 100%" rows="50" name="gDetail" id="textAreaContent" cols="80"></textarea>

 <input type="submit" value="올리기" ><br>
 </form>
 <script type="text/javascript">
 
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
    oAppRef: oEditors,
    elPlaceHolder: "textAreaContent",
    sSkinURI: "/www/se2/SmartEditor2Skin.html",
    fCreator: "createSEditor2"
});
 
//‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
function submitContents(elClickedObj) {
    // 에디터의 내용이 textarea에 적용된다.
    oEditors.getById["textAreaContent"].exec("UPDATE_CONTENTS_FIELD", [ ]);
 
    // 에디터의 내용에 대한 값 검증은 이곳에서
    // document.getElementById("textAreaContent").value를 이용해서 처리한다.
  
    try {
        elClickedObj.form.submit();
    } catch(e) {
     
    }
}
 
// textArea에 이미지 첨부
function pasteHTML(filepath){
    var sHTML = '<img src="/www/photo/'+filepath+'">';
    oEditors.getById["textAreaContent"].exec("PASTE_HTML", [sHTML]);
}
 	
</script>
</body>
</html>