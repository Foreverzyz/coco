<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="Entity.Book" %>
    <%@ page import="Dao.ReaderSelfDao" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" href="css/ins.css">
	<title>Document</title>
</head>
<body>
	<!--头部-->
	<div class="header">
		<div class="inner_c">
			<h1>Library</h1>
			<div class="nav">
				<ul>
					<li><a href="BookAction?action=getall">查看书籍信息</a></li>
					<li><a href="">查看个人信息</a></li>
					<li><a href="#">修改个人信息</a></li>
					<li><a href="#">网页栏目</a></li>
					<li><a href="#">网页栏目</a></li>
					<li class="last"><a href="#">退出</a></li>
				</ul>
			</div>
			
		</div>
	</div>


	<div class="cl"></div>
	<!--banner图-->
	<div class="banner">

		<div class="circles">
			<ol>
				<li class="current"></li>
				<li></li>
				<li></li>
				<li></li>
				<li class="last"></li>
			</ol>
		</div>
	</div>

	<table border="1">
	<tr><td>书本编号</td><td>书本名称</td><td>作者</td><td>出版社</td><td>价格</td><td>类别</td><td>库存</td><td>描述</td><td>书架</td><td></td></tr>
	<%
	Vector<Book> v=new Vector<Book>();
	v=(Vector<Book>)session.getAttribute("allbook");
	Iterator<Book> it=v.iterator();
	Book b=new Book();
	while(it.hasNext()){
		b=it.next();
	
	%>
	<tr><td><%=b.getId() %></td><td><%=b.getName() %></td>
	<td><%=b.getAuthor() %></td><td><%=b.getPublisher() %></td>
	<td><%=b.getPrice() %></td><td><%=b.getCategory() %></td>
	<td><%=b.getStore() %></td><td><%=b.getDesc() %></td>
	<td><%=b.getLocation() %></td>
	</tr>
	<%
	}
	%>
	</table>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>