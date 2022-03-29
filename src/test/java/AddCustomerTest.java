import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@Listeners(CustomListener.class)
public class AddCustomerTest extends BaseClass{
    AddCustomer addCustomerDetails;
    LoginPage loginPage;
    BankManager bankManagerhome;
    OpenAccount openAccount;
    CustomerLogin customerPage;
    public AddCustomerTest(){
        super();
    }
    @BeforeMethod
    public void setUP() throws InterruptedException {
        BaseClass.intialisation();
        addCustomerDetails = new AddCustomer();
        loginPage = new LoginPage();
        openAccount = new OpenAccount();
        bankManagerhome = new BankManager();
        customerPage = new CustomerLogin();
        bankManagerhome = loginPage.clickOnManagerLogin();
        addCustomerDetails = bankManagerhome.clickAddCustomer();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void addCustomerTest() throws InterruptedException, IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\mayakaushik\\Main_Assignment_Selenium\\src\\data\\Excel.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getLastCellNum();
        String first=null;
        String last=null;
        String postcode=null;
        for(int i=1;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    first= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if (j == 1) {
                    last= sheet.getRow(i).getCell(j).getStringCellValue();
                }
                if(j==2){
                    postcode=sheet.getRow(i).getCell(j).getStringCellValue();
                }

            }
            System.out.println(first+" "+last+" "+postcode);
            //log.error("test failed in reading");
            addCustomerDetails.addCustomerFun(first,last,postcode);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            System.out.println(addCustomerDetails.val);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            addCustomerDetails.customerBtn();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            customerPage.addCustomers();
        }
        wb.close();
        inputStream.close();
        Assert.assertEquals(addCustomerDetails.val,"Customer added successfully with customer id :6");
    }

    @Test(priority =2)
    public void homeBtnTest() throws InterruptedException {
        loginPage = addCustomerDetails.clickHomeBtn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
    @Test(priority = 3)
    public void accountBtnTest() throws InterruptedException {
        openAccount = addCustomerDetails.accountBtn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @Test(priority = 4)
    public void customerBtnTest() throws InterruptedException {
        customerPage = addCustomerDetails.customerBtn();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void DataTear(){

        driver.quit();
    }
}
