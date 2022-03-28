import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseClass{
    CustomerLogin objcustomer;
    LoginPage loginpage;
    BankManager bankmanagerhome;
    AddCustomer objaddcustomer;
    OpenAccount objopencnt;


    public CustomerLoginTest (){
        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        init();
        objcustomer = new CustomerLogin();
        loginpage = new LoginPage();
        objaddcustomer =new AddCustomer();
        bankmanagerhome= new BankManager();
        bankmanagerhome= loginpage.clickOnManagerLogin();
        objcustomer= bankmanagerhome.clickCustomers();
        Thread.sleep(2000);
    }
    @Test
    public void fillValueTest1() throws InterruptedException {
        objcustomer.fillValue(prop.getProperty("firstname"));
    }
    @Test
    public void fillValueTest2() throws InterruptedException {
        objcustomer.fillValue(prop.getProperty("duplicatefname"));
    }
    @Test
    public void addCustomerTest() throws InterruptedException {
        objaddcustomer = objcustomer.addCustomers();
    }
    @Test
    public void clickHomeTest() throws InterruptedException {
        loginpage = objcustomer.clickHome();
    }
    @Test
    public void openAccountTest() throws InterruptedException {
        objopencnt = objcustomer.clickOpenAccount();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
