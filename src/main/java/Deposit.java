import org.openqa.selenium.By;

public class Deposit {
    public static void deposit() throws InterruptedException {
        //get prev amount
        String prev = BaseClass.driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)")).getText();
        //click on deposit
        Thread.sleep(2000);

        BaseClass.driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
        //enter amount
        Thread.sleep(2000);
        int amount = 1000;
        BaseClass.driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
        System.out.println(BaseClass.driver.findElement(By.xpath("//input[@placeholder='amount']")).getText());
        Thread.sleep(2000);
        //click on deposit
        BaseClass.driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        //get new balance
        String now = BaseClass.driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)")).getText();
        Thread.sleep(2000);
        System.out.println(now);
        if((Integer.parseInt(now) - amount) == Integer.parseInt(prev))
        {
            System.out.println("Correct deposit");
        }else{
            System.out.println("Wrong Deposit");
        }
    }
}
