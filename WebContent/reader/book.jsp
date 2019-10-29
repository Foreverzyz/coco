<%@ page import="Dao.ReaderSelfDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ins.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<%
    ArrayList<Book> booklist = (ArrayList<Book>)session.getAttribute("booklist");
%>
<html>
<head>
    <title>图书管理</title>
</head>
<body>
<!--头部-->
	<div class="header">
		<div class="inner_c">
			<h1>Library</h1>
			<div class="nav">
				<ul>
					<li><a href="${pageContext.request.contextPath }/ReaderSelfAction?action=getall">查看书籍信息</a></li>
					<li><a href="ReaderSelfAction?action=lp">查看个人信息</a></li>
					<li><a href="ReaderSelfAction?action=ll">修改个人信息</a></li>
					<li><a href="#">网页栏目</a></li>
					<li><a href="#">网页栏目</a></li>
					<li class="last"><a href="${pageContext.request.contextPath }/ReaderSelfAction?action=exit">退出</a></li>
				</ul>
			</div>
			
		</div>
	</div>


	<div class="cl"></div>
	

<table class="table">
    <thead>
    <tr>
        <th>书本编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>价格</th>
        <th>类目</th>
        <th>库存总量</th>
        <th>借出数量</th>
        <th>剩余数量</th>
        <th>所在位置(柜号)</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
        if(booklist!=null && booklist.size() > 0)
        {
            for(int i = 0; i < booklist.size(); i++)
            {
                Book b = booklist.get(i);
    %>
    <tr>
        <td><%=b.getId()%></td>
        <td><a href="BookAction?action=querybookbyid&id=<%=b.getId()%>&next=check"><%=b.getName()%></a> </td>
        <td><%=b.getAuthor()%></td>
        <td><%=b.getPublisher()%></td>
        <td><%=b.getPrice()%></td>
        <td><%=b.getCategory()%></td>
        <td><%=b.getStore()%></td>
        <td><%=b.getLend()%></td>
        <td><%=b.getRemain()%></td>
        <td><%=b.getLocation()%></td>
        <td><a href="BookAction?action=querybookbyid&id=<%=b.getId()%>&next=edit"></a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>

</body>
</html>
