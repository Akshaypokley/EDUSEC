package Utilities;

import Pages.Login;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;

/**
 * Created by AKSHAY on 28/04/2017.
 */
public class LogFun {

    static WebDriver driver;


    public static WebDriver  LoginFunction()
    {

        driver=openBrowser("chrome") ;
        GetUrl("url");
        Login login=new Login(driver);

        login.setLoginID("akshay");
        login.setLoginPassword("akshay");
        login.ClickLoginButton();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        login.ClickSubmit();
        return driver;
    }
}
