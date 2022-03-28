import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class OpenAccount {
    public static void openAccountFun() throws InterruptedException {
        //go to open account
        BaseClass.driver.findElement(By.cssSelector(".btn.btn-lg.tab[ng-class='btnClass2']")).click();
        //click on customer dropdown
        Thread.sleep(2000);
        Select customer = new Select(BaseClass.driver.findElement(By.xpath("//select[@id='userSelect']")));
        //select user
        customer.selectByVisibleText("fds asdasd");
        Thread.sleep(2000);
        //select currency
        Select currency = new Select(BaseClass.driver.findElement(By.xpath("//select[@id='currency']")));
        currency.selectByVisibleText("Rupee");
        Thread.sleep(2000);
        //Click process
        BaseClass.driver.findElement(By.xpath("//button[normalize-space()='Process']")).click();
        Thread.sleep(2000);
        //get the alert message
        String val = BaseClass.driver.switchTo().alert().getText();
        BaseClass.driver.switchTo().alert().accept();
        System.out.println(val);
    }
}
