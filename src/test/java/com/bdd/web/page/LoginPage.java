package com.bdd.web.page;

import com.bdd.web.paths.LoginPath;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.com.bdd.base.Middleware;
import web.com.bdd.util.UtilWeb;

import static web.com.bdd.util.UtilWeb.getVariableOnSession;

@DefaultUrl("https://cert2.tlcbcp-cer.com/")
public class LoginPage extends Middleware {

    @FindBy(xpath = "//app-base")
    private WebElement appBase;
    @FindBy(xpath = "//body")
    private WebElement body;
    @FindBy(xpath = "//div[@id-auto='top-header-name']")
    private WebElement sessionPages;
    @FindBy(xpath = "//ntlc-loader/div")
    private WebElement loadPages;
    //Elementos X-Path
    LoginPath loginPath = new LoginPath();

    public void validarCargaPagina() {
        waitElement(body, 60);
    }

    public void clickTipoAcceso(String tipoAcceso) {
        generarEvidencia(getVariableOnSession("scenario"));

        waitElementFromJavaScript(appBase,loginPath.btnAccesoEmpresarial,120);
        waitElementIsNotVisible(loadPages, 60);

        if (tipoAcceso.contains("Acceso Empresarial")) {
            getElementoFromJavaScript(appBase, loginPath.btnAccesoEmpresarial).click();
        }
        if (tipoAcceso.contains("Credimas Negocio"))
            getElementoFromJavaScript(appBase, loginPath.btnAccesoCredimas).click();
    }

    public void ingresarTarjeta(String sTarjeta) {
        getElementoFromJavaScript(appBase, loginPath.inputSecondTarjeta).sendKeys(sTarjeta.substring(0, 2));
        getElementoFromJavaScript(appBase, loginPath.inputThreeTarjeta).sendKeys(sTarjeta.substring(2, 6));
        getElementoFromJavaScript(appBase, loginPath.inputFourTarjeta).sendKeys(sTarjeta.substring(6, 10));
    }

    public void ingresarCaptcha(String sCaptcha) {
        getElementoFromJavaScript(appBase, loginPath.inputCaptcha).sendKeys(sCaptcha);
    }

    public void clickIngresarOfficeBanking() {
        getElementoFromJavaScript(appBase, loginPath.btnLogin).click();
    }


    public void ingresarClaveInternet(String sClaveInternet) {
        writePassword(sClaveInternet);
    }

    protected void writePassword(String sClaveInternet) {
        for (int i = 0; i < sClaveInternet.length(); ++i) {
            String number = String.valueOf(sClaveInternet.charAt(i));
            String xpathNumber = "img[src*='/internet-login/images/keypad/keypad_" + number + ".svg']";
            getElementoFromJavaScript(appBase, xpathNumber).click();
        }
    }

    public void checkRecordarTarjeta() {
        getElementoFromJavaScript(appBase, loginPath.checkRecordar).click();
    }

    public void ingresarAlias(String sAlias) {
        getElementoFromJavaScript(appBase, loginPath.inputAlias).sendKeys(sAlias);
    }

    public void validoPantalla() {
        //waitUntilOfficebankigLoadingIsNotVisible();
        waitElementIsNotVisible(loadPages, 60);
        if (waitElementFromJavaScript(appBase, loginPath.btnMasTarde, 1)) {
            generarEvidencia(getVariableOnSession("scenario"));
            getElementoFromJavaScript(appBase, loginPath.btnMasTarde).click();
        }
        waitElementIsVisible(sessionPages, 60);
    }

}
