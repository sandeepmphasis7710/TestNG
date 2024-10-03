import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
//import api.engine.endpoints.UserEndpoints;
//import api.payload.User;
import io.restassured.response.Response;

public class tests extends BaseTest{
    PageObjectFactory obj ;
    Helper ele ;
    Faker faker;
    User userPayload;
    public String uname;
    Utilities util = new Utilities();
    WebElement element;
    @BeforeTest
public void startReport()
{

    ele = new Helper(driver);


}

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("*****************USERNAME UNDER TEST**********************************");
        faker=new Faker();
        userPayload=new User();
        userPayload.setUserId(faker.idNumber().hashCode());
        uname = faker.name().username();
        userPayload.setUserName(uname);
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        System.out.println("Some Random username genereated by Faker:\t"+userPayload.getUserName());
        System.out.println("**********************************************************************");

    }

         @Test()
        public void Login_Logout() throws InterruptedException, IOException {
             //System.out.println("Object returned is " +util.readObject("User_Id"),"id");
             extentTest = extentReports.createTest("Login Test", "Sample test");
             extentTest.log(Status.PASS,"Open Base URL");
            // obj.Login();
             //extentTest.log(Status.INFO,"Click Logout");
             //obj.Logout();
             driver.get(util.returnConfig("testURL"));
             //log.log(Status.PASS, "Passed test 2"+log.addScreenCaptureFromPath(captureScreen()));

            // String xpa = (util.readObject("User_Id"));
            // String uname = (util.returnConfig("UserID"));
            // ele.enterText(util.readObject("'"+xpa+"'"),util.returnConfig("UserID"));
            ele.enterText("User_Id","css",util.returnConfig("UserID"));             extentTest.log(Status.INFO,"Enter UserName"+extentTest.addScreenCaptureFromPath(captureScreen()));
             ele.enterText("Password","id",util.returnConfig("password"));             extentTest.log(Status.INFO,"Enter UserName"+extentTest.addScreenCaptureFromPath(captureScreen()));


            // ele.enterText(util.readObject("Password"),"xpath",util.returnConfig("password"));         //extentTest.log(Status.PASS,"Click Login Button");
             extentTest.log(Status.INFO,"Enter Password"+extentTest.addScreenCaptureFromPath(captureScreen()));

             extentTest.log(Status.PASS,"Click Login Button");
            ele.click("LoginButton","id");
            extentTest.log(Status.INFO,"Click Login"+extentTest.addScreenCaptureFromPath(captureScreen()));

             extentTest.log(Status.PASS,"Click Menu Button");
            ele.click("btnBurger","xpath");
             extentTest.log(Status.INFO,"Click Menu"+extentTest.addScreenCaptureFromPath(captureScreen()));

             extentTest.log(Status.PASS,"Click LogOut");
             Thread.sleep(3000);
             ele.click("lnkLogout","xpath");
             extentTest.log(Status.INFO,"Click Logout"+extentTest.addScreenCaptureFromPath(captureScreen()));

         }
    /*
            @Test()
            public void Login_addToCart_Logout() throws InterruptedException {
                extentTest = extentReports.createTest("Add to Cart Test", "Sample test");
                extentTest.log(Status.PASS,"Open Base URL");
                // obj.Login();
                //extentTest.log(Status.INFO,"Click Logout");
                //obj.Logout();
                driver.get("https://www.saucedemo.com/");
                extentTest.log(Status.PASS,"Enter User ID");
               // ele.enterText(String.valueOf(obj.userID),"standard_user");
                extentTest.log(Status.PASS,"Enter Password");
               // ele.enterText(String.valueOf(obj.pwd),"secret_sauce");
                extentTest.log(Status.PASS,"Click Login Button");
                ele.click(obj.btnLogin);
                extentTest.log(Status.PASS,"Click add item to cart for first item");
                ele.click(obj.btnAddItem1);
                extentTest.log(Status.PASS,"Click add item to cart for second item");
                ele.click(obj.btnAddItem2);
                extentTest.log(Status.PASS,"Click Menu Button");
                ele.click(obj.btnBurger);
                extentTest.log(Status.PASS,"Click LogOut");
                Thread.sleep(3000);
                ele.click(obj.lnkLogout);
            }

            @Test()
            public void failure_Test() throws InterruptedException {
                extentTest = extentReports.createTest("Add to Cart Test", "Sample test");
                extentTest.log(Status.INFO,"Open Base URL");
                // obj.Login();
                //extentTest.log(Status.INFO,"Click Logout");
                //obj.Logout();
                driver.get("https://www.1saucedemo.com/");
                extentTest.log(Status.PASS,"Enter User ID");
                ele.enterText(obj.userID,"standard_user");
                extentTest.log(Status.PASS,"Enter Password");
                ele.enterText(obj.pwd,"secret_sauce");
                extentTest.log(Status.PASS,"Click Login Button");
                ele.click(obj.btnLogin);
                extentTest.log(Status.PASS,"Click add item to cart for first item");
                ele.click(obj.btnAddItem1);
                extentTest.log(Status.PASS,"Click add item to cart for second item");
                ele.click(obj.btnAddItem2);
                extentTest.log(Status.PASS,"Click Menu Button");
                ele.click(obj.btnBurger);
                extentTest.log(Status.PASS,"Click LogOut");
                Thread.sleep(3000);
                ele.click(obj.lnkLogout);
            }
        */


    @Test(priority = 1)
    public void testPostUser()
    {
        extentTest = extentReports.createTest("API POST Test", "POST request");

        Map<String,Object> bodyParams=new HashMap<String,Object>();
        bodyParams.put("id",userPayload.getUserId());
        bodyParams.put("username",userPayload.getUserName());
        bodyParams.put("firstName",userPayload.getFirstName());
        bodyParams.put("lastName",userPayload.getLastName());
        bodyParams.put("email",userPayload.getEmail());
        bodyParams.put("password",userPayload.getPassword());
        bodyParams.put("phone",userPayload.getPhone());
        bodyParams.put("userStatus",0);
        String payload=new Gson().toJson(bodyParams);
        System.out.println("*************************{POST}***************************************");
        Response response=UserEndpoints.createUser(payload);
        response.then().log().all();


        Assert.assertEquals(response.getStatusCode(),200);
        extentTest.log(Status.PASS,"Status code is 200");
        Assert.assertTrue(response.getTime()<5000);
        extentTest.log(Status.PASS,"Response time is within 5 seconds");

        Assert.assertTrue(response.getStatusLine().contains("OK"));
        System.out.println("**********"  +this.userPayload.getUserName()+" is created ************");

        ResponseBody body = response.getBody();
        String validate = body.asString();
        extentTest.log(Status.PASS,"Response body is "+validate);

    }

    @Test(priority=2)
    public void testGetUserByName()
    {
        extentTest = extentReports.createTest("API GET Request Test", "GET request");

        System.out.println("*************************{GET}****************************************");
        Response response=UserEndpoints.readUser(this.userPayload.getUserName());
        response.then().log().all();
        Assert.assertTrue(response.getStatusLine().contains("OK"));

        Assert.assertEquals(response.getStatusCode(),200);
        extentTest.log(Status.PASS,"Status code is 200");

        ResponseBody body = response.getBody();
        String validate = body.asString();
        //response time
        // not null
        //call in extent report
//Assertions
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertTrue(response.getBody() != null);
        extentTest.log(Status.PASS,"Response body is "+validate);
        System.out.println("Response is " +response.getTime());
        Assert.assertTrue(response.getTime()<5000);
        extentTest.log(Status.PASS,"Response time is within 5 seconds");

        Assert.assertTrue(validate.contains(userPayload.getUserName()));
        extentTest.log(Status.PASS,"Response Username matches with input given");

        Assert.assertTrue(validate.contains(userPayload.getFirstName()));
        extentTest.log(Status.PASS,"Response First Name matches with input given");

        Assert.assertTrue(validate.contains(userPayload.getLastName()));
        extentTest.log(Status.PASS,"Response Last Name matches with input given");

        Assert.assertTrue(validate.contains(userPayload.getEmail()));
        extentTest.log(Status.PASS,"Response Email matches with input given");

        Assert.assertTrue(validate.contains(userPayload.getPassword()));
        extentTest.log(Status.PASS,"Response Password matches with input given");

        System.out.println("************  "+this.userPayload.getUserName()+" is fetched **********");

    }

    @Test(priority=2)
    public void testGetUserByWrongName()
    {
        extentTest = extentReports.createTest("API GET Request Test with wrong paramenter", "GET request invalid data test");

        System.out.println("*************************{GET}****************************************");
        Response response=UserEndpoints.readUser("WrongUserName");
        response.then().log().all();
        Assert.assertTrue(response.getTime()<5000);
        extentTest.log(Status.PASS,"Response time is within 5 seconds");

        //extentTest.log(Status.PASS,"API did not return data for invalid parameter");
        ResponseBody body = response.getBody();
        String validate = body.asString();
        Assert.assertEquals(response.getStatusCode(),404);
        extentTest.log(Status.PASS,"Status is 404 as expected for invalid user input");

        extentTest.log(Status.PASS,"Response body is "+validate);
        Assert.assertTrue(response.getTime()<5000);
        extentTest.log(Status.PASS,"Response time is within 5 seconds");



    }


    @Test(priority = 3)
    public void testUpdateUserByName()
    {
        extentTest = extentReports.createTest("API Update Request Test", "Update data API");

        Map<String,Object> bodyParams=new HashMap<String,Object>();
        bodyParams.put("id",userPayload.getUserId());
        bodyParams.put("username",userPayload.getUserName());
        bodyParams.put("firstName",userPayload.getFirstName()+" is my first name");
        bodyParams.put("lastName",userPayload.getLastName()+" is my last name");
        bodyParams.put("email",userPayload.getEmail()+" is my email");
        bodyParams.put("password",userPayload.getPassword()+" is my password");
        bodyParams.put("phone",userPayload.getPhone()+" is my phone number");
        bodyParams.put("userStatus",1);
        String payload=new Gson().toJson(bodyParams);
        System.out.println("*************************{UPDATE}************************************");
        String uname1 = this.userPayload.getUserName();
        Response response=UserEndpoints.updateUser(uname1, payload);
        response.then().log().all();
        Response afterUpdateResponse=UserEndpoints.readUser(this.userPayload.getUserName());
        afterUpdateResponse.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("*********  "+this.userPayload.getUserName()+" is updated ************");
        extentTest.log(Status.PASS,"Update API working");
        ResponseBody body = response.getBody();
        String validate = body.asString();
        extentTest.log(Status.PASS,"Response body is "+validate);
        Assert.assertEquals(response.getStatusCode(),200);
        extentTest.log(Status.PASS,"Status code is 200");
        Assert.assertTrue(response.getTime()<5000);
        extentTest.log(Status.PASS,"Response time is within 5 seconds");

    }

    @Test(priority = 4)
    public void testDeleteUserByName()
    {
        extentTest = extentReports.createTest("API Delete Record", "Delete data API");

        System.out.println("*************************{DELETE}************************************");
        Response response=UserEndpoints.deleteUser(this.userPayload.getUserName());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        System.out.println("********  "+this.userPayload.getUserName()+" is deleted *************");
        extentTest.log(Status.PASS,"Delete API working");
        ResponseBody body = response.getBody();
        String validate = body.asString();
        extentTest.log(Status.PASS,"Response body is "+validate);
        Assert.assertEquals(response.getStatusCode(),200);
        extentTest.log(Status.PASS,"Status code is 200");
        Assert.assertTrue(response.getTime()<5000);
        extentTest.log(Status.PASS,"Response time is within 5 seconds");

    }


}


