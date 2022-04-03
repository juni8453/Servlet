<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Member List Server Side Rendering Test</p>
    <table>
        <thead>
            <th>ID</th>
            <th>Username</th>
            <th>Age</th>
        </thead>
        <tbody>
        <c:forEach var="member" items="${members}">
            <tr>
                <td>${member.id}</td>
                <td>${member.username}</td>
                <td>${member.age}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
