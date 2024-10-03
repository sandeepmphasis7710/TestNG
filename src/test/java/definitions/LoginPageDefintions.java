package definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.BaseTest1;
import Base.Helper1;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import Base.*;
import java.io.IOException;
import java.time.Duration;

public class LoginPageDefintions {
    public WebDriver driver;
    public final static int TIMEOUT = 5;
    //PageObjectFactory obj ;
    //Helper1 ele = null; ;
    BaseTest1 base = new BaseTest1() ;
    Helper1 ele = new Helper1(base.driver);

    //Faker faker;
    //User userPayload;
    public String uname;
    Utilities1 util = new Utilities1();
    WebElement element;


    @Before
    public void setUp(Scenario scenario) throws IOException {

       //base.startReporter();
       //base.extentTest = base.extentReports.createTest(String.valueOf(scenario), "BDD test");

    }

    @Given("Open Base URL")
    public void open_base_url() throws IOException {
       // ele = new Helper1(driver);

        base.driver.get(util.returnConfig("testURL"));
       // driver.get(util.returnConfig("testURL"));


    }

    @When("User Logs in")
    public void goToHomePage() throws IOException, InterruptedException {
        ele.enterText("User_Id","css",util.returnConfig("UserID"));
        ele.enterText("Password","id",util.returnConfig("password"));
        ele.click("LoginButton","id");
         }

        @Then("User Logs Out")
        public void verifyLogin() throws IOException, InterruptedException {
            ele.click("btnBurger","xpath");
            Thread.sleep(3000);
            ele.click("lnkLogout","xpath");

        }

    @And("User adds Item1 to cart")
    public void addItem1() throws IOException, InterruptedException {
        ele.click("btnAddItem1","xpath");

    }
    @And("User adds Item2 to cart")
    public void addItem2() throws IOException, InterruptedException {
        ele.click("btnAddItem2","xpath");

    }
    /*
            @Then("User should be able to see the url")
            public void verifyErrorMessage(String expectedErrorMessage) {

                String url = driver.getCurrentUrl();
                System.out.println(url);

            }
        */

    @After
    public void teardown() {

        base.driver.quit();
    }

}