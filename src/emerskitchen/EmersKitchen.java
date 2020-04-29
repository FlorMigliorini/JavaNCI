
package emerskitchen;

import emerskitchen.Connection.ConnectionData;
import java.sql.SQLException;

public class EmersKitchen {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConnectionData connection = new ConnectionData();
        connection.getConnection();
        
    }
    
}
