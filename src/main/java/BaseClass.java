import org.apache.commons.math3.analysis.function.Add;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public BaseClass(){
        try{
        prop=new Properties();
        FileInputStream ip=new FileInputStream("C:\\Users\\mayakaushik\\Main_Assignment_Selenium\\src\\data\\configuration.properties");
        prop.load(ip);
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static void intialisation(){
        String browserName=prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\mayakaushik\\Documents\\chromedriver.exe");
            driver=new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

}
