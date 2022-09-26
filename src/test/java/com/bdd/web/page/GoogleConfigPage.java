package com.bdd.web.page;

import org.openqa.selenium.WebElement;
import web.com.bdd.base.Middleware;

public class GoogleConfigPage extends Middleware {

    public void buscar(String dato) {
        WebElement element = getElementInShadowRoot(GoogleConfigPaths.searchField, getDriver());
        sendKeysElement(element, dato);
    }

    public String getBusqueda() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return getTextFromElementInShadowRoot(GoogleConfigPaths.searchLabel, getDriver());
    }

    public String obtenerResultado() {
        return getTextFromElementInShadowRoot(GoogleConfigPaths.result, getDriver());
    }
}

final class GoogleConfigPaths {

    protected static final String searchField = "settings-ui;cr-toolbar;cr-toolbar-search-field#search;div#searchTerm #searchInput";
    protected static final String searchLabel = "settings-ui;settings-main;settings-basic-page;settings-section[section=\"defaultBrowser\"];#header > h2 > span > span.search-highlight-hit";
    protected static final String result = "settings-ui;settings-main;settings-basic-page;settings-section[section=\"defaultBrowser\"]>settings-default-browser-page;div.cr-row.first>div.flex.cr-padded-text div.secondary";




}