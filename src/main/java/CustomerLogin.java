import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class CustomerLogin {
    public static void customerLogin() throws InterruptedException {
        //click customer login
        BaseClass.driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
        Select yourName = new Select(BaseClass.driver.findElement(By.xpath("//select[@id='userSelect']")));
        yourName.selectByVisibleText("fds asdasd");
        Thread.sleep(2000);
        //click Login
        BaseClass.driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

    }
}
