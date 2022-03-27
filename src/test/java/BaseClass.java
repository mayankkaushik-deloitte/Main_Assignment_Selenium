import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class BaseClass {
    public static WebDriver driver;
    public static XSSFWorkbook wbook;
    public static XSSFSheet sheet;
    private final String FILEPATH = "C:\\Users\\mayakaushik\\m_AS_4\\src\\test\\java\\excel.xlsx";
    @BeforeTest
    public void DataSetUp() throws IOException{
        FileInputStream fis = new FileInputStream(FILEPATH);
        wbook = new XSSFWorkbook(fis);
        sheet = wbook.getSheet("Sheet1");
    }
    @Test
    public static void addCustomer(){
        AddCustomer.addCustomerFun();
    }


}
