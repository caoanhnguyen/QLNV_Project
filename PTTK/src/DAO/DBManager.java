package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
//    private final static String url = "jdbc:mysql://localhost:3306/QLNV";
//    private final static String username = "root";
//    private final static String passwd = "12345A@a";
    
    private final static String url = "jdbc:mysql://database-2.c5qwm4gwgfgc.ap-southeast-1.rds.amazonaws.com:3306/QLNV";
    private final static String username = "admin";
    private final static String passwd = "ptpmud123";

    public static Connection getConnection() {
        Connection connection = null;

        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url,username,passwd);
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
        return connection;
    }

}
