package db_util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/sys";
    private static String user = "root";
    private static String password = "root";

    public static Connection createConnection() {
        Connection conn = null;

        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, user, password);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}