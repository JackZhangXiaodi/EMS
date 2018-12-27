<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								管理员
							</td>
							<td>
								操作时间
							</td>
							<td>
								操作内容
							</td>
							<td>
								操作结果
							</td>
							<td>
								Operation
							</td>
						</tr>
						<c:forEach items="${requestScope.log}" var="logs">
						<tr class="row1">
							<td>
								${logs.id}
							</td>
							<td>
								${logs.uname}
							</td>
							<td>
								<fmt:formatDate value="${logs.time}" pattern="yyyy-MM-dd HH:mm:ss:ms"/>
							</td>
							<td>
								${logs.article}
							</td>
							<td>
								${logs.result}
							</td>
							<td>
								<a href="#">delete</a>&nbsp;<a href="#">update</a>
							</td>
						</tr>
						</c:forEach>
						<c:if test="${requestScope.page>1}">
						<td colspan="4">
							<input type="button" value="上一页" onclick="location.href='${pageContext.request.contextPath}/log/showAll?page=${requestScope.page-1}'">
						</td>
						</c:if>
						<c:if test="${requestScope.page==1}">
							<td colspan="4">
								<input type="button" value="上一页">
							</td>
						</c:if>
						<c:if test="${requestScope.page < requestScope.counts}">
						<td colspan="3">
							<input type="button" value="下一页" onclick="location.href='${pageContext.request.contextPath}/log/showAll?page=${requestScope.page+1}'">
						</td>
						</c:if>
						<c:if test="${requestScope.page == requestScope.counts}">
							<td colspan="3">
								<input type="button" value="下一页">
							</td>
						</c:if>
						<td>
						<input type="button" value="返回用户列表" onclick="location.href='${pageContext.request.contextPath}/user/showAll'">
						</td>
					</table>
				</div>

			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
