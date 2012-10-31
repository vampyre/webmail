<%--
    Document   : auth
    Created on : 29.10.2012, 9:46:54
    Author     : Stanislav Oginsky
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><spring:message code="label.title" /></title>
    </head>
    <body>
        <form:form method="post" action="login" commandName="user" modelAttribute="user">
            <form:label path="username">
                <spring:message code="label.username" />
            </form:label>
            <form:input path="username" />
            <form:label path="password">
                <spring:message code="label.password" />
            </form:label>
            <form:input type="password" path="password" />
            <input type="submit" value="<spring:message code="label.submit" />"/>
        </form:form>
    </body>
</html>