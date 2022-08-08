package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.Callable;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait2;
    protected static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Ronal\\IdeaProjects\\ProyectoPrueba\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        action = new Actions(driver);
    }

    public BasePage(WebDriver driver) {

        BasePage.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static void closeBrowser() {
        driver.quit();
    }

    //navegar a una pagina:
    public static void navegarA(String url) {

        driver.get(url);
    }

    public static WebElement findByXpath(String locator) {
        return wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        if (findByXpath(locator).isDisplayed()) {
            findByXpath(locator).click();
        }

    }

    public void write(String locator, String textToWrite) {
        findByXpath(locator).clear();
        findByXpath(locator).sendKeys(textToWrite);
    }

    public String obtenerTexto(String locator) {
        return findByXpath(locator).getText();
    }

    public void moveToElement(String locator) {
        action.moveToElement(findByXpath(locator)).perform();
        action.click();
    }

    public boolean isDisplayed(String locator) {
        try {
            findByXpath(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //----------------------Switches------------------------------------
    public void switchToWindowsElement(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToAlertFrame() {
        driver.switchTo().alert().accept();
    }
//-------------------DropDowns----------------------------------

    public void selectFromDropDown(String locator, String valueToSelect) {
        Select dropDown = new Select(findByXpath(locator));
        dropDown.selectByValue(valueToSelect);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void clickAndHold(String locator) {
        action.click(findByXpath(locator)).perform();
    }

public void scrollUp(){

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,-250)", "");

    }
}