import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseClass{
    //Page Factory- OR;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    WebElement bankManager;

    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customer;
    //initialize page objects
    public LoginPage(){
        PageFactory.initElements(driver,this);

    }
    //actions
    public String validateLoginPageTitle(){

        return driver.getTitle();
    }
    public BankManager clickOnManagerLogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        bankManager.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new BankManager();

    }
    public NamePage clickoncustomerlogin() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        customer.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new NamePage();
    }

}