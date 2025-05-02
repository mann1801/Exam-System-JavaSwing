package P;

public class Main 
{
    public static void main(String args[]) throws Exception
    {   
        Connector.connect();

        IDandPasswords idandpasswords=new IDandPasswords();     
        LoginPage loginPage = new LoginPage(idandpasswords.getLoginInfo()); 
    }
}