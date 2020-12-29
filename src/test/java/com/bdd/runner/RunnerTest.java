package com.bdd.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.util.logging.Level;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        junit = {"--step-notifications"},
        glue = {"com.bdd.web.stepdefinition"},
        tags = {"@DEMO01"}
)

public class RunnerTest {
    @BeforeClass
    public static void beforeClass() {

        UtilWeb.logger(RunnerTest.class).log(Level.INFO,"Execute Test");
    }

    @AfterClass
    public static void afterClass() {
        //Se detiene el driver.
        WebDriverManager.stopWebDriver();
    }

}
