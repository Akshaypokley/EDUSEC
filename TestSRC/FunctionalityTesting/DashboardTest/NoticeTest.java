package FunctionalityTesting.DashboardTest;

import Pages.Dashboard.Notice;
import Pages.Menu;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static Utilities.LogFun.LoginFunction;
import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;

/**
 * Created by AKSHAY on 28/04/2017.
 */
public class NoticeTest {

    WebDriver  driver;
    @BeforeMethod()
    public void LoadBrwser()
    {


        driver=LoginFunction();
    }

    @Test
    public void AddNotice() throws ParseException {

        Menu menu=new Menu(driver);
        menu.ClickDashBoard();

        Notice notice=new Notice(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

       /* notice.setClickno();
        notice.setTitle("yf");
        notice.setDescription("jhgfds");
        notice.setUserType("Student");
        notice.setDate("12/05/2017");
        notice.setActive("Active");
        notice.ClickAdd();*/
    }
}
