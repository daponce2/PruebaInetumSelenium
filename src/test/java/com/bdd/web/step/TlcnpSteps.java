package com.bdd.web.step;

import com.bdd.web.page.TlcnpPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import web.com.bdd.lib.WebDriverManager;

import java.io.IOException;


public class TlcnpSteps extends ScenarioSteps {

    private TlcnpPage loginPage;
    private String cuentaDestino;
    private String cuentaAbono;
    private String monedaSigno;
    private String CuentaOrigen;

    private EnvironmentVariables environmentVariables;

    @Step("Cargar pagina de TLCNP")
    public void cargarPaginaTLCNp() throws Exception {
        loginPage.setDriver(WebDriverManager.setWebDriverFromEnvironment(environmentVariables));
        loginPage.open();
        loginPage.getDriver().manage().window().maximize();
    }

    @Step("Clic en Operaciones Monetarias")
    public void clicOperacionesMonetarias() {
        loginPage.clicOperacionesMonetarias();
    }

    @Step("Clic en trasnferencias")
    public void clicTrasnferencias() {
        loginPage.clicTrasnferencias();
    }

    @Step("Clic en Cuentas BCP")
    public void cliccuentasBCP() {
        loginPage.cliccuentasBCP();
    }

    @Step("Clic en Cuentas propias")
    public void clicCuentasPropias() {
        loginPage.clicCuentasPropias();
    }

    @Step("Clic en Cuentas Terceros")
    public void clicCuentasTerceros() {
        loginPage.clicCuentasTerceros();
    }


    @Step("Clic en Enviar a Firmar")
    public void enviarAFirmar(String accion) {
        loginPage.enviarAFirmar(accion);
    }

    @Step("Clic en continuar")
    public void clicbtnContinuar() {
        loginPage.clicbtnContinuar();
    }

    @Step("Escribir tarjeta")
    public void escribirTarjeta(String sTarjeta, String clave) {
        loginPage.escribirTarjeta(sTarjeta, clave);
    }

    @Step("selecciono Tipo de Tarjeta")
    public void seleccionoTipoTarjeta(String stipo) {
        loginPage.seleccionoTipoTarjeta(stipo);
    }


    @Step("Selecciono num cuenta")
    public void selecciononumCuenta(String num) {
        String ctaOrigen = loginPage.selecciononumCuenta(num);
        this.cuentaAbono = num;
        this.CuentaOrigen = ctaOrigen;
    }

    @Step("Guardar numero de operacion")
    public void guardarNumeropOP(String num, String monto) throws IOException {
        loginPage.guardarNumeropOP(num, this.cuentaDestino, this.cuentaAbono, monto, this.monedaSigno);
    }

    @Step("Guardar numero de operacion Externo")
    public void guardarNumeropOPExterno(String num, String monto, String cuentaDestino) throws IOException {
        loginPage.guardarNumeropOP(num, cuentaDestino, this.cuentaAbono, monto, this.monedaSigno);
    }


    @Step("Selecciono datos cuenta destino")
    public void seleccionoDatosCuentaDestino(String numDestino, String monto, String moneda) {
        if (this.cuentaDestino.length() == 0)
            this.monedaSigno = loginPage.seleccionoDatosCuentaDestino(numDestino, monto, this.cuentaDestino);
        else
            this.monedaSigno = loginPage.seleccionoDatosCuentaDestinoExistente(numDestino, monto, this.cuentaDestino, moneda);
    }

    @Step("Selecciono cuenta segun flag")
    public void seleccionarCuentaSegunFlag(String cuentaAbono, Boolean mismaCuenta, String cuentaDestino) {
        if (cuentaDestino.length() == 0)
            this.cuentaDestino = loginPage.seleccionoDatosCuentaDestinoSegunFlag(cuentaAbono, mismaCuenta);
        else
            this.cuentaDestino = cuentaDestino;
    }

    @Step("Selecciono datos cuenta destino a terceros")
    public void seleccionoDatosCuentaDestinoTipo(String cuentaDestino, String monto, String moneda, String tipo, Boolean mismaMoneda) {
        if (cuentaDestino.length() == 0)
            this.monedaSigno = loginPage.seleccionoDatosCuentaDestinoTipo(cuentaDestino, monto, moneda, tipo,
                    cuentaDestino, mismaMoneda, this.CuentaOrigen);
        else
            this.monedaSigno = loginPage.seleccionoDatosCuentaDestinoTipoBody(cuentaDestino, monto, moneda, tipo);

    }


}
