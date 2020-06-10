package web.com.bdd.generic;

import org.openqa.selenium.NoSuchElementException;
import web.com.bdd.base.BaseDom;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverDOM extends BaseDom {

    private void JSClickElement(WebElementFacade element) {
        JavascriptExecutor ex = (JavascriptExecutor) getDriver();
        ex.executeScript("arguments[0].click();", element);
    }

    protected void clickElement(WebElementFacade element) {
        element.click();
    }

    protected void waitForElementAndClick(WebElementFacade element, int timeOnSeconds) {
        webDriverWait(element, timeOnSeconds).click();
    }

    protected String getTextFromElement(WebElementFacade element) {
        return element.getText();
    }

    protected String waitForElementoAndGetText(WebElementFacade element, int timeOnSeconds) {
        return element.waitUntilVisible().getText();
    }

    protected void sendKeyElement(WebElementFacade webElement, String value) {
        webElement.sendKeys(value);
    }

    protected void waitForElementAndSendKey(WebElementFacade element, int timeOnSeconds, String value) {
        webDriverWait(element, timeOnSeconds).sendKeys(value);
    }

    protected boolean isElementPresent(WebElementFacade webElement) {
        try {
            webElement.isPresent();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitForElement(WebElementFacade element, int timeOnSeconds) {
        webDriverWait(element, timeOnSeconds);
    }

    protected void clickElementInAList(List<WebElementFacade> listElement, String value) {
        waitUntilListHasElements(listElement, 10);
        for (WebElementFacade element : listElement) {
            System.out.println("xx> Encontrado: " + element.getText() + " - Buscado: " + value);
            if (element.getText().equalsIgnoreCase(value)) {
                element.click();
                break;
            }
        }
    }

    protected void selectOptionFromComboListAndClick(WebElement selectOption, String optionValue) {
        Select select = new Select(selectOption);
        for (WebElement webElement : select.getOptions()) {
            if (webElement.getText().contains(optionValue)) {
                webElement.click();
                break;
            }
        }
    }

    protected void writePasswordCharByChart(String sClaveInternet) {
        for (int i = 0; i < sClaveInternet.length(); i++) {
            String number = String.valueOf(sClaveInternet.charAt(i));
            String xpathNumber = "//*[@src='assets/img/login/keypad/keypad_" + number + ".svg']";
            getDriver().findElement(By.xpath(xpathNumber)).click();
        }
    }

    protected void selectOnCustomBcpDropdown(String searchedValue, WebElementFacade dropdownParent, List<WebElementFacade> dropdownOptions) {
        waitUntilVisible(dropdownParent, 20);
        clickElement(dropdownParent);
        waitUntilListHasElements(dropdownOptions, 10);
        Assert.assertNotNull(dropdownOptions);
        Assert.assertFalse(dropdownOptions.isEmpty());
        for (WebElementFacade optionElement : dropdownOptions) {
            if (optionElement.getText().contains(searchedValue) || optionElement.getText().equalsIgnoreCase(searchedValue)) {
                clickElement(optionElement);
                return;
            }
        }
    }


    protected void waitUntilReadyAndClick(WebElement element, int timeOnSeconds) {
        new WebDriverWait(getDriver(), timeOnSeconds).until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOf(element),
                        ExpectedConditions.elementToBeClickable(element)
                )
        );
        element.click();
    }

    protected void waitUntilVisible(WebElementFacade element, int timeOutOnSeconds) {
        element.waitUntilVisible();
        do {
            implicitWait(1);
            org.springframework.util.Assert.notNull(element, "El elemento a esperar no ha sido declarado. Es nulo.");
            if (element.isCurrentlyVisible() && element.isDisplayed() && element.isPresent()) {
                implicitWait(1);
                return;
            }
            implicitWait(1);
            timeOutOnSeconds--;
        } while (timeOutOnSeconds > 0);
    }

    protected void waitUntilEnabled(WebElementFacade element, int timeOutOnSeconds) {
        element.waitUntilVisible();
        do {
            org.springframework.util.Assert.notNull(element, "El elemento a esperar no ha sido declarado. Es nulo.");
            if (element.isCurrentlyVisible() && element.isDisplayed() && element.isPresent() && element.isCurrentlyEnabled()) {
                implicitWait(1);
                return;
            }
            implicitWait(1);
            timeOutOnSeconds--;
        } while (timeOutOnSeconds > 0);
    }

    protected void waitUntilListHasElements(List<WebElementFacade> elementsList, int timeOutOnSeconds) {
        do {
            if (elementsList != null && !elementsList.isEmpty()) {
                waitUntilVisible(elementsList.get(0), timeOutOnSeconds);
                return;
            }
            implicitWait(1);
            timeOutOnSeconds--;
        } while (timeOutOnSeconds > 0);
        System.out.println("No se encontraron elementos en la lista.");
    }

    protected boolean isElementClickable(WebElementFacade webElement) {
        try {
            webElement.isClickable();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void scrollToElement(WebElementFacade element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
    }

    /**
     * Te posiciona visualmente sobre el elemento indicado
     *
     * @param element elemento de tipo de WebElement
     */
    protected void scrollByJavaScriptToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     * Busca un valor (ignorando mayúsculos y minúsculas)
     * que coincida con el texto de alguno de los elementos enviados en la lista.
     *
     * @return la posiciónbaseweb del elemento que contiene el texto buscado. Retorna -1 cuando no se encuentra el elemento.
     */
    protected Integer findElementInAList(List<WebElementFacade> listElement, String value) {
        waitUntilListHasElements(listElement, 10);
        Assert.assertNotNull(listElement);
        int i = 0;
        for (WebElementFacade element : listElement) {
            if (element.getText().equalsIgnoreCase(value)) {
                return i;
            }
            i++;
        }
        return -1;
    }


    //SE AGREGO DE EL MERGE CON EL FRAMEWORK 1

    protected void typeOnElement(WebElementFacade webElement, String value) {
        webElement.type(value);
    }

    /* Retorna un texto, si el elemento es de etiqueta tipo input.
    @element xpath*/

    /**
     * Entrega el valor de una etiqueta tipo "Input"
     *
     * @param element elemento de tipo de WebElement
     * @return texto, tipo string
     */
    protected String getAttributeValue(WebElementFacade element) {
        return element.getAttribute("value");
    }

    protected Boolean IsPresentElementInList(List<WebElementFacade> listElement, String value) {
        waitUntilListHasElements(listElement, 10);
        for (WebElementFacade element : listElement) {
            System.out.println("xx> Encontrado: " + element.getText() + " - Buscado: " + value);
            if (element.getText().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verifyElementForAlist(List<WebElementFacade> listElement, String producto) {
        Boolean existe = false;
        for (WebElementFacade element : listElement) {
            if (element.getText().equals(producto)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    /**
     * Valida si el elemento ya esta visible durante un tiempo maximo establecido.
     *
     * @param element          elemento de tipo de WebElement
     * @param timeOutOnSeconds tiempo en segundos, expresado en numeros enteros
     * @return verdadero, si el elemento esperado si esta visible
     */
    protected boolean waitElementIsVisible(WebElementFacade element, int timeOutOnSeconds) {
        boolean value = false;
        for (int c = 0; c <= timeOutOnSeconds; c++) {
            try {
                Thread.sleep(1000);
                value = element.isDisplayed();
                break;
            } catch (NoSuchElementException | InterruptedException e) {
            }
        }
        return value;
    }

    /**
     * Valida si el elemento ya no es visible durante un tiempo maximo establecido.
     *
     * @param element          elemento de tipo de WebElement
     * @param timeOutOnSeconds tiempo en segundos, expresado en numeros enteros
     * @return verdadero, si el elemento esperado no esta visible
     */
    protected boolean waitElementIsNotVisible(WebElementFacade element, int timeOutOnSeconds) {
        boolean found = false;
        for (int c = 0; c <= timeOutOnSeconds; c++) {
            try {
                Thread.sleep(1000);
                element.isDisplayed();
                if (c == timeOutOnSeconds) {
                    System.out.println("Tiempo vencido, no se espero que se oculte el elemento");
                }
            } catch (Throwable e) {
                found = true;
                break;
            }
        }
        return found;
    }

}