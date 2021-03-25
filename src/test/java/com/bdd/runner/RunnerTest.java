package com.bdd.runner;

import com.bdd.Constants;
import com.bdd.Util;
import cucumber.api.CucumberOptions;
import io.restassured.response.Response;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
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
        junit = {"--step-notifications"},
        glue = {"com.bdd.web.stepdefinition"},
        tags = {"@Google"}
)

public class RunnerTest {

    private static EnvironmentVariables environmentVariables;

    @BeforeClass
    public static void beforeExecution() {
        environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    }

    @AfterClass
    public static void afterExecution() {
        //Ubicacion del archivo de resultado cucumber.json
        String cucumberPath = System.getProperty("user.dir") + "/target/build/cucumber.json";
        UtilWeb.logger(RunnerTest.class).info("afterExecution()");
        boolean isJiraOn = Boolean.parseBoolean(Util.getContentEvironmentVariable(environmentVariables, Constants.JXRAY_EVIDENCE));

        if (isJiraOn) {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
            JXrayServiceDom jXrayServiceDom = new JXrayServiceDom();
            Response response = jXrayServiceDom.importTestResultExecution(
                    new HelperCredentials(environmentVariables).getPathResource(),
                    cucumberPath,
                    new HelperCredentials(environmentVariables).getJXrayUser(),
                    new HelperCredentials(environmentVariables).getJXrayPassword());

            response.then().assertThat().statusCode(200);

        } else {
            UtilWeb.logger(RunnerTest.class).log(Level.INFO, "Actualizar resultados en JiraXray: {0}", isJiraOn);
        }

    }

}
