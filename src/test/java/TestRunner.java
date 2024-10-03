import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import org.testng.annotations.AfterSuite;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/*
@CucumberOptions( tags = "", features = {"src/test/resources/features/"}, glue = {"definitions"},
        plugin = {})
public class cucmberRunner extends AbstractTestNGCucumberTests {

}
*/



@RunWith(Cucumber.class)
@CucumberOptions(features={"src//test//resources//features"}
        ,glue={"definitions"}
        ,plugin = {"pretty",
        "html:target/report/cucumber.html",
        "json:target/report/cucumber.json"
}        ,monochrome=true

)

public class TestRunner{





}