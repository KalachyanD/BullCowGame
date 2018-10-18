<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = "";
    if(request.getSession().getAttribute("errorEntrance") != null){
        error = (String)request.getSession().getAttribute("errorEntrance");
    }
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Вход</title>
</head>
<body>
<label align="center"><h1>Игра быки и коровы</h1></label>
<label align="center"><h1>Вход</h1></label>
<%out.println("<table align=\"center\"> <tr> <td>"+error+"<td> <tr> </table>");%>
<form align="center" action="EntranceServlet" method="post">
    <p><strong>Логин:</strong>
        <input maxlength="6" size="20" name = "login"></p>
    <p><strong>Пароль:</strong>
        <input type="password" maxlength="6" size="20" name = "password"></p>
    <button type="submit">
        Вход
    </button>
</form>
<table align="center">
    <tr>
        <td>
            <form align="center" action="registration.jsp" method="post">
                <button type="submit">
                    Регистрация
                </button>
            </form>
        </td>
        <td>
            <form align="center" action="statistic.jsp" method="post">
                <button type="submit">
                    Статистика
                </button>
            </form>
        </td>
    </tr>
</table>
</body>
</html>
