package com.bdd.web.page;

import org.openqa.selenium.WebElement;
import web.com.bdd.base.Middleware;

public class GoogleConfigPage extends Middleware {

    public void buscar(String dato) {
        WebElement element = getElementInShadowRoot(GoogleConfigPaths.searchField, getDriver());
        sendKeysElement(element, dato);
    }

    public String getResultado() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getTextFromElementInShadowRoot(GoogleConfigPaths.result, getDriver());
    }

    public String obtenerCantidadOpciones() {
        //return getWebElementsInShadowRootByPosition(GoogleConfigPaths.opciones, 0, getDriver()).getAttribute("innerText");
        return getTextFromElementInShadowRootByPosition(GoogleConfigPaths.opciones, 2, getDriver());
    }
}

final class GoogleConfigPaths {
    protected static final String searchField = "settings-ui;cr-toolbar;cr-toolbar-search-field#search;div#searchTerm #searchInput";
    protected static final String result = "settings-ui;settings-main;settings-basic-page;settings-section;#header > h2 > span > span.search-highlight-hit";
    protected static final String opciones = "settings-ui;settings-menu::iron-selector>a";

}
