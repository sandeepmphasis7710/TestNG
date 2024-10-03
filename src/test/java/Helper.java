import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static org.testng.Assert.assertFalse;

public class Helper extends Utilities {
     WebDriver driver;
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }


    // Method to click on an element identified by its XPath
    public void click(String loc, String locType) throws IOException {

        String var = (readObject(loc,locType));

        WebElement element = null;
        try {

            switch (locType)
            {

                case "xpath":
                     element = driver.findElement(By.xpath(var));
                     break;

                case "css":
                    element = driver.findElement(By.cssSelector(var));
                    break;


                case "id":
                    element = driver.findElement(By.id(var));
                    break;


                case "class":
                    element = driver.findElement(By.className(var));
                    break;


            }

             element.click();
        }
        catch ( Exception e)
        {
            System.out.println("exception in click is "+ e.toString());
            //extentTest.log(Status.FAIL, "Clicked on Element " + element);

        }
    }

    // Method to enter text into a text field identified by its ID
    public void enterText(String loc,String locType ,String text) throws IOException {


           WebElement element = null;
        String var = (readObject(loc,locType));
        switch (locType)
        {

            case "xpath":
                element = driver.findElement(By.xpath(var));
                break;

            case "css":
                element = driver.findElement(By.cssSelector(var));
                break;

            case "id":
                element = driver.findElement(By.id(var));
                break;

            case "class":
                element = driver.findElement(By.className(var));
                break;


        }

           //= driver.findElement(By.xpath(xp));
            //driver.findElement(By.xpath(xp));
           element.sendKeys(text);


    }

    // Method to verify if an element is present on the page
    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to get text of an element identified by its CSS selector
    public String getTextByCssSelector(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        return element.getText();
    }

    // Method to wait for a specified number of seconds
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to validate if element text matches expected text
    public boolean validateElementText(String locator, String expectedText) {
        WebElement element = driver.findElement(By.xpath(locator));
        String actualText = element.getText();
        return actualText.equals(expectedText);
    }

    // Method to get the attribute value of an element
    public String getAttributeValue(String locator, String attribute) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getAttribute(attribute);
    }

    // Method to scroll to an element
    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Method to highlight an element
    public void highlightElement(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    // Method to reset element styles
    public void resetElementStyles(By by) {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 0px solid red;');", element);
    }}
