package testing;

import framework.Elements;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

public class BookALesson extends Test {
   /* clean install -DsuiteXmlFile=Suites.xml */
    WebDriverWait dr;
    @Parameters({"url"})
    @org.testng.annotations.Test
    public void Book(String url){
        web.open(url);
        dr = new WebDriverWait(web.getDriver(),10);
        web.waitnamevisible(dr,Elements.Login,"click");
        web.sendToCss(Elements.userform,"moulas");
        web.sendToCss(Elements.passform,"christos");
        web.clickCss(Elements.loginbutton);
        web.waitnamevisible(dr,Elements.lesson,"click");
        web.waitnamevisible(dr,Elements.addlesson,"click");
        assert(true);
    }
}
