package Model;
import java.sql.*;

public class DBConnectivity {
    public static Connection con=null;
    public void getConnectivity() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/shops","root","Akshaya@013");
    }
    
}
