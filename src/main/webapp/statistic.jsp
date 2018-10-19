<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Statistic" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    ArrayList<Statistic> statisticList = new ArrayList<>();
    if (request.getSession().getAttribute("statisticList") != null) {
        statisticList = (ArrayList<Statistic>) request.getSession().getAttribute("statisticList");
    }else{
        response.sendRedirect("StatisticServlet");
    }
%>
<html>
<head>
    <title>Статистика</title>
</head>
<body>
<label align="center"><h1>Игра быки и коровы</h1></label>
<label align="center"><h1>Статистика</h1></label>
<table align="center">
    <tr>
        <td>
            Игрок
        </td>
        <td>
            Игр
        </td>
        <td>
            Ходов в среднем за игру
        </td>
        <td>
            <form action="ExitServlet" method="post">
                <button type="submit">
                    Выход
                </button>
            </form>
        </td>
    </tr>
    <%
        for(int i = 0; i < statisticList.size(); ++i) {
            out.println("<tr>");
            out.println("<td>");
            out.println(statisticList.get(i).getLogin());
            out.println("</td>");
            out.println("<td>");
            out.println(statisticList.get(i).getGames());
            out.println("</td>");
            out.println("<td>");
            out.println(statisticList.get(i).getAttemptsInGame());
            out.println("</td>");
        }
    %>
</table>
</body>
</html>
