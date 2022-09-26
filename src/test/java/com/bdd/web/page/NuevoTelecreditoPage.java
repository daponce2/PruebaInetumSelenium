package com.bdd.web.page;

import com.bdd.Helper.DebugHelper;
import com.bdd.ImageToText;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import web.com.bdd.base.Middleware;
import web.com.bdd.util.UtilWeb;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class NuevoTelecreditoPage extends Middleware {

    String CAPTCHA = null;
    public WebElement txtTarjeta;

    public WebElement txtClave;

    public WebElement imgCaptcha;

    public WebElement txtCaptcha;

    public WebElement btnIngresar;


    /**
     * Método para ingresar Tarjeta y Clave
     */
    public void ingresarTarjetayClave(String sTarjeta, String sClaveInternet) throws IOException, InterruptedException {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Escribiendo tarjeta..");
        txtTarjeta = getDriver().findElement(By.tagName("app-base"));
        SearchContext shadowRootTarjeta = txtTarjeta.getShadowRoot();
        shadowRootTarjeta.findElement(By.name("card2")).sendKeys(sTarjeta);

        UtilWeb.logger(this.getClass()).log(Level.INFO, "Escribiendo clave de Internet..");
        for (int i = 0; i < sClaveInternet.length(); i++) {
            txtClave = getDriver().findElement(By.tagName("app-base"));
            SearchContext shadowRootClave = txtClave.getShadowRoot();
            String number = String.valueOf(sClaveInternet.charAt(i));
            String cssSelector = "img[src='https://ntlc-static.azureedge.net/internet-login/images/keypad/keypad_" + number + ".svg']";
            shadowRootClave.findElement(By.cssSelector(cssSelector)).click();
        }
        obtenerCaptcha();
        decodificarCaptcha();
    }

    /**
     * Metodos para Obtener y decodificar captcha
     */
    public void obtenerCaptcha() throws IOException {
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Escribiendo captcha..");
        imgCaptcha = getDriver().findElement(By.tagName("app-base"));
        SearchContext shadowRootCaptcha = imgCaptcha.getShadowRoot();
        WebElement shadowContect = shadowRootCaptcha.findElement(By.cssSelector("img[src^='data:image/png;base64,/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAyAKADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/']"));

        File captcha = shadowContect.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "\\captcha\\captcha.png";
        FileHandler.copy(captcha, new File(path));
    }

    public void decodificarCaptcha() throws InterruptedException {
        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("feb31fb8485ad7f28d4db118a9a20314");
        api.setFilePath("captcha/captcha.png");

        api.setSoftId(0);

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution().getText(), DebugHelper.Type.SUCCESS);
            CAPTCHA = api.getTaskSolution().getText();
        }
        escribirCaptcha(CAPTCHA);
    }

    public void escribirCaptcha(String sCaptcha) {
        txtCaptcha = getDriver().findElement(By.tagName("app-base"));
        SearchContext shadowRootCaptcha = txtCaptcha.getShadowRoot();
        shadowRootCaptcha.findElement(By.cssSelector("input[id-auto^='captcha']")).sendKeys(sCaptcha);
    }

    /**
     * Método para dar clic en el boton Ingresar
     */
    public void clicBotonIngresar() {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        UtilWeb.logger(this.getClass()).log(Level.INFO, "Clic en el boton Ingresar..");
        btnIngresar = getDriver().findElement(By.tagName("app-base"));
        SearchContext shadowRootBtnIngresar = btnIngresar.getShadowRoot();
        shadowRootBtnIngresar.findElement(By.cssSelector("p[class='paragraph-md bcp-font-demi white']")).click();
    }
}


