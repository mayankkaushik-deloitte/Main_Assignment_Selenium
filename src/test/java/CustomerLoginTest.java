import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerLoginTest {
    @BeforeMethod
    public void setUp() throws InterruptedException {
        BaseClass.SetUp();
    }
    @Test (priority = 2)
    public void customerLogin() throws InterruptedException {
        CustomerLogin.customerLogin();
        String currURL = BaseClass.driver.getCurrentUrl();
        Assert.assertEquals(currURL, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");
    }
    @AfterMethod
    public void DataTear(){
        BaseClass.driver.quit();
    }
}
