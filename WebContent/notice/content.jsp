<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  width: 100%;
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

//오라클에 넣자?, 넣기를 요청하자?
//클라이언트 스크립트 언어인 자바스크립트는 원본소스가 
//사용자들의 pc로 다운받아져서 실행되므로 보안처리가 불가능하다
//따라서 서버에 요청만 할 수 있다
function regist(){
	form1.method="post"; //내용이 많기 때문에 post방식으로
	//보내야 한다...
	form1.action="/notice/insert";
	form1.submit();//전송!!
}
</script>

</head>
<body onLoad="init()">


  <div class="container">
    <h1>상세내용</h1>
    <p>작성한 내용을 확인할 수 있습니다</p>
    <hr>
    
	<form name="form1">
	    <input type="text" placeholder="작성자 입력" name="writer" required>
	    <input type="text" placeholder="제목 입력" name="title" required>
	    <textarea id="content" name="content" placeholder="내용 입력" style="width:100%"></textarea>
    </form>
    <button type="button" class="registerbtn" onClick="regist()">Register</button>
    
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="#">Sign in</a>.</p>
  </div>


</body>
</html>
    