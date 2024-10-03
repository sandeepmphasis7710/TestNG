package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Properties;

public class Utilities1 {


    // Method to read excel and decide which tests to run based on the Yes or No Flag
    public AbstractList<String> readExcel(String excelPath) throws IOException {
        Runtime.getRuntime().exec(
                "cmd /c taskkill /f /im excel.exe");
        File file = new File(excelPath);
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheet("Data");
        HSSFRow row;
        HSSFCell cell;
        HSSFCell cell1;
        String flag;
        //System.out.println(sheet.getPhysicalNumberOfRows());
        int k = sheet.getPhysicalNumberOfRows();
        ArrayList<String> tests = new ArrayList<String>(); // Create an ArrayList object
        String testName;
        // System.out.println(k);

        for (int i = 0; i < k; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(2);
            cell1 = row.getCell(1);
            flag = cell.getStringCellValue();
            if (flag.equalsIgnoreCase("yes")) {

                // System.out.println(flag);
                testName = cell1.getStringCellValue();
                tests.add(testName);

            }
        }
        return tests;

    }

    public void generate_extentReports () {

        ExtentSparkReporter extentSparkReporter;
        ExtentReports extentReports;
        ExtentTest extentTest;
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);


        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public String returnConfig(String key) throws IOException {
        String configFilePath = "C:/Users/sandeep.s8/IdeaProjects/test/config.properties";
        FileInputStream propsInput = new FileInputStream(configFilePath);
        Properties prop = new Properties();
        prop.load(propsInput);
        return prop.getProperty(key);

    }
    public String readObject(String objectName,String objLocType) throws IOException {
        Runtime.getRuntime().exec(
                "cmd /c taskkill /f /im excel.exe");
        File file = new File("C:/Users/sandeep.s8/IdeaProjects/test/objects.xls");
        FileInputStream inputStream = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheet("Login_Page");
        HSSFRow row;
        HSSFCell cell;
        HSSFCell cell1 = null;
        String objName;
        //System.out.println(sheet.getPhysicalNumberOfRows());
        int k = sheet.getPhysicalNumberOfRows();
        ArrayList<String> tests = new ArrayList<String>(); // Create an ArrayList object
        String objValue = "";
        // System.out.println(k);

        for (int i = 0; i < k; i++) {
            row = sheet.getRow(i);
            cell = row.getCell(0);
            switch (objLocType)
            {

                case "xpath":
                    cell1 =   row.getCell(1);
                    break;

                case "css":
                    cell1 =   row.getCell(2);
                    break;


                case "id":
                    cell1 =   row.getCell(3);
                    break;

            }

            // cell1 = row.getCell(1);

            objName = cell.getStringCellValue();
            if (objName.equalsIgnoreCase(objectName)) {

                // System.out.println(flag);
                objValue = cell1.getStringCellValue();
                System.out.println("cell value is "+objValue);
                break;


            }
        }
        return objValue;

    }

}


