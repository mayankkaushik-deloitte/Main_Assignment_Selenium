import org.apache.commons.math3.analysis.function.Add;
import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
public class AddCustomer extends BaseClass {
    public static final Logger log = Logger.getLogger(AddCustomer.class);
    //Page Factory- OR;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    static
    WebElement fName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    static
    WebElement lName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    static
    WebElement postCode;

    @FindBy(xpath = "//button[text()='Add Customer']")
    static
    WebElement addCustomerBtn;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeBtn;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountBtn;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersBtn;
    static String val;
    static XSSFWorkbook wbook;
    static XSSFSheet sheet;
    public AddCustomer(){
        PageFactory.initElements(driver,this);
    }
    public static void addCustomerFun() throws InterruptedException, IOException {
        log.error("+++++++++ADD CUSTOMER++++++++++");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        fName.sendKeys("Mayank");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        lName.sendKeys("Kaushik");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        postCode.sendKeys("201005");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        addCustomerBtn.click();
        Alert alertStatus = driver.switchTo().alert();
        val = alertStatus.getText();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        alertStatus.accept();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public LoginPage clickHomeBtn() throws InterruptedException {
        homeBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new LoginPage();
    }
    public OpenAccount accountBtn() throws InterruptedException {
        openAccountBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new OpenAccount();
    }
    public CustomerLogin customerBtn() throws InterruptedException {
        customersBtn.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new CustomerLogin();
    }
    public static void goToHome() {
        //click on home button
        driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
    }
}
