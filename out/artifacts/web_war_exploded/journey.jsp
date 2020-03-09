<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 02.03.2020
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Journey</title>
</head>
<body>
    <strong>List of visited pages</strong>
    <form method="post">
        <input type="submit" value="Clear">
    </form>
    <table>
        <TH>URL</th>
        <c:forEach items="${journey_list}" var="current">
            <tr>
                <td><c:out value="${current}" /><td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
