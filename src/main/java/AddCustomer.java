import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

public class AddCustomer {
    public static WebDriver driver = BaseClass.driver;
    static String prev;
    static String val;
    static String now;
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
        val = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println(val);
    }
    public static void goToHome() {
        //click on home button
        driver.findElement(By.xpath("//button[normalize-space()='Home']")).click();
    }

}
