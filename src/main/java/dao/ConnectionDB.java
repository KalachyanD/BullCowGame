package dao;

import java.sql.*;

public class ConnectionDB {

    private static ConnectionDB instance;

    private ConnectionDB() {}

    public static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection getDBConnection() throws SQLException {
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/game?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root", "");
        return dbConnection;

    }
}
