package connection;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectionData {

    String DRIVER = "com.mysql.jc.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/emers_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow";
    String USER = "root";
    String PASSWORD = " ";
    //had problems and the db was asking for timezone
    String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() {
        Connection con;
        try {
            
            Class.forName(DRIVER); //load driver
           
            JOptionPane.showMessageDialog(null, "Driver Loaded");
            
            con = DriverManager.getConnection(URL + timeZone, USER, PASSWORD); //connection to DB
            
            
            JOptionPane.showMessageDialog(null, "Connected");
            
            return con;
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Connection error:", ex);
        }

    }

    public static void closeConnection(Connection con, PreparedStatement ps) {

        closeConnection(con, ps);

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {

        closeConnection(con, ps);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

//    Connection con;
//    }
//    public Connection getAddConnection(){
//        return con;
//    }
