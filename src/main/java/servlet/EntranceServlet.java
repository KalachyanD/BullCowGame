package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EntranceServlet extends HttpServlet {

    String login = "";
    String password = "";
    String error= "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login = request.getParameter("login");
        password = request.getParameter("password");
        error = "";
        if(login.isEmpty()||password.isEmpty()){
            error = "Логин или пароль незаполнен!";
            request.getSession().setAttribute("errorEntrance",error);
            response.sendRedirect("index.jsp");
        }
        else {
            //проверка на совпадение логина и пароля.
            response.sendRedirect("game.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
