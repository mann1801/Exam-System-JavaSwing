package Q;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String dburl = "jdbc:mysql://localhost:3306/lju"; 
        String dbUser = "root"; // user name
        String dbpass = ""; // password
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(dburl, dbUser, dbpass); 
        if (con != null) 
        {
            System.out.println("Connection successful");
        }
        else
        {
            System.out.println("Connection failed");
        }
        Scanner sc=new Scanner(System.in);
        int pass=sc.nextInt();
        String q1="Select T_Password from teacher_details where T_Password=?";
        PreparedStatement pst1=con.prepareStatement(q1);
        pst1.setInt(1,pass);
        ResultSet rs1=pst1.executeQuery();
        if(rs1.next())
        {
            String q="Select Marks,Enrollment_No from marks_data,teacher_details where marks_data.course_id=teacher_details.C_ID and teacher_details.T_Password=?";
            PreparedStatement pst=con.prepareStatement(q);
            pst.setInt(1,pass);
            ResultSet rs=pst.executeQuery();
            LinkedList l1=new LinkedList();

        while(rs.next())
            {
                l1.insertInorder(rs.getInt("Marks"), rs.getInt("Enrollment_No"));
            }
            l1.display();
            try
            {
                System.out.println("Press 1 to find marks using enrollment no");
            }
            catch(InputMismatchException i1)
            {
            }
            int h=sc.nextInt();
            if(h==1)
            {
                try
                {
                    System.out.println("Enter the enrollment to search marks");
                    int h1=sc.nextInt();
                    l1.find(h1);
                }
                catch(InputMismatchException i)
                {
                    System.out.println("Enter numeric value");
                    System.exit(0);
                }
            }
        }
        else
        {
            System.out.println("Incorrect Password");
        }
    }
}