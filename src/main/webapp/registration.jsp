<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = "";
    if(request.getSession().getAttribute("errorRegistration") != null){
        error = (String)request.getSession().getAttribute("errorRegistration");
    }
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация</title>
</head>
<body>
<label align="center"><h1>Игра быки и коровы</h1></label>
<label align="center"><h1>Регистрация</h1></label>
<%out.println("<table align=\"center\"> <tr> <td>"+error+"<td> <tr> </table>");%>
<form align="center" action="RegistrationServlet" method="post">
    <p><strong>Логин:</strong>
        <input maxlength="6" size="20" name = "login"></p>
    <p><strong>Пароль:</strong>
        <input type="password" maxlength="6" size="20" name = "password"></p>
    <button type="submit">
        Регистрация
    </button>
</form>
</body>
</html>
