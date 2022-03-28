import org.openqa.selenium.By;

public class Withdraw {
    
    public static void withdraw() throws InterruptedException {
        String prev = AddCustomer.driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)")).getText();
        //click on withdraw button
        AddCustomer.driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
        //enter amount
        Thread.sleep(2000);
        int amount = 500;
        AddCustomer.driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("5000");
        Thread.sleep(2000);
        //CLick withdraw
        AddCustomer.driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);

        String now = AddCustomer.driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > strong:nth-child(2)")).getText();
        if(Integer.parseInt(prev) - amount == Integer.parseInt(now)){
            System.out.println("Correct withdrawal");
        }else{
            System.out.println("Wrong withdrawal");
        }
    }
}
