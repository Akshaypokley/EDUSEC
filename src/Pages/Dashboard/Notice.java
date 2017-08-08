package Pages.Dashboard;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AKSHAY on 28/04/2017.
 */
public class Notice {

    WebDriver driver;

    @FindBy(xpath = "//div[1]/div[1]/h3")
    WebElement NoticeLogo;

    @FindBy(xpath = "html/body/div[2]/aside[1]/section/ul/li[2]/ul/li[2]")
    WebElement Clickno;

    @FindBy(xpath = "//td[2]/input")
    WebElement Title;

    @FindBy(xpath = "//td[3]/input")
    WebElement Description;

    @FindBy(xpath = "//td[4]/select/option")
    WebElement UserType;

    @FindBy(xpath = ".//*[@id='notice_date']")
    WebElement Date;

    @FindBy(xpath = "//td[6]/select/option")
    WebElement Active;

    @FindBy(xpath ="//div[1]/div[2]/div[1]/a" )
    WebElement Add;

    public Notice(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!NoticeLogo.isDisplayed())
            throw  new IllegalStateException("This Notice List  Page");
    }


    public void setClickno()
    {
        Clickno.click();
    }

    public void ClickAdd ()
    {
        Add.click();
    }

    public WebElement getNoticeLogo()
    {
        return NoticeLogo;
    }

    public void setTitle(String TitleNm) {
        Title.sendKeys(TitleNm);
    }

    public void setUserType(String UserTp) {
        Select combo = new Select (UserType) ;
        combo.selectByValue(UserTp);

    }

    public void setDescription(String Descrip) {
      Description.sendKeys(Descrip);
    }

    public void setDate(String setdate)

            throws ParseException {


        SimpleDateFormat myDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat calDateFormat = new SimpleDateFormat("MMMM yyyy");
        java.util.Date setDate=myDateFormat.parse(setdate);

        Date.click();

        //driver.findElement(By.xpath(".//*[@id='datetimepicker1']/span/span")).click();

        Date curDate = calDateFormat.parse(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[6]/a")).getText());
        System.out.println(curDate);

        int monthDiff = Months.monthsBetween(new DateTime(curDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        boolean isFuture = true;
        // decided whether set date is in past or future
        if(monthDiff<0){
            isFuture = false;
            monthDiff*=-1;
        }
        // iterate through month difference
        for(int i=1;i<=monthDiff;i++){
            driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[@title="+ (isFuture ? "'next'" : "'prev'") + "]")).click();
        }
        // Click on Day of Month from table
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[4]/a" + (new DateTime(setDate).getDayOfMonth()) + "")).click();
    }

    public void setActive(String ActiveStatus) {
        Select combo = new Select (Active) ;
        combo.selectByValue(ActiveStatus);

    }
}
