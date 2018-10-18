package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    String login = "";
    String password = "";
    String error = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login = request.getParameter("login");
        password = request.getParameter("password");
        if (request.getParameter("login") == null || request.getParameter("password") == null) {
            login = "";
            password = "";
        }
        if (login.isEmpty() || password.isEmpty()) {
            error = "Логин или пароль незаполнен!";
            request.getSession().setAttribute("errorRegistration", error);
            response.sendRedirect("registration.jsp");
        } else {
            //проверка на уже существующий логин.
            //Запись в БД.
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
