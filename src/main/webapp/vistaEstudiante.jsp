<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 02-07-2023
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Controller.loginEstudianteServlet" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    <c:out value="${estudiante.getNombre()}"></c:out>
</p>
</body>
</html>
