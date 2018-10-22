package servlet;

import dao.DAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EntranceServlet extends HttpServlet {
    User user;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        try {
            user = new User(request.getParameter("login"), request.getParameter("password"), 0, 0);
            error = "";
            if (user.getLogin().isEmpty() || user.getPassword().isEmpty()) {
                error("Логин или пароль незаполнен!", request, response);
                return;
            }

            User userCompare = DAO.getInstance().get(user.getLogin());

            if (userCompare == null) {
                error("Логин не существует!", request, response);
                return;
            }
            if (userCompare != null && !user.getPassword().equals(userCompare.getPassword())) {
                error("Пароль введен неверно!", request, response);
                return;
            }

            request.getSession().setAttribute("user", user);
            response.sendRedirect("game.jsp");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void error(String message, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("errorEntrance", message);
        try {
            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}