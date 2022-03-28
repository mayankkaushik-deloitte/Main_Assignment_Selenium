import com.graphbuilder.math.OpNode;
import org.apache.commons.math3.analysis.function.Add;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Currency;
import java.util.concurrent.TimeUnit;

public class AddCustomerTest extends BaseClass{
    AddCustomer addCustomerDetails;
    LoginPage loginPage;
    BankManager bankManagerhome;
    OpenAccount openAccount;
    CustomerLogin customerPage;
    public AddCustomerTest(){
        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        init();
        addCustomerDetails = new AddCustomer();
        loginPage = new LoginPage();
        openAccount = new OpenAccount();
        bankManagerhome = new BankManager();
        customerPage = new CustomerLogin();
        bankManagerhome = loginPage.clickOnManagerLogin();
        addCustomerDetails = bankManagerhome.clickAddCustomer();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void addCustomerTest() throws InterruptedException {
        addCustomerDetails.addCustomerFun();
        Assert.assertEquals(addCustomerDetails.val,"Customer added successfully with customer id :6");

    }

    @Test(priority =2)
    public void homeBtnTest() throws InterruptedException {
        loginPage = addCustomerDetails.clickHomeBtn();

    }
    @Test(priority = 3)
    public void accountBtnTest() throws InterruptedException {
        openAccount = addCustomerDetails.accountBtn();
    }
    @Test(priority = 4)
    public void customerBtnTest() throws InterruptedException {
        customerPage = addCustomerDetails.customerBtn();
    }
    @AfterMethod
    public void DataTear(){

        driver.quit();
    }
}
