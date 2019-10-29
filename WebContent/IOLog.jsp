<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Borrow" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<html>
<head>
    <title>图书借进归还日志</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
    if(session.getAttribute("adminname") == null){
        response.sendRedirect("/tes/index.jsp");
    }
%>
<jsp:include page="nav.html"/>
<table class="table">
    <thead>
    <tr>
        <th>书本编号(书名)</th>
        <th>读者学号</th>
        <th>借出/归还</th>
        <th>更新时间</th>
        <th>借阅时间(天)</th>
        <th>是否归还</th>
    </tr>
    </thead>
    <tbody>
    <%
    	ArrayList<Borrow> loglist = (ArrayList<Borrow>)session.getAttribute("loglist");
            if(loglist!=null && loglist.size() > 0)
            {
                for(int i = loglist.size() - 1; i >= 0 ; i--)
                {
                    Borrow log = loglist.get(i);
    %>
    <tr>
        <td><%=log.getBookid()%></td>
        <td><%=log.getReaderid()%></td>
        <td><%=log.getService()%></td>
        <td><%=log.getBorrowtime()%></td>
        <td><%=log.getBorrowday()%></td>
        <td><%=log.getComplete()%></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
