<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- form action 경로를 상대경로를 사용한 이유
상대경로를 사용하면 현재 URL 의 계층 + 지정한 action 경로가 뒤에 붙게 되는데, (ex - jsp/members 경로에서 + /save)
강의를 진행하면서 해당 save 폼을 계속 재사용하기 위해서 절대경로가 아닌 상대경로로 지정해준 것이다.

설명을 덧붙이자면,
만약 /save 라고 절대경로 지정을 해줬으면, localhost:8080/save 이런 식으로 바로 경로가 지정되는데 우리는 다른 경로에서도
써야하니까 절대경로로 지정하면 안된다.
-->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age : <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
