import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OpenAccount extends BaseClass{
    //Page Factory- OR;
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement btnHome;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersBtn;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processBtn;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement userSelect;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;
    public String altMsg;

    public OpenAccount(){
        PageFactory.initElements(driver,this);
    }
    public CustomerLogin customerBtnClick() throws InterruptedException {
        customersBtn.click();
        Thread.sleep(2000);
        return new CustomerLogin();
    }

    public LoginPage homeBtnClick() throws InterruptedException {
        btnHome.click();
        Thread.sleep(2000);
        return new LoginPage();
    }

    public AddCustomer clickAddCustomer() throws InterruptedException {
        addCustomer.click();
        Thread.sleep(2000);
        return new AddCustomer();

    }
    public void userDropDown(String name,String currencyUser) throws InterruptedException {
        Select selectUser=new Select(userSelect);
        selectUser.selectByVisibleText(name);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Select selectCurrency=new Select(currency);
        selectCurrency.selectByVisibleText(currencyUser);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        processBtn.click();
        Alert simpleAlert=driver.switchTo().alert();
        altMsg = simpleAlert.getText();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        simpleAlert.accept();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
