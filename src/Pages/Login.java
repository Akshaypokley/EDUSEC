package Pages;

import com.gargoylesoftware.htmlunit.Page;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AKSHAY on 22/04/2017.
 */
public class Login
{
    WebDriver driver;

    @FindBy(xpath = "//div[2]/div[2]/h1/img")
    WebElement ProLogo;

    @FindBy(xpath = ".//*[@id='loginform-username']")
    WebElement LoginID;

    @FindBy(xpath = ".//*[@id='loginform-password']")
    WebElement LoginPassword;

    @FindBy(xpath = "//div[3]/div[2]/button")
    WebElement LoginButton;






    @FindBy(xpath = "//div[@class='modal-content']/div[3]/button")
    WebElement submit;

    public Login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!ProLogo.isDisplayed())
            throw  new IllegalStateException("This Not Login Page");
    }

    public void ClickSubmit()
    {
        submit.click();
    }

    public WebElement getProLogo()
    {
        return  ProLogo;
    }

    public void setLoginID(String UserName)
    {
        LoginID.sendKeys(UserName);

    }

    public void setLoginPassword(String Userpassword)
    {
        LoginPassword.sendKeys(Userpassword);

    }

    public void ClickLoginButton()
    {
        LoginButton.click();
    }


}
