<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/ins.css">
<head>
	<title>Document</title>
</head>
<body>
	<!--头部-->
	<div class="header">
		<div class="inner_c">
			<h1>Library</h1>
			<div class="nav">
				<ul>
					<li><a href="${pageContext.request.contextPath }/ReaderSelfAction?action=getall">查看书籍信息</a></li>
					<li><a href="ReaderSelfAction?action=ll">查看个人信息</a></li>
					<li><a href="ReaderSelfAction?action=ll">修改个人信息</a></li>
					<li><a href="#">网页栏目</a></li>
					<li><a href="#">网页栏目</a></li>
					<li class="last"><a href="ReaderSelfAction?action=exit">退出</a></li>
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

	
</body>
</html>