import com.aventstack.extentreports.ExtentTest;
import com.sun.jdi.Method;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.*;


public class runner extends Utilities {

    public static void main(String[] args) throws InterruptedException, IOException {
       Utilities obj = new Utilities();
      /*  ExtentTest extentTest = null;

       */
        tests runTests = new tests();


             ArrayList<String> testList = (ArrayList<String>) obj.readExcel("C://Users//sandeep.s8//IdeaProjects//test//testEngine.xls");
             System.out.println(testList.get(0));
                       // place holder for runner class

        XmlSuite suite = new XmlSuite();
        suite.setName("My Suite");
        XmlTest test = new XmlTest(suite);
        test.setName("My Test");

        List<XmlClass> classes = new ArrayList<XmlClass>();
        XmlClass xmlclass = new XmlClass("tests");
        List<XmlInclude> includedMethods = new ArrayList<XmlInclude>();

        for (int i = 0 ; i < testList.size();i++) {
            includedMethods.add(new XmlInclude(testList.get(i)));
        }
        xmlclass.setIncludedMethods(includedMethods);
        classes.add(xmlclass);


        test.setXmlClasses(classes) ;
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();
    }
}