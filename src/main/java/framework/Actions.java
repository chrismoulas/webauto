package framework;

import org.openqa.selenium.support.ui.WebDriverWait;

public interface Actions {

    void clickxPath (String element);
    void clickname (String element);
    void clickId (String element);
    void clicktag (String element);
    void clickCss (String element);
    void waitnameinvisible(WebDriverWait wait, String element);
    void waitidinvisible(WebDriverWait wait, String element);
    boolean pageContains(String value);
    void sendToId(String location, String value);
    void sendToXPath(String location, String value);
    void sendToName(String location, String value);
    void sendToCss(String location, String value);
    void waitnamevisible(WebDriverWait wait, String element, String action);
    void waitidvisible(WebDriverWait wait, String element, String action);
    void waitxpathvisible(WebDriverWait wait, String element, String action);

}
