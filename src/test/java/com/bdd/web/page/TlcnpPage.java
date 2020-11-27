package com.bdd.web.page;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import web.com.bdd.base.Middleware;

import java.io.IOException;
import java.util.List;

import static com.bdd.web.util.Util.getIndiceSegunNumeroCuenta;
import static web.com.bdd.util.UtilWeb.createResponseFile;
import static web.com.bdd.util.UtilWeb.createResponseFileDataGenerate;

@DefaultUrl("http://ptbiewasc02:9082/tlcnp/")
public class TlcnpPage extends Middleware {


    @FindBy(xpath = "//a[contains(text(),'Mapa del sitio')]")
    private WebElementFacade btnAfiliar;
    @FindBy(xpath = "//input[@id='secondCard']")
    private WebElementFacade secondCard;
    @FindBy(xpath = "//input[@id='thirdCard']")
    private WebElementFacade thirdCard;
    @FindBy(xpath = "//input[@id='fourthCard']")
    private WebElementFacade fourthCard;
    @FindBy(xpath = "//frame[@src='/tlcnp/index.do']")
    private WebElementFacade frame;
    @FindBy(xpath = "//span[@id='tecla0']")
    private WebElementFacade tecla1;
    @FindBy(xpath = "//img[@id='btnEnter']")
    private WebElementFacade btnEnter;
    @FindBy(xpath = "//div[contains(text(),'Operaciones monetarias')]")
    private WebElementFacade operacionesMonetarias;
    @FindBy(xpath = "(//div[contains(text(),'Transferencias')])[1]")
    private WebElementFacade transferencias;
    @FindBy(xpath = "(//div[contains(text(),'A cuentas BCP')])[1]")
    private WebElementFacade cuentasBCP;
    @FindBy(xpath = "(//div[contains(text(),'A cuentas propias')])[1]")
    private WebElementFacade cuentasPropias;
    @FindBy(xpath = "(//div[contains(text(),'A cuentas de terceros')])[1]")
    private WebElementFacade cuentasTerceros;
    @FindBy(xpath = "//select[@name='sourceAccountNumber']")
    private WebElementFacade selectCuenta;
    @FindBy(xpath = " //select[@name='sourceAccountNumber']/option")
    private List<WebElementFacade> listOpcionesCuentas;

    @FindBy(xpath = "//select[@name='destAccountNumber']")
    private WebElementFacade selectCuentaDestino;
    @FindBy(xpath = " //select[@name='destAccountNumber']/option")
    private List<WebElementFacade> listOpcionesCuentasDestino;
    @FindBy(xpath = "//select[@name='cdCurrency']")
    private WebElementFacade selectMoneda;
    @FindBy(xpath = " //select[@name='cdCurrency']/option")
    private List<WebElementFacade> listOpcionesMoneda;
    @FindBy(xpath = "//input[@name='amount']")
    private WebElementFacade montoDestino;
    @FindBy(xpath = "//input[@value='Continuar']")
    private WebElementFacade btnContinuar;
    @FindBy(xpath = "//select[@name='cardType']")
    private WebElementFacade selectTipoTarjeta;
    @FindBy(xpath = " //select[@name='cardType']/option")
    private List<WebElementFacade> listOpcionesTipoTarjeta;
    @FindBy(xpath = "//input[@name='destAccountNumber']")
    private WebElementFacade nroCuenta;


    @FindBy(xpath = "//select[@name='destAccountType']")
    private WebElementFacade selectCuentaDestinoTipo;
    @FindBy(xpath = " //select[@name='destAccountType']/option[@value='C']")
    private WebElementFacade opcionCuentaCorrienteMaestra;
    @FindBy(xpath = " //select[@name='destAccountType']/option[@value='A']")
    private WebElementFacade opcionCuentaAhorro;
    @FindBy(xpath = " (//div[@id='printContent']/table/tbody/tr/td)[5]")
    private WebElementFacade txtNumeroOperacion;


    public void clicOperacionesMonetarias() {
        waitForElementAndClick(operacionesMonetarias, 60);
    }

    public void clicTrasnferencias() {
        waitForElementAndClick(transferencias, 60);

    }

    public void cliccuentasBCP() {
        waitForElementAndClick(cuentasBCP, 60);

    }

    public void clicCuentasPropias() {
        waitForElementAndClick(cuentasPropias, 60);

    }

    public void clicCuentasTerceros() {
        waitForElementAndClick(cuentasTerceros, 60);

    }

    public void enviarAFirmar(String accion) {

        getDriver().findElement(By.xpath("//input[@value='" + accion + "']")).click();
    }


    public void clicbtnContinuar() {
        waitForElementAndClick(btnContinuar, 60);

    }


    public String seleccionoDatosCuentaDestinoSegunFlag(String num, Boolean mismaNoneda) {
        String indiceParaMoneda = "";
        String numeroCuenta = "";
        indiceParaMoneda = getIndiceSegunNumeroCuenta(num);
        if (!mismaNoneda) {
            indiceParaMoneda = getIndiceSegunNumeroCuenta(num);
            if (indiceParaMoneda.equals("1")) {
                indiceParaMoneda = "0";
            } else {
                if (indiceParaMoneda.equals("0")) {
                    indiceParaMoneda = "1";
                }
            }
        } else {
            indiceParaMoneda = getIndiceSegunNumeroCuenta(num);
        }

        for (WebElementFacade elemento : listOpcionesCuentasDestino) {
            String cuentaElemento = elemento.getText();
            if (!cuentaElemento.contains(num) && !cuentaElemento.equals("Seleccione...")) {
                if (getIndiceSegunNumeroCuenta(cuentaElemento).equals(indiceParaMoneda)) {
                    numeroCuenta = elemento.getText();
                    break;
                }
            }

        }
        return numeroCuenta;
    }

    public String seleccionoDatosCuentaDestino(String num, String monto, String cuentaDesttino) {


        waitForElementAndClick(selectCuentaDestino, 60);
        String moneda = "";

        if (num.trim().length() > 0) {
            for (WebElementFacade elemtno : listOpcionesCuentasDestino) {
                if (elemtno.getText().contains(num)) {
                    elemtno.click();
                    break;
                }

            }
        } else {
            listOpcionesCuentasDestino.get(listOpcionesCuentasDestino.size() - 1).click();
        }


        waitForElementAndClick(selectMoneda, 60);

        if (getIndiceSegunNumeroCuenta(cuentaDesttino).equals("0"))
            moneda = "S/";
        else
            moneda = "US$";

        for (WebElementFacade elemtno : listOpcionesMoneda) {
            if (elemtno.getText().contains(moneda)) {
                elemtno.click();
                break;
            }

        }

        montoDestino.sendKeys(monto);
        return moneda;
    }

    public String seleccionoDatosCuentaDestinoExistente(String num, String monto, String cuentaDesttino, String moneda) {


        waitForElementAndClick(selectCuentaDestino, 60);

        if (num.trim().length() > 0) {
            for (WebElementFacade elemtno : listOpcionesCuentasDestino) {
                if (elemtno.getText().contains(num)) {
                    elemtno.click();
                    break;
                }

            }
        } else {
            listOpcionesCuentasDestino.get(listOpcionesCuentasDestino.size() - 1).click();
        }


        waitForElementAndClick(selectMoneda, 60);


        for (WebElementFacade elemtno : listOpcionesMoneda) {
            if (elemtno.getText().contains(moneda)) {
                elemtno.click();
                break;
            }

        }

        montoDestino.sendKeys(monto);
        return moneda;
    }

    public String seleccionoDatosCuentaDestinoTipo(String num, String monto, String moneda, String tipo, String cuentaAbono, Boolean mismaMoneda, String ctaOrigenNULL) {
        waitForElementAndClick(selectCuentaDestinoTipo, 60);
        if (tipo.contains("Cuenta Corriente / Maestra")) {
            opcionCuentaCorrienteMaestra.click();
        }
        if (tipo.contains("Cuenta Ahorros")) {
            opcionCuentaAhorro.click();
        }
        //Agregar cuenta

        waitForElementAndSendKey(nroCuenta, 60, num.replace("-", ""));

        waitForElementAndClick(selectMoneda, 60);
        if (cuentaAbono == null || cuentaAbono == "")
            cuentaAbono = ctaOrigenNULL;
        if (getIndiceSegunNumeroCuenta(cuentaAbono).equals("0")) {
            moneda = "S/";
        } else {
            moneda = "US$";
        }

        for (WebElementFacade elemtno : listOpcionesMoneda) {
            if (elemtno.getText().contains(moneda)) {
                elemtno.click();
                break;
            }

        }

        montoDestino.sendKeys(monto);
        return moneda;

    }

    public String seleccionoDatosCuentaDestinoTipoBody(String num, String monto, String moneda, String tipo) {
        waitForElementAndClick(selectCuentaDestinoTipo, 60);
        if (tipo.contains("Cuenta Corriente / Maestra")) {
            opcionCuentaCorrienteMaestra.click();
        }
        if (tipo.contains("Cuenta Ahorros")) {
            opcionCuentaAhorro.click();
        }
        //Agregar cuenta

        waitForElementAndSendKey(nroCuenta, 60, num.replace("-", ""));

        waitForElementAndClick(selectMoneda, 60);


        for (WebElementFacade elemtno : listOpcionesMoneda) {
            if (elemtno.getText().contains(moneda)) {
                elemtno.click();
                break;
            }

        }

        montoDestino.sendKeys(monto);
        return moneda;

    }


    public String selecciononumCuenta(String num) {
        waitForElementAndClick(selectCuenta, 60);
        String numeroOrigenExterno = "";
        if (num.trim().length() > 0) {
            for (WebElementFacade elemtno : listOpcionesCuentas) {
                if (elemtno.getText().contains(num)) {
                    elemtno.click();
                    break;
                }

            }
        } else {
            for (WebElementFacade elemtno : listOpcionesCuentas) {
                if (!elemtno.getText().contains("Seleccione...")) {
                    numeroOrigenExterno = elemtno.getText();
                    elemtno.click();
                    break;
                }

            }

        }
        return numeroOrigenExterno;

    }

    public void guardarNumeropOP(String num, String cuentadestino, String cuentaabono, String monto, String monedaSigno) throws IOException {

        createResponseFileDataGenerate("transferencias",
                "txt", num, txtNumeroOperacion.getText(),
                cuentadestino, cuentaabono, monto, monedaSigno);

    }

    public void seleccionoTipoTarjeta(String stipo) {
        getDriver().switchTo().frame(frame);
        waitForElementAndClick(selectTipoTarjeta, 60);
        for (WebElementFacade elemtno : listOpcionesTipoTarjeta) {
            if (elemtno.getText().contains(stipo)) {
                elemtno.click();
                break;
            }

        }


    }

    public void escribirTarjeta(String sTarjeta, String clave) {


        secondCard.sendKeys(sTarjeta.substring(0, 2));
        thirdCard.sendKeys(sTarjeta.substring(2, 6));
        fourthCard.sendKeys(sTarjeta.substring(6, 10));

        tecla1.click();
        tecla1.click();
        tecla1.click();
        tecla1.click();
        tecla1.click();
        tecla1.click();

        btnEnter.click();


    }

}

