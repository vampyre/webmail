<%--
    Document   : auth
    Created on : 29.10.2012, 9:46:54
    Author     : Stanislav Oginsky
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><spring:message code="label.title" /></title>
<link href="<c:url value="/resources/themes/main.css" />"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="header">
		<img src="<c:url value="/resources/images/header.png" />" />
	</div>
	<div id="authFormPosition" align="center">
	    <div id="authFormResult">
	    <%--
	    TODO: replace jetty with glasfish to fix that	
	    <c:if test="${user.isAuthorized()}">
	    --%>
	    	<c:if test="${not empty user.username}">
	    		<spring:message code="label.auth_retry" />
	    	</c:if>	   
	    </div>
		<form:form method="post" action="login" commandName="user"
			modelAttribute="user">
			<div id="authFormResult">
				<table id="authForm">
				<tr>
					<td><spring:message code="label.username" /></td>
					<td><form:input path="username" /></td>
				<tr>
					<td><spring:message code="label.password" /></td>
					<td><form:input type="password" path="password" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td align="right">
						<input type="submit" value="<spring:message code="label.submit" />" />
					</td>
				</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>