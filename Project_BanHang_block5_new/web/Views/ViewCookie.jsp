<%-- 
    Document   : ViewCookie
    Created on : Dec 12, 2023, 4:04:51 PM
    Author     : LAPTOP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ViewCookie</h1>
        <c:forEach items="${pageContext.request.cookies}" var="o">
            ${o.name} - ${o.value} <br>
        </c:forEach>
    </body>
</html>
