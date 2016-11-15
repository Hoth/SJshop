<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%

String path = "C:/Users/bit-user/git/SJshop/WebContent/photo"; // 이미지가 저장될 주소
//D:/workspace3/www/WebContent/photo
///home/hosting_users/feelk22/photo
//C:\Users\bit-user\git\SJshop\WebContent\photo
String filename = "";
/*
path는 스마트에디터로 이미지를 첨부했을 시에 업로드 될 경로다.
참고: 만약 path를 request.getSession().getServletContext().getRealPath("/") + 
File.separator + "저장될 폴더" 이런 식으로 써주면 폴더를 새로고침 하지 않아도 이미지를 즉각적으로 확인할 수 있다. 
이 때 이미지가 저장되는 곳은 metadata쪽이다.
*/
if(request.getContentLength() > 10*1024*1024 ){
%>
	<script>alert("업로드 용량(총 10Mytes)을 초과하였습니다.");history.back();</script>
<%
	return;

} else {

	try {

		
		MultipartRequest multi=new MultipartRequest(request, path, 15*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
	
		java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat ("yyyy_MM_dd_HHmmss", java.util.Locale.KOREA);
		int cnt = 1;
		String upfile = (multi.getFilesystemName("Filedata"));
		if (!upfile.equals("")) {
			String dateString = formatter2.format(new java.util.Date());
			String moveFileName = dateString + upfile.substring(upfile.lastIndexOf(".") );
			String fileExt = upfile.substring(upfile.lastIndexOf(".") + 1);
			File sourceFile = new File(path + File.separator + upfile);
			File targetFile = new File(path + File.separator + moveFileName);
			sourceFile.renameTo(targetFile);
			filename = moveFileName;
			System.out.println("upfile : " + upfile);
			System.out.println("targetFile : " + targetFile);
			System.out.println("moveFileName : " + moveFileName);
			System.out.println("filename : " + filename);
			System.out.println("moveFileName : " + moveFileName);
			
			sourceFile.delete();
			
			%>
			<form id="fileform" name="fileform" method="post">
				<input type="hidden" name="filename" value="<%=filename%>">
				<input type="hidden" name="path" value="<%=path%>">
				<input type="hidden" name="fcode" value="<%=path%>">
			</form>
			<%
		}
	} catch (Exception e) {
		System.out.println("e : " + e.getMessage());
	}
}
%>

<script type="text/javascript">
	function fileAttach(){ 
		f = document.fileform;
		fpath = f.path.value;
	    fname = f.filename.value; 
	    fcode = fpath + fname;
	    
	   
	    try{
             window.opener.pasteHTML(fname); 
	    	
	    	 window.close();
	    }catch(e){ 
//             alert(e); 
	    }
	}
	fileAttach();
	this.window.close();
</script>
