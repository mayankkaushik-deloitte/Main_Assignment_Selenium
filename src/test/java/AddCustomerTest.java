import org.apache.commons.math3.analysis.function.Add;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddCustomerTest {
    @BeforeMethod
    public void setUp() throws InterruptedException {
        BaseClass.SetUp();
    }
    @Test
    public void addCustomerTest() throws InterruptedException {
        AddCustomer.addCustomerFun();
        Assert.assertEquals(AddCustomer.val, "Customer added successfully with customer id :6");
    }
    @AfterMethod
    public void DataTear(){
        BaseClass.driver.quit();
    }
}
