import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends BaseClass{
    @FindBy (xpath = "//span[@class='fontBig ng-binding']")
    WebElement userNameTitle
    @FindBy (xpath = "//button[normalize-space()='Deposit']")
    WebElement deposit
    @FindBy (xpath = "//button[normalize-space()='Deposit']")
    WebElement withdrawal
    @FindBy (xpath = "//button[normalize-space()='Transactions']")
    WebElement transactionBtn
    @FindBy (xpath = "body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)")
    WebElement balance
    @FindBy (xpath = "//input[@placeholder='amount']")
    WebElement fillVal;
    @FindBy (xpath = "//input[@placeholder='amount']")
    WebElement depositSubmitBtn
    public ProfilePage () {
        PageFactory.initElements(driver,this);
    }

    public void depositMoney(String amount){
        deposit.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        fillVal.sendKeys(amount);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        depositSubmitBtn.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
}
