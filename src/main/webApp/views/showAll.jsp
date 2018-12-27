<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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
							<a href="${pageContext.request.contextPath}/admin/logOut">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome <shiro:principal/>!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Age
							</td>
							<td>
								Bir
							</td>
							<td>
								Address
							</td>
							<shiro:hasAnyRoles name="root,admin">
							<td>
								Operation
							</td>
							</shiro:hasAnyRoles>
						</tr>
						<c:forEach items="${requestScope.user}" var="users">
						<tr class="row1">
							<td>
								${users.id}
							</td>
							<td>
								${users.name}
							</td>
							<td>
								${users.age}
							</td>
							<td>
								<fmt:formatDate value="${users.bir}" pattern="yyyy-MM-dd HH:mm:ss:ms"/>
							</td>
							<td>
								${users.address}
							</td>
							<shiro:hasAnyRoles name="root,admin">
							<td>
								<a href="${pageContext.request.contextPath}/user/delete?id=${users.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/user/findOne?id=${users.id}">update emp</a>
							</td>
							</shiro:hasAnyRoles>
						</tr>
						</c:forEach>
						<c:if test="${requestScope.page>1}">
							<td colspan="4">
								<input type="button" class="button" value="上一页" onclick="location='${pageContext.request.contextPath}/user/showAll?page=${requestScope.page - 1}'"/>&nbsp;&nbsp;
							</td>
						</c:if>
						<c:if test="${requestScope.page==1}">
						<td colspan="4">
							<input type="button" class="button" value="上一页"/>&nbsp;&nbsp;
						</td>
						</c:if>
							<c:if test="${requestScope.page < requestScope.pageNums}">
							<td colspan="4">
								<input type="button" class="button" value="下一页" onclick="location='${pageContext.request.contextPath}/user/showAll?page=${requestScope.page + 1}'"/>
							</td>
							</c:if>
							<c:if test="${requestScope.page == requestScope.pageNums}">
						<td colspan="4">
							<input type="button" class="button" value="下一页"/>
						</td>
							</c:if>
					</table>

					<p>
						<shiro:hasAnyRoles name="root,admin">
						<input type="button" class="button" value="Add Employee" onclick="location='${pageContext.request.contextPath}/views/addEmp.jsp'"/>
						</shiro:hasAnyRoles>
					</p>

					<p>
						<shiro:hasRole name="root">
						<input type="button" class="button" value="Select Logs" onclick="location='${pageContext.request.contextPath}/log/showAll'"/>
						</shiro:hasRole>
					</p>
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
