<%@page import="notice.model.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Notice> list=(List)request.getAttribute("list");//list라는 이름으로 담긴 객체를 꺼낸다!
%>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2
}
</style>
<script>
/*자바스크립트 언어란?
1)jsp는 서버에서만 실행되고, javascript는 클라이언트에서만 수행됨..
2)자바스크립트 사용이유는?
    html은 프로그램 능력이 없는 그냥 문서이기 때문에 html의 
    프로그래밍적 기능을 보완하기 위해 사용됨..		
*/
function registForm(){
	location.href="/notice/registerForm.jsp";
}
</script>
</head>
<body>
<h2>Zebra Striped Table</h2>
<p>For zebra-striped tables, use the nth-child() selector and add a background-color to all even (or odd) table rows:</p>

<table>
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>작성자</th>
    <th>작성일</th>
    <th>조회수</th>
  </tr>
  <%for(int i=0;i<list.size();i++){%>
  <%Notice notice=list.get(i); %>
  <tr>
    <td><%=notice.getNotice_id() %></td>
    <td>
    	
    	<a href="/notice/content?notice_id=<%=notice.getNotice_id() %>"><%=notice.getTitle() %></a>
    </td>
    <td><%=notice.getWriter() %></td>
    <td><%=notice.getRegdate() %></td>
    <td><%=notice.getHit() %></td>
  </tr>
  <%} %>
  <tr>
  	<td colspan="5">
  		<button onClick="registForm()">글등록</button>
  	</td>
  </tr>
</table>

</body>
</html>
    
    
    
    
    
    