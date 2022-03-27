import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomer {
    public static WebDriver driver = BaseClass.driver;
    public static void addCustomerFun(){
        //click on bank manager login
        driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();
        //click on add customer
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
        //Add First name field
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(BaseClass.sheet.getRow(1).getCell(0).getStringCellValue());
        //Add Second name field
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(BaseClass.sheet.getRow(1).getCell(1).getStringCellValue());
        //Add Post Code field
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(BaseClass.sheet.getRow(1).getCell(2).getStringCellValue());
        //Press on button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
