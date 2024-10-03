import static org.testng.Assert.assertEquals;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


    public class PageObjectFactory{
        WebDriver driver;


       // Helper ele = new Helper();
       // BaseTest drive = new BaseTest();

        @FindBy(xpath = "//*[@id='user-name']")
        WebElement userID;

        @FindBy(xpath = "//*[@id='password']")
        WebElement pwd;

        @FindBy(xpath = "//*[@id='login-button']")
        WebElement btnLogin;

        @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
        WebElement btnBurger;

        @FindBy(xpath = "//*[@id='logout_sidebar_link']")
        WebElement lnkLogout;

        @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-backpack']")
        WebElement btnAddItem1;

        @FindBy(xpath = "//*[@id='add-to-cart-sauce-labs-bike-light']")
        WebElement btnAddItem2;


        public PageObjectFactory(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }
/*
        public void Login() throws InterruptedException {
            //extentTest = extentReports.createTest("Test Case 1", "Sample test");
            driver.get("https://www.saucedemo.com/");
            ele.click(userID);
            ele.enterText(userID,"standard_user");
            ele.enterText(pwd,"secret_sauce");
            ele.click(btnLogin);



        }

        public void Logout() throws InterruptedException {
            ele.click(btnBurger);
            Thread.sleep(3000);
            ele.click(lnkLogout);
        }

        public void addToCart() throws InterruptedException {
            Login();
            ele.click(btnAddItem1);
            ele.click(btnAddItem2);
            Logout();

        }

*/
    }

