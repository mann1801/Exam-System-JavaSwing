package P;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;

public class WelcomePage implements ActionListener
{
    JFrame frame=new JFrame();
    JLabel welcomeLabel;
    JButton submitbutton=new JButton("Submit");
    int x=100;
    int y=160;
    int Course_id;
    String path;
    // JTextField jTextField;
    int count=0;
    ArrayList<JTextField> textfields=new ArrayList<>();
    String answers[]=new String[10];
    int i=0;
    String result;
    int user_id;
    int course_id;
    
    WelcomePage(int courseid,int user_id) throws Exception
    {
        this.user_id=user_id;
        this.course_id=courseid;
        try{
            
            frame.setSize(1600,900);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Astronomy");
            submitbutton.setBounds(x,100,200,30);
            submitbutton.addActionListener(this);
    
            Course_id=courseid;
            frame.add(submitbutton);
            if(Course_id==1)
            {
            path="/Users/mannsoni/Downloads/Astronomy.txt";
            frame.setTitle("Astronomy");
            }
            else if(Course_id==2)
            {
                path="/Users/mannsoni/Downloads/Architect.txt";
                frame.setTitle("Architect");
            }
            else if(Course_id==3)
            {
                path="/Users/mannsoni/Downloads/Psychology.txt";
                frame.setTitle("Psychology");
            }
            else if(Course_id==4)
            {
                path="/Users/mannsoni/Downloads/Law.txt";
                frame.setTitle("Law");
            }

            else
            {
                path="/Users/mannsoni/Downloads/CSE.txt";
                frame.setTitle("CSE");
            }


            BufferedReader br=new BufferedReader(new FileReader(path));
        
        String data=br.readLine();
        String ans=br.readLine();
        while(data!=null)
        {
            result=ans.replaceAll("\\s+","");
            answers[i]=result;

            JTextField jTextField=new JTextField();
            jTextField.setBounds(1250,y,250,30);
            frame.add(jTextField);
            textfields.add(jTextField);
            welcomeLabel=new JLabel(data);
            welcomeLabel.setFont(new Font("ITALIC",Font.PLAIN,20));
            welcomeLabel.setBounds(x,y,1200,35);
            frame.add(welcomeLabel);

            data=br.readLine();
            ans=br.readLine();
            y=y+60;
            i=i+1;
        }
        
       
    }
    catch(Exception p)
    {
        System.out.println();
    }
    }
  
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==submitbutton)
        {
            int i=0;
            for (JTextField textField : textfields) 
            {
                String input = textField.getText();
                String result=input.replaceAll("\\s+","");
                
                if(answers[i].equalsIgnoreCase(result))
                {
                    count++;
                }
                i++;
            }
        }
        frame.dispose();
        try {
            Result r=new Result(user_id,count,Course_id);
        } catch (Exception e1) 
        {
            e1.printStackTrace();
        }

    }
}