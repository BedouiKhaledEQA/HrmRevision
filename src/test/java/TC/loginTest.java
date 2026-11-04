package TC;
import base.baseTest;
import dataProvider.myDataProvider;
import listners.myListners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.loginPage;


@Listeners(myListners.class)
public class loginTest extends baseTest{

    @Test(dataProvider = "LoginData",dataProviderClass = myDataProvider.class)
    public void verifyLogin(String username,String password , boolean expectedResult) throws InterruptedException {
        pages.loginPage loginPage=new loginPage(driver);

        loginPage.login(username,password);
        if(expectedResult){
            Assert.assertTrue(loginPage.isDashboardDisplayed(),"login should be success");
        }else {
            Assert.assertTrue(loginPage.isLoginErrorIsDisplayed(),"Login error");
        }
        Thread.sleep(5000);
    }

}
