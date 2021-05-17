package com.bdd.runner;

import com.bdd.Constants;
import com.bdd.Util;
import environment.ManageEnvironment;
import environment.SystemEnvironmentVariables;
import io.cucumber.junit.CucumberOptions;
import io.restassured.response.Response;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import web.com.bdd.jxray.dom.JXrayServiceDom;
import web.com.bdd.jxray.help.HelperCredentials;
import web.com.bdd.util.UtilWeb;

import java.util.logging.Level;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"json:target/build/cucumber.json"},
        features = {"src/test/resources/features"},
        stepNotifications = true,
        glue = {"com.bdd.web.stepdefinition"},
        tags = "@Google"
)

public class RunnerTest {

    @BeforeClass
    public static void beforeExecution() {
        UtilWeb.logger(RunnerTest.class).info("BEFORE >>>");
        ManageEnvironment.setEnvironmentVariables(SystemEnvironmentVariables.createEnvironmentVariables());
    }

    @AfterClass
    public static void afterExecution() {
        UtilWeb.logger(RunnerTest.class).info("AFTER >>>");

        String cucumberPath = System.getProperty("user.dir") + "/target/build/cucumber.json";
        boolean isJiraOn = Boolean.parseBoolean(Util.getContentEvironmentVariable(ManageEnvironment.getEnvironmentVariables(), Constants.JXRAY_EVIDENCE));

        if (isJiraOn) {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
            JXrayServiceDom jXrayServiceDom = new JXrayServiceDom();
            Response response = jXrayServiceDom.importTestResultExecution(
                    new HelperCredentials(ManageEnvironment.getEnvironmentVariables()).getPathResource(),
                    cucumberPath,
                    new HelperCredentials(ManageEnvironment.getEnvironmentVariables()).getJXrayUser(),
                    new HelperCredentials(ManageEnvironment.getEnvironmentVariables()).getJXrayPassword());

            response.then().assertThat().statusCode(200);

        } else {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
        }

    }

}
