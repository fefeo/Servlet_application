<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h1>Zaloguj się do aplikacji</h1>
    <form action = "LoginServlet">
        Enter username: <input type = 'text' name = "u_name"><br>
        Enter password: <input type = 'password' name = "pass"><br>
        <br>
        <input type = submit value = "zaloguj">
    </form>
</body>
</html>
