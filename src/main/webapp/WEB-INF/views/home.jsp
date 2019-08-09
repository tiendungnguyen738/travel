<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Son Dep Trai
  Date: 7/20/2019
  Time: 7:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
        <c:forEach items="${model}" var="item">
            <h1>${item.id}</h1>
            <h1>${item.roleName}</h1>
            <h1>${item.description}</h1>
        </c:forEach>

</h1>
</body>
</html>
