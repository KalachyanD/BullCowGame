package servlet;

import dao.DAO;
import model.Statistic;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatisticServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //взять из базы статистику и отправить ее на statistic.jsp
        ArrayList<User> statisticList = new ArrayList<>();
        try{
            statisticList = DAO.getInstance().getAll();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        request.getSession().setAttribute("statisticList",createStatistic(statisticList));
        response.sendRedirect("statistic.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private ArrayList<Statistic> createStatistic(ArrayList<User> userArrayList){
        Statistic statistic;
        ArrayList<Statistic> statisticArrayList = new ArrayList<>();
        for(int i = 0;i<userArrayList.size();++i){
            statistic = new Statistic(userArrayList.get(i).getLogin(),userArrayList.get(i).getGames(),
                    userArrayList.get(i).getAttempts());
            statisticArrayList.add(statistic);
        }
        return statisticArrayList;
    }
}
