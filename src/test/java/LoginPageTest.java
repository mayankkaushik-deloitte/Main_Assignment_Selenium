import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass{
    LoginPage loginPage;
    BankManager bankManagerhome;
    NamePage namePage;
    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        init();
        loginPage = new LoginPage();
        bankManagerhome=new BankManager();
        namePage= new NamePage();
    }
    @Test(priority = 2)
    public void loginpagetitletest(){
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"XYZ Bank");
    }
    @Test(priority = 1)
    public void managerLoginTest() throws InterruptedException {
        bankManagerhome=loginPage.clickOnManagerLogin();
    }
    @Test
    public void customerLoginTest() throws InterruptedException {
        namePage = loginPage.clickoncustomerlogin();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
