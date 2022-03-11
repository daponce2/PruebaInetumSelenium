package com.bdd.runner;

import ct.com.core.environment.SystemEnvironmentVariables;
import ct.com.core.jxray.dom.JXrayProperties;
import ct.com.core.jxray.dom.JXrayServiceDom;
import ct.com.core.jxray.help.JXrayHelperCredentials;
import io.cucumber.junit.CucumberOptions;
import io.restassured.response.Response;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.util.logging.Level;

import static ct.com.core.environment.ManageEnvironment.setEnvironment;
import static ct.com.core.environment.ManageEnvironment.getEnvironment;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        stepNotifications = true,
        glue = {"com.bdd.web.stepdefinition"},
        tags = "@bitbucket"
)

public class RunnerTest {

    @BeforeClass
    public static void beforeExecution() {
        UtilWeb.logger(RunnerTest.class).info("BEFORE >>>");
        setEnvironment(SystemEnvironmentVariables.createEnvironmentVariables());
    }

    @AfterClass
    public static void afterExecution() {
        UtilWeb.logger(RunnerTest.class).info("AFTER >>>");

        if (WebDriverManager.getWebDriver() != null)
            WebDriverManager.stopWebDriver();

        String cucumberJsonPath = System.getProperty("user.dir") + "/target/build/cucumber.json";
        boolean isJiraOn = UtilWeb.getBooleanEvironmentProperty(getEnvironment(), JXrayProperties.JXRAY_EVIDENCE);

        if (isJiraOn) {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
            JXrayServiceDom jXrayServiceDom = new JXrayServiceDom();
            Response response = jXrayServiceDom.importTestResultExecutionBasic(
                    new JXrayHelperCredentials(getEnvironment()).getJiraHost(),
                    cucumberJsonPath,
                    new JXrayHelperCredentials(getEnvironment()).getAPIToken());
            response.then().assertThat().statusCode(200);

        } else {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
        }

    }

}
