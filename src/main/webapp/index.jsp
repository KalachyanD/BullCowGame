<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! char digit1; %>
<%! char digit2; %>
<%! char digit3; %>
<%! char digit4; %>
<%
    ArrayList<String> listHistory = new ArrayList<>();
    if (request.getSession().getAttribute("listHistory") != null) {
        listHistory = (ArrayList<String>) request.getSession().getAttribute("listHistory");
    }
%>
<html lang=ru>
<body>
<label align="center"><h1>Игра быки и коровы</h1></label>
<table align="center">
    <tr>
        <td>
            Введите цифры
        </td>
    </tr>
</table>
<table align="center">
    <tr>
        <td>
            <%
                if (request.getSession().getAttribute("error") != null && !((String) (request.getSession()
                        .getAttribute("error"))).isEmpty()) {
                    out.println(request.getSession().getAttribute("error"));
                }
                else
                if (listHistory != null && listHistory.size() >= 1 &&
                        listHistory.get(listHistory.size() - 1).charAt(4) == '4') {
                    out.println("Вы выиграли!");
                }

            %>
        </td>
    </tr>
</table>
<form action="GameServlet" method="post">
    <table align="center">
        <tr>
            <td>
                <select name="digit1" select="<%=digit1%>">
                    <%
                        for (int i = 0; i < 10; ++i) {
                            out.println("<option>" + i + "</option>");
                        }
                    %>
                </select>
            </td>
            <td>
                <select name="digit2" select="<%=digit2%>">
                    <%
                        for (int i = 0; i < 10; ++i) {
                            out.println("<option>" + i + "</option>");
                        }
                    %>
                </select>
            </td>
            <td>
                <select name="digit3" select="<%=digit3%>">
                    <%
                        for (int i = 0; i < 10; ++i) {
                            out.println("<option>" + i + "</option>");
                        }
                    %>
                </select>
            </td>
            <td>
                <select name="digit4" select="<%=digit4%>">
                    <%
                        for (int i = 0; i < 10; ++i) {
                            out.println("<option>" + i + "</option>");
                        }
                    %>
                </select>
            </td>
        </tr>
    </table>
    <table align="center">
        <td>
            <button type="submit">
                Играть
            </button>
        </td>
    </table>
</form>
<table align="center">
    <tr>
        <td>
            Ход
        </td>
        <td>
            Число
        </td>
        <td>
            Бык
        </td>
        <td>
            Корова
        </td>
    </tr>
    <%
        if (listHistory != null) {
            for (int i = 0; i < listHistory.size(); ++i) {
                out.println("<tr>");
                out.println("<td>" + (i+1) + "</td>");
                out.println("<td>" + listHistory.get(i).charAt(0) + listHistory.get(i).charAt(1)
                        + listHistory.get(i).charAt(2) + listHistory.get(i).charAt(3) + "</td>");
                out.println("<td>" + listHistory.get(i).charAt(4) + "</td>");
                out.println("<td>" + listHistory.get(i).charAt(5) + "</td>");
                out.println("</tr>");
            }
        }
    %>
</table>
</body>
</html>