import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.logging.Logger;

public class AddCustomer {
    public static WebDriver driver = BaseClass.driver;
    public static void addCustomerFun() throws InterruptedException {
        //click on bank manager login
        driver.findElement(By.cssSelector("button[ng-click='manager()']")).click();
        Thread.sleep(2000);
        //click on add customer
        driver.findElement(By.xpath("//button[normalize-space()='Add Customer']")).click();
        Thread.sleep(2000);
        //Add First name field
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("fds");
        Thread.sleep(2000);
        //Add Second name field
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("asdasd");
        Thread.sleep(2000);
        //Add Post Code field
        driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("21323");
        Thread.sleep(2000);
        //Press on button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        String val = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(val);
        openAccountFun();
        goToHome();
        customerLogin();

    }
    public static void customerLogin() throws InterruptedException {
        //click customer login
        driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
        Select yourName = new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
        yourName.selectByVisibleText("fds asdasd");
        Thread.sleep(2000);
        //click Login
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }
    public static void goToHome() {
        //click on home button
        driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
    }
    public static void openAccountFun() throws InterruptedException {
        //go to open account
        driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']")).click();
        //click on customer dropdown
        Thread.sleep(2000);
        Select customer = new Select(driver.findElement(By.xpath("//select[@id='userSelect']")));
        customer.selectByVisibleText("fds asdasd");
        Thread.sleep(2000);
        Select currency = new Select(driver.findElement(By.xpath("//select[@id='currency']")));
        currency.selectByVisibleText("Rupee");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Process']")).click();
        Thread.sleep(2000);
        String val = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(val);
    }
}
