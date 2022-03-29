import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)

public class BankManagerTest extends BaseClass {
    BankManager objbankmanagerhome;
    AddCustomer objaddcustomerdetails1;
    LoginPage loginpage;
    OpenAccount objopenacnt;
    CustomerLogin objcustomers;
    public BankManagerTest(){
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        intialisation();
        objbankmanagerhome=new BankManager();
        loginpage=new LoginPage();
        objcustomers=new CustomerLogin();
        objopenacnt=new OpenAccount();
        objaddcustomerdetails1=new AddCustomer();
        objbankmanagerhome=loginpage.clickOnManagerLogin();
        Thread.sleep(2000);
    }
    @Test(priority = 1)
    public void addcustomertest() throws InterruptedException {
        objaddcustomerdetails1 = objbankmanagerhome.clickAddCustomer();

    }
    @Test(priority =2)
    public void openaccounttest() throws InterruptedException {
        objopenacnt = objbankmanagerhome.clickOpenAccount();

    }
    @Test(priority = 3)
    public void customerstest() throws InterruptedException {
        objcustomers=objbankmanagerhome.clickCustomers();
    }
    @Test(priority =4)
    public void homebtmtest() throws InterruptedException {
        loginpage=objbankmanagerhome.clickHome();
    }

    @AfterMethod
    public void DataTear(){
        driver.quit();
    }
}
