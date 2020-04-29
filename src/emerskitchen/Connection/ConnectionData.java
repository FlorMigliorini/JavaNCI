package emerskitchen.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionData {

    private Connection con;

    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3308/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow", "root", "");
            System.out.println("Conected successfully");

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Connection error:", ex);
        }
    }

//    public ConnectionData() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        con = DriverManager.getConnection("jdbc:mysql://localhost/emers_db", "root", "");
//        System.out.println("Conected successifully");
//
//    }

    public static void main(String[] args) {
        try {
            new ConnectionData();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
