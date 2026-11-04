package listners;

import base.baseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class myListners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED :"+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED :"+result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED :"+result.getName());
        Object testClass= result.getInstance();
        baseTest base =(baseTest) testClass;
        WebDriver driver=base.driver;
        if(driver!= null){
            File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File Destination=new File("screenshot/"+result.getName()+".png");
            try {
                FileUtils.copyFile(screenshot,Destination);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED :"+result.getName());

    }
}
