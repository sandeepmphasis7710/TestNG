import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;


public class BaseTest {

    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    public EdgeDriver driver = null;
     WebElement element;

    @BeforeTest
    public void startReporter() throws IOException {
        Runtime.getRuntime().exec(
                "cmd /c taskkill /f /im chromedriver.exe");
       // ChromeOptions options = new ChromeOptions();
       // options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
       // WebDriver driver = new ChromeDriver(options);
       // System.setProperty("webdriver.chrome.driver", "C:/Users/sandeep.s8/IdeaProjects/test/chromedriver.exe");

        driver = new EdgeDriver();
        //To maximize browser
        driver.manage().window().maximize();
        extentSparkReporter  = new ExtentSparkReporter("C:/Users/sandeep.s8/IdeaProjects/test/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        Helper ele = new Helper(driver);

        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }


    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot();
            extentTest.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            captureScreenshot();
            extentTest.log(Status.PASS, result.getTestName());

        }
        else {
            extentTest.log(Status.SKIP, result.getTestName());
        }
    }
    @AfterTest
    public void tearDown() {
        //to write or update test information to the reporter
        extentReports.flush();
    }


    public String captureScreenshot()
    {
        try
        {
            System.out.println("Taking screenshot for failed assert");
            String screenshotPath = "C:/Users/sandeep.s8/IdeaProjects/test/test-output/screenshots/";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            System.out.println("Adding screenshot to extent report");
            String screenshotName = "screenshot_" + new Random().nextInt(999) + ".png";
            screenshotPath = screenshotPath + File.separator + screenshotName;
            Files.copy(screenshot.toPath(), new File(screenshotPath).toPath());
            //extentTest.addScreenCaptureFromPath(screenshotPath);
            return screenshotPath;
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public String captureScreen() throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = "C:/Users/sandeep.s8/IdeaProjects/test/test-output/screenshots/" + new Random().nextInt(999999) + ".png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);
        return dest;
    }
}