import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseClass{
    LoginPage loginPage;
    BankManager bankManagerhome;
    NamePage namePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        intialisation();
        loginPage = new LoginPage();
        bankManagerhome=new BankManager();
        namePage= new NamePage();
    }
    @Test(priority = 2)
    public void loginpagetitletest(){
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"XYZ Bank");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @Test(priority = 1)
    public void managerLoginTest() throws InterruptedException {
        bankManagerhome=loginPage.clickOnManagerLogin();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test
    public void customerLoginTest() throws InterruptedException {
        namePage = loginPage.clickoncustomerlogin();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void DataTear(){

        driver.quit();
    }
}