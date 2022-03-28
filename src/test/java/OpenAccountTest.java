import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenAccountTest extends BaseClass {
    AddCustomer addCustomerDetails;
    LoginPage loginPage;
    BankManager bankManagerhome;
    OpenAccount openAccount;
    CustomerLogin customersPage;
    public OpenAccountTest(){
        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        init();
        addCustomerDetails=new AddCustomer();
        loginPage=new LoginPage();
        openAccount=new OpenAccount();
        bankManagerhome=new BankManager();
        customersPage=new CustomerLogin();
        bankManagerhome =loginPage.clickOnManagerLogin();
        openAccount=bankManagerhome.clickOpenAccount();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void clickCustomersTest() throws InterruptedException {
        customersPage=openAccount.customerBtnClick();
    }
    @Test(priority = 2)
    public void clickHomeTest() throws InterruptedException {
        loginPage=openAccount.homeBtnClick();
    }
    @Test(priority = 3)
    public void clickAddCustomerTest() throws InterruptedException {
        addCustomerDetails = openAccount.clickAddCustomer();
    }
    @Test(priority = 4)
    public void userDropDownTest() throws InterruptedException {
        openAccount.userDropDown("Harry Potter", "Dollar");

    }
    
    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

}
