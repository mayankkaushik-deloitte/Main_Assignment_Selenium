import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class BankManager extends BaseClass{
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

    public openAccount(){
        PageFactory.initElements(driver,this);
    }
    public Customerspage customerbtnclick() throws InterruptedException {
        customersBtn.click();
        Thread.sleep(2000);
        return new CustomersPage();
    }

    public LoginPage homeBtnClick() throws InterruptedException {
        btnHome.click();
        Thread.sleep(2000);
        return new LoginPage();
    }

    public AddCustomer clickaddcustomer() throws InterruptedException {
        addCustomer.click();
        Thread.sleep(2000);
        return new AddCustomer();

    }
    public void userDropDown(String name,String currencyUser) throws InterruptedException {
        Select selectuser=new Select(userSelect);
        selectuser.selectByVisibleText(name);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Select selectcurrency=new Select(currency);
        selectcurrency.selectByVisibleText(currencyuser);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        processBtn.click();
        Alert simplealert=driver.switchTo().alert();
        altMsg = simplealert.getText();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        simplealert.accept();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
