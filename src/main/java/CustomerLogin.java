import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CustomerLogin extends BaseClass{
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement inputCustomer;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeBtn;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openBtn;

    public CustomerLogin(){
        PageFactory.initElements(driver,this);
    }
    public void fillValue(String username) throws InterruptedException{
        inputCustomer.sendKeys(username);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        deleteBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public AddCustomer addCustomers() throws InterruptedException {
        addCustomer.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new AddCustomer();
    }
    public LoginPage clickHome() throws InterruptedException {
        homeBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new LoginPage();
    }
    public OpenAccount clickOpenAccount() throws InterruptedException {
        openBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new OpenAccount();
    }

}
