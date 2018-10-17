package Code;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectDB {
    
    final static String USERNAME = "root";
    final static String PASSWORD = "mysqlroot123";
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost:3306/nsbmDB?useSSL=false";
    
    public static Connection connect() {
    
        Connection conn = null;
        
        try {
        
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        
        }
        catch (Exception e) {
        
            JOptionPane.showConfirmDialog(null, "oh", "ERROR", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        
        }
        
        return conn;
    
    }

}
