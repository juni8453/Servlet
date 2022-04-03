<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>회원가입 성공</p>
    <ul>
        <!-- JSP 에서 제공하는 $ {} 문법으로 request.setAttribute() 로 저장한 데이터를 쉽게 가져와서 사용할 수 있다.-->
        <li>ID=${member.id}</li>
        <li>ID=${member.username}</li>
        <li>ID=${member.age}</li>
    </ul>
    <a href="/index.html">메인으로 이동</a>
</body>
</html>
