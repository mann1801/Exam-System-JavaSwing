package P;

import java.io.IOException;
import java.sql.*;


public class Result 
    {
        Result next;
        Result prev;
        int Enrollment;
        int marks;
        int course_id;
        Connection conn=Connector.con;
        Result(int Enrollment,int marks,int Course_Id) throws Exception
        {
            this.Enrollment=Enrollment;
            this.marks=marks;
            this.course_id=Course_Id;
            String q="Select * from marks_data where Enrollment_No=?";
            PreparedStatement pst11=conn.prepareStatement(q);
            pst11.setInt(1,Enrollment);
            ResultSet rs=pst11.executeQuery();
            if(rs.next())
            {
                String q1="Update marks_data set Marks=?,course_id=? where Enrollment_No=?";
                PreparedStatement pst111=conn.prepareStatement(q1);
                pst111.setInt(1,marks);
                pst111.setInt(2,course_id);
                pst111.setInt(3,Enrollment);
                pst111.executeUpdate();
            }
            else
            {
                insert(Enrollment,marks,course_id);
            }
        }
    
    
    public void insert(int enroll,int m,int course_id) 
    {
        try
            {
                String sql="insert into marks_data values(?,?,?)";//"{call insertMarks(?,?,?)}";
                PreparedStatement pst=conn.prepareStatement(sql);
                pst.setInt(1,enroll);
                pst.setInt(2,m);
                pst.setInt(3,course_id);
                pst.execute();
            }
        catch(SQLException e)
            {

            }   
    }
}