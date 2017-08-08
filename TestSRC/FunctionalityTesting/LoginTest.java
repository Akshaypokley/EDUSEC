package FunctionalityTesting;

import Pages.Login;
import Utilities.initExtentReport;
import com.gargoylesoftware.htmlunit.Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilities.OpenBrowser.GetUrl;
import static Utilities.OpenBrowser.openBrowser;
import static Utilities.TakeScreenShot.takeScreenshot;

/**
 * Created by AKSHAY on 26/04/2017.
 */
public class LoginTest {

    WebDriver  driver;
    ExtentReports extent ;
    @BeforeMethod
    public void LoadBrowser()
    {
     driver=openBrowser("chrome") ;
     GetUrl("url");
        extent = initExtentReport.init();
    }

    @Test(dataProvider = "UserInput")
    public void LoginTest(String userId,String UserPass,String Expeted,String Actual) throws IOException {
        ExtentTest test = extent.startTest("LoginFunction Test", "To Test the functionalty of login button");
        try {
            Login login = new Login(driver);
            test.log(LogStatus.INFO, " initialised driver");

            login.setLoginID(userId);
            test.log(LogStatus.INFO, " Set UserName");

            login.setLoginPassword(UserPass);
            test.log(LogStatus.INFO, " Set password");

            login.ClickLoginButton();
            test.log(LogStatus.INFO, " Click on Login Button");
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            login.ClickSubmit();
            test.log(LogStatus.INFO, " Click On submit");
            try
            {
            String actual=driver.findElement(By.xpath(Actual)).getText();

                Assert.assertEquals(actual,Expeted,"Test Pass");

                test.log(LogStatus.INFO, " Test Pass");
                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));

            }
            catch (Throwable e)
            {
                //System.out.println(e);
                test.log(LogStatus.FAIL, "Element not found : "+e);
                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));

            }
        }
        catch (AssertionError e)
        {
            //System.out.println(e);
            test.log(LogStatus.FAIL, "Element not found : "+e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));

        }
        extent.endTest(test);
        extent.flush();
        driver.close();

    }

    @DataProvider
    public Object[][] UserInput() throws IOException {

        FileInputStream fis=new FileInputStream("ExcelSheet/LoginTest.xls");
        HSSFWorkbook workbook=new HSSFWorkbook(fis);
        HSSFSheet sheet =workbook.getSheet("LoginTest");

        int RowCount=sheet.getPhysicalNumberOfRows();

        String data[][]=new String[RowCount-1][4];

        for(int i=1;i<RowCount;i++)
        {
            HSSFRow row=sheet.getRow(i);

            HSSFCell UserIDCell =row.getCell(0);
            if (UserIDCell==null)
            {
                data[i-1][0]="";
            }
            else
            {
                UserIDCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][0]=UserIDCell.getStringCellValue();
            }

            HSSFCell UserIDPass =row.getCell(1);
            if (UserIDPass==null)
            {
                data[i-1][1]="";
            }
            else
            {
                UserIDPass.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][1]=UserIDPass.getStringCellValue();
            }

            HSSFCell UserIDExpected =row.getCell(2);
            if (UserIDExpected==null)
            {
                data[i-1][2]="";
            }
            else
            {
                UserIDExpected.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][2]=UserIDExpected.getStringCellValue();
            }

            HSSFCell Actual =row.getCell(3);
            if (Actual==null)
            {
                data[i-1][3]="";
            }
            else
            {
                Actual.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=Actual.getStringCellValue();
            }
        }

        return data;
    }
}
