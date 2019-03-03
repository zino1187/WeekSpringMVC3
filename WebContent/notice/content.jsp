<%@page import="notice.model.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//컨트롤러가 보낸 Notice 꺼내기!!
	Notice notice=(Notice)request.getAttribute("notice");
%>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 15%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<script src="//cdn.ckeditor.com/4.11.2/standard/ckeditor.js"></script>
<script>
//문서가 로드될때 textarea를 접근하겠다
function init(){
	CKEDITOR.replace("content");
}

function edit(){
	if(!confirm("수정하시겠어요?")){
		return;
	}
	form1.action="/notice/edit";	
	form1.method="post";//데이터 양이 크기 때문
	form1.submit();
}
function del(){
	if(!confirm("삭제하시겠어요?")){
		return;
	}
	form1.action="/notice/delete";
	form1.method="post";
	form1.submit();
}
</script>
</head>
<body onLoad="init()">
  <div class="container">
    <h1>상세내용</h1>
    <p>작성한 내용을 확인할 수 있습니다</p>
    <hr>
    
	<form name="form1">
		<input type="hidden" value="<%=notice.getNotice_id()%>" name="notice_id"/>
	    <input type="text" value="<%=notice.getWriter() %>" name="writer" required>
	    <input type="text" value="<%=notice.getTitle() %>" name="title" required>
	    <textarea id="content" name="content" style="width:100%"><%=notice.getContent() %></textarea>
    </form>
    <button type="button" class="registerbtn" onClick="edit()">수정</button>
    <button type="button" class="registerbtn" onClick="del()">삭제</button>
    <button type="button" class="registerbtn" onClick="location.href='/notice/list'">목록</button>
    
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>


</body>
</html>
    