package P;



import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;
public class LoginPage implements ActionListener
{
    JFrame frame=new JFrame();
    JButton loginButton=new JButton("Login");
    JTextField userIDField=new JTextField();
    JPasswordField userPasswordField=new JPasswordField();
    JLabel userIDLabel=new JLabel("UserID:");
    JLabel userPasswordLabel=new JLabel("Password:");
    JLabel messageLabel=new JLabel();

    HashMap<Integer,Integer> loginInfo=new HashMap<Integer,Integer>();


    LoginPage(HashMap<Integer,Integer> LoginInfoOriginal)
    {
        loginInfo=LoginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);


        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.addActionListener(this);

        messageLabel.setBounds(125,250,450,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25)); 

        frame.add(userPasswordField);
        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(userIDField);
        frame.add(loginButton);
        frame.add(messageLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()==loginButton)
        {      
                String userID=userIDField.getText();
                int userId=0;    
                String Password=String.valueOf(userPasswordField.getPassword());
                int password=0;
                try
                {
                    userId=Integer.parseInt(userID);
                    password=Integer.parseInt(Password);
                }
                catch(NumberFormatException n)
                {
                    
                }
                
            
            
            if(loginInfo.containsKey(userId))
            {
                if(loginInfo.get(userId)==password)
                {
                    frame.dispose();
                    try
                    {
                    Connection conn=Connector.con;
                    String q="Select Course_Id from student where Enrollment=?";
                    PreparedStatement pst=conn.prepareStatement(q);
                    pst.setInt(1,userId);
                    ResultSet rs=pst.executeQuery();
                    rs.next();
                    WelcomePage welcomepage=new WelcomePage(rs.getInt("Course_Id"),userId);

                    }
                    catch(Exception a)
                    {
                        a.printStackTrace();
                    }
                }
                else
                {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }
            }
            else
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("User Name not Found");
            }
        }
    }
}