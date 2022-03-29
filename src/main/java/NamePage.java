import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NamePage extends BaseClass {
    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement userSelect;
    @FindBy (xpath = "//select[@id='userSelect']")
    WebElement loginBtn;

    public NamePage () {
        PageFactory.initElements(driver,this);
    }
    public ProfilePage selectUser(String userName){
        Select s = new Select(userSelect);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        s.selectByVisibleText(userName);
        return new ProfilePage();
    }
}

