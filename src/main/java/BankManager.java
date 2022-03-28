import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BankManager extends BaseClass{
    //Page Factory- OR;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[1]")
    WebElement addCustomer;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    WebElement openAccount;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customers;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeBtn;


    public BankManager(){
        PageFactory.initElements(driver,this);
    }
    public AddCustomer clickAddCustomer() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        addCustomer.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new AddCustomer();
    }
    public CustomerLogin clickCustomers() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        customers.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new CustomerLogin();

    }
    public OpenAccount clickOpenAccount() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        openAccount.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new OpenAccount();
    }
    public LoginPage clickHome() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homeBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new LoginPage();
    }
}
