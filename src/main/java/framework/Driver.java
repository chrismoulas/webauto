package framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver  implements Actions, Runnable {
    WebDriver driver;
    EventListener listener;

    public Driver() {
        String pathtoChromeDriver ="C:\\Chrome\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", pathtoChromeDriver);
        listener = new EventListener();
        listener.run();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        listener.Catch("INFO : Closing the Driver Now.");
        driver.quit();
    }

    public void open(String url){
        driver.navigate().to(url);
    }

    @Override
    public void clickxPath(String element) {
        driver.findElement(By.xpath(element)).click();
        listener.Catch("INFO : click Element : " + element);
    }

    @Override
    public void clickname(String element) {
        driver.findElement(By.name(element)).click();
        listener.Catch("INFO : click Element : " + element);
    }

    @Override
    public void clickId(String element) {
        driver.findElement(By.id(element)).click();
        listener.Catch("INFO : click Element : " + element);
    }

    @Override
    public void clicktag(String element) {
        driver.findElement(By.tagName(element)).click();
        listener.Catch("INFO : click Element : " + element);
    }

    @Override
    public void clickCss(String element) {
        driver.findElement(By.cssSelector(element)).click();
        listener.Catch("INFO : click Element : " + element);
    }

    @Override
    public void waitnameinvisible(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(element)));
        listener.Catch("INFO : wait for Element (invisible) : " + element);
    }

    @Override
    public void waitidinvisible(WebDriverWait wait, String element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element)));
        listener.Catch("INFO : wait for Element (invisible) : " + element);
    }

    @Override
    public boolean pageContains(String value) {
        return driver.getPageSource().contains(value);
    }

    @Override
    public void sendToId(String location, String value) {
        driver.findElement(By.id(location)).sendKeys(value);
    }

    @Override
    public void sendToXPath(String location, String value) {
        driver.findElement(By.xpath(location)).sendKeys(value);
    }

    @Override
    public void sendToName(String location, String value) {
        driver.findElement(By.name(location)).sendKeys(value);
    }

    @Override
    public void sendToCss(String location, String value) {
            driver.findElement(By.cssSelector(location)).sendKeys(value);
    }

    @Override
    public void waitnamevisible(WebDriverWait wait, String element, String action) {
        if(action.equals("click")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element))).click();
        }else if(action.equals("wait")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
        }
        listener.Catch("INFO : wait for Element (visible) : " + element);
    }

    @Override
    public void waitidvisible(WebDriverWait wait, String element, String action) {
        if(action.equals("click")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).click();;
        }else if(action.equals("wait")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        }
        listener.Catch("INFO : wait for Element (visible) : " + element);
    }

    @Override
    public void waitxpathvisible(WebDriverWait wait, String element, String action) {
        if(action.equals("click")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();
        }else if(action.equals("wait")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        }
        listener.Catch("INFO : wait for Element (visible) : " + element);
    }

    @Override
    public void run() {
            driver = new ChromeDriver();
    }
}
