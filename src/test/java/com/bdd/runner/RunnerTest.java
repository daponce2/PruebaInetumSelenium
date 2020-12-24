package com.bdd.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import web.com.bdd.lib.WebDriverManager;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/build/cucumber-html-report", "pretty:target/build/cucumber-pretty.txt"
        , "json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        junit = {"--step-notifications"},
        glue = {"com.bdd.web.stepdefinition"},
        tags = {"@DEMO01"}
)
public class RunnerTest {


    @AfterClass
    public static void afterClass(){
        //Se detiene el driver.
        WebDriverManager.stopWebDriver();
    }

}
