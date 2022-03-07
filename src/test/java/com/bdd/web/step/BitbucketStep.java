package com.bdd.web.step;

import com.bdd.web.page.BitbucketPage;
import com.bdd.web.page.GooglePage;
import environment.ManageEnvironment;
import net.thucydides.core.annotations.Step;
import web.com.bdd.lib.WebDriverManager;
import web.com.bdd.util.UtilWeb;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class BitbucketStep {

    private BitbucketPage page() {
        return new BitbucketPage();
    }

    @Step("Abrir pagina")
    public void openPage() throws Exception {
        WebDriverManager.setWebDriver(ManageEnvironment.getEnvironment());
        String url = UtilWeb.getStringEvironmentProperty(ManageEnvironment.getEnvironment(), "url.demo");
        WebDriverManager.setUrl(url);
        WebDriverManager.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
