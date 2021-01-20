package com.bdd.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.util.logging.Level;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"html:target/build/cucumber-html-report", "pretty:target/build/cucumber-pretty.txt"
        , "json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        junit = {"--step-notifications"},
        glue = {"com.bdd.web.stepdefinition"},
        tags = {"@Google"}
)
public class RunnerTest {

    @BeforeClass
    public static void beforClass(){
        UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Nothing to do");
    }

    @AfterClass
    public static void afterClass(){
        UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Deteniendo driver...");
        WebDriverManager.stopWebDriver();
    }

}
