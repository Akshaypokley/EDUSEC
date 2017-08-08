package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AKSHAY on 26/04/2017.
 */
public class Menu
{
    WebDriver driver;

    @FindBy(xpath = "//li[1]/a/span")
    WebElement MenuLogo;

    @FindBy(xpath = "//li[2]/a/span")
    WebElement Configuration;

    @FindBy(xpath = "//li[4]/a/span")
    WebElement CourseModule;

    @FindBy(xpath = "//li[3]/a/span")
    WebElement DashBoard;

    @FindBy(xpath = "//li[6]/a/span")
    WebElement EmployeeModule;

    @FindBy(xpath = "//li[7]/a/span")
    WebElement FeesModule;

    @FindBy(xpath = "")
    WebElement ReportCenter;

    @FindBy(xpath = "//li[5]/a/span")
    WebElement Student;

    @FindBy(xpath = "//li[8]/a/span")
    WebElement UserRights;

    public Menu(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!MenuLogo.isDisplayed())
        throw new IllegalStateException("This Not Pages.Menu Bar");
    }


    public WebElement getMenuLogo()
    {
        return MenuLogo;
    }

    public void  ClickConfiguration()
    {
        Configuration.click();
    }

    public void ClickcourseModules()
    {
        CourseModule.click();
    }

    public void ClickEmployeeModule()
    {
        EmployeeModule.click();

    }

    public void ClickFeesModule()
    {
        FeesModule.click();
    }

    public void ClickReportCenter()
    {
        ReportCenter.click();
    }

    public void ClickStudent()
    {
        Student.click();
    }

    public void ClickUserRights()
    {
        UserRights.click();
    }

    public void ClickDashBoard() {
        DashBoard.click();
    }
}
