package P;

import java.sql.*;
import java.util.*;

public class IDandPasswords 
{
    HashMap<Integer,Integer> loginInfo =new HashMap<Integer,Integer>();
    Connection conn=Connector.con;


    IDandPasswords() throws Exception
    {
        String q="Select Enrollment,password from student";
        PreparedStatement pst=conn.prepareStatement(q);
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
            loginInfo.put(rs.getInt("Enrollment"),rs.getInt("Password"));
        }
    }

    protected HashMap getLoginInfo()
    {
        return loginInfo;
    }
}