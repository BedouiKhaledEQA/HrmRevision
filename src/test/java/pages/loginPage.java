package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends basePage{
    public loginPage(WebDriver driver){
        super(driver);
    }

    private final By username= By.name("username");
    private final By password= By.name("password");
    private final By loginButton= By.cssSelector("button[type='submit']");
    private final By dashboardTitle= By.xpath("//p[normalize-space()='Time at Work']");
    private final By loginError= By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

    public void login(String user ,String pass){
        enterText(username,user);
        enterText(password,pass);
        click(loginButton);
    }

    public boolean isLoginErrorIsDisplayed(){
        return isDisplayed(loginError);
    }

    public boolean isDashboardDisplayed(){
        return isDisplayed(dashboardTitle);
    }


}
