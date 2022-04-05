package com.bdd.web.step;

import com.bdd.web.page.BitbucketPage;
import ct.com.core.environment.ManageEnvironment;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.time.Duration;

public class BitbucketStep {

    private BitbucketPage page() {
        return new BitbucketPage();
    }

    @Step("Abrir pagina")
    public void openPage() throws Exception {
        WebDriverManager.setWebDriver(ManageEnvironment.getEnvironment());
        String url = UtilWeb.getStringEvironmentProperty(ManageEnvironment.getEnvironment(), "url.bitbucket");
        WebDriverManager.setUrl(url);
        Duration duration = Duration.ofSeconds(10);
        WebDriverManager.getWebDriver().manage().timeouts().implicitlyWait(duration);

    }

    @Step("Ingresa su información")
    public void writeData() {
        page().escribirUser("T1234");
        page().escribirPassword("A1234");
        page().clickLogin();
    }

    @Step("Valida el mensaje de error")
    public String validateMessageResult() {
        return page().getMessageError();
    }

}
