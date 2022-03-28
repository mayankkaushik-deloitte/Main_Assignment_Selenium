import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
    //Page Factory- OR;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div[2]/button")
    WebElement bankmanager;

    @FindBy(xpath = "//button[text()='Customer Login']")
    WebElement cutomer;
    //initialize page objects
    

}
