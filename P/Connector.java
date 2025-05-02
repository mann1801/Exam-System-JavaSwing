package P;
import java.sql.DriverManager;
import java.sql.*;
public class Connector 
{
   public static Connection con;
   public static void connect() throws Exception
   {

        // Step 2 : Establish the connection between java and MySQL
        String dburl = "jdbc:mysql://localhost:3306/lju"; // database url
        String dbUser = "root"; // user name
        String dbpass = ""; // password
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(dburl, dbUser, dbpass); // connection Obj
        // check the connection
        if (con != null) 
        {
            System.out.println("Connection successful");
        }
    }
}