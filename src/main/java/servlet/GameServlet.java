package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.*;

public class GameServlet extends HttpServlet {
    ArrayList<String> listHistory = new ArrayList<>();
    RandomNumber randomNumber = new RandomNumber();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String error = "";
        String history = "";

        Character digit1 = request.getParameter("digit1").charAt(0);
        Character digit2 = request.getParameter("digit2").charAt(0);
        Character digit3 = request.getParameter("digit3").charAt(0);
        Character digit4 = request.getParameter("digit4").charAt(0);
        String userNumber = digit1.toString() + digit2.toString() + digit3.toString() + digit4.toString();
        if (!checkDigitRepetition(userNumber)) {
            error = "Повторяются цифры!";
            request.getSession().setAttribute("error", error);
            response.sendRedirect("game.jsp");
        } else {
            error = "";
            request.getSession().setAttribute("error", error);
            history = userNumber.concat(bulls(userNumber, randomNumber.getNumber()).toString())
                    .concat(cows(userNumber, randomNumber.getNumber()).toString());
            listHistory.add(history);
            if (!listHistory.isEmpty() && listHistory.get(listHistory.size()-1).charAt(4) == '4') {
                try {
                    DAO.getInstance().update(((User) request.getSession().getAttribute("user")).getLogin(), 1, listHistory.size());
                }catch (SQLException e){
                    e.printStackTrace();
                }
                randomNumber = new RandomNumber();
                listHistory.clear();
            }
            request.getSession().setAttribute("listHistory", listHistory);
            response.sendRedirect("game.jsp");
            history = "";
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private Integer bulls(String userNumber, String randomNumb) {
        Integer count = 0;
        for (int i = 0; i < userNumber.length(); ++i) {
            if (userNumber.charAt(i) == randomNumb.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private Integer cows(String userNumber, String randomNumber) {
        Integer count = 0;
        for (int i = 0; i < userNumber.length(); ++i) {
            for (int j = 0; j < userNumber.length(); ++j) {
                if (userNumber.charAt(i) == randomNumber.charAt(j) && i != j) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean checkDigitRepetition(String number) {
        for (int i = 0; i < number.length(); ++i) {
            for (int j = 0; j < number.length(); ++j) {
                if (i != j && number.charAt(i) == number.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}

































