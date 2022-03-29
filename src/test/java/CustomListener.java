import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseClass implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result){
        failed();
    }
}
