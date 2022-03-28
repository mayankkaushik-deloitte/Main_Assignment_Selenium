import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerLoginTest {
    Loginpage objloginpage;
    Bankmanagerhome objbankmanagerhome;
    Namepage objnamepage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
        objloginpage=new Loginpage();
        objbankmanagerhome=new Bankmanagerhome();
        objnamepage= new Namepage();
    }
    @Test(priority = 2)
    public void loginpagetitletest(){
        String title=objloginpage.validateloginpagetitle();
        Assert.assertEquals(title,"XYZ Bank");
    }
    @Test(priority = 1)
    public void managerlogintest() throws InterruptedException {
        objbankmanagerhome=objloginpage.clickonmanagerlogin();
    }
    @Test
    public void customerlogintest() throws InterruptedException {
        objnamepage= objloginpage.clickoncustomerlogin();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
