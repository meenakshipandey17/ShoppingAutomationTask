package com.shopping.cart.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@RunWith( Cucumber.class )
@CucumberOptions (
        dryRun = false,
        strict = true,
        tags = {},
        features = "src/test/resources/features",
        glue = "com.shopping.cart/stepDefinitions",
        monochrome = false,
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-html-reports/CucumberTestReport.json"}
)

public class RunCucumberTest {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass( alwaysRun = true )
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test( description = "Runs Cucumber Feature Files", dataProvider = "features" )
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass( alwaysRun = true )
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
}
