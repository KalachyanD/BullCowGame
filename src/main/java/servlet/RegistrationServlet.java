package servlet;

import dao.DAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error = "";
        User newUser = new User(request.getParameter("login"),request.getParameter("password"),0,0);

        if (newUser.getLogin().isEmpty() || newUser.getPassword().isEmpty()) {
            error("Логин или пароль незаполнен!",request, response);
        } else {
            try {
                User userCompare = DAO.getInstance().get(newUser.getLogin());
                if(userCompare != null) {
                    error("Логин уже существует!",request, response);
                }else {
                    try {
                        DAO.getInstance().create(newUser);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void error(String message, HttpServletRequest request, HttpServletResponse response){
        request.getSession().setAttribute("errorEntrance", message);
        try {
            response.sendRedirect("registration.jsp");
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
