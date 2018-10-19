package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class DAO {

    private static DAO instance;

    private DAO() {
    }

    public static DAO getInstance() {
        if (instance == null) {
            instance = new DAO();
        }
        return instance;
    }

    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> clients = new ArrayList<User>();
        final String selectQuery = "SELECT login,password,games,attempts FROM USERS";
        Connection dbConnection = ConnectionDB.getInstance().getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(selectQuery);
        ResultSet rsClients = preparedStatement.executeQuery();
        User currentClient = null;
        while (rsClients.next()) {
            String login = rsClients.getString("login");
            String password = rsClients.getString("password");
            Integer games = rsClients.getInt("games");
            Integer attempts = rsClients.getInt("attempts");
            currentClient = new User(login, password, games, attempts);
            clients.add(currentClient);
        }
        return clients;
    }

    public User get(String loginUser) throws SQLException {
        final String selectQuery = "SELECT login,password,games,attempts FROM USERS WHERE login = ?";
        Connection dbConnection = ConnectionDB.getInstance().getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(selectQuery);
        preparedStatement.setString(1, loginUser);
        ResultSet rsClients = preparedStatement.executeQuery();
        User user = null;
        while (rsClients.next()) {
            String login = rsClients.getString("login");
            String password = rsClients.getString("password");
            Integer games = rsClients.getInt("games");
            Integer attempts = rsClients.getInt("attempts");
            user = new User(login, password, games, attempts);
        }
        return user;
}

    public void create(User user)
            throws SQLException {
        final String insertQuery = "INSERT INTO USERS (LOGIN, PASSWORD, GAMES, ATTEMPTS) VALUES (?,?,?,?)";
        Connection dbConnection = ConnectionDB.getInstance().getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setInt(3, user.getGames());
        preparedStatement.setInt(4, user.getAttempts());
        preparedStatement.executeUpdate();
    }

    public void update(String login, Integer games, Integer attempts)
            throws SQLException {
        final String updateQuery = "UPDATE USERS SET GAMES = GAMES + ?, ATTEMPTS = ATTEMPTS + ? WHERE LOGIN = ?";
        Connection dbConnection = ConnectionDB.getInstance().getDBConnection();
        PreparedStatement preparedStatement = dbConnection.prepareStatement(updateQuery);
        preparedStatement.setInt(1, games);
        preparedStatement.setInt(2, attempts);
        preparedStatement.setString(3, login);
        preparedStatement.executeUpdate();
    }
}
