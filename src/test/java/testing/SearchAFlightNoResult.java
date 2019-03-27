package testing;


import framework.Driver;
import framework.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import tools.CsvReader;

import java.io.IOException;
import java.util.List;

public class SearchAFlightNoResult extends Test {
   /* clean install -DsuiteXmlFile=SuitesViva.xml */
   Driver web;
    WebDriverWait dr;
    CsvReader csv;
    List<List<String>> records;

    @BeforeClass
    public void setUp() throws IOException {
        csv = new CsvReader();
        records = csv.getdata();
        String browserType = records.get(2).get(0);
        System.out.println("info: " + browserType);
        this.web = new Driver(browserType);
        web.run();
    }
    @Parameters({"url"})
    @org.testng.annotations.Test
    public void noFlightFound(String url){
        web.open(url);
        sleep(2000);
        web.clickCss(Elements.cookie);
        String window = web.getDriver().getWindowHandle();
        System.out.println("info: " + window);
        web.getDriver().switchTo().window(window);
        web.getDriver().switchTo().frame(0);
        dr = new WebDriverWait(web.getDriver(),5);
        web.waitnamevisible(dr,Elements.radio,"click");
        sleep(4000);
        //assert null == (web.getDriver().getPageSource().contains("Επιστροφή")) : "Return was AVAILABLE";
        boolean back = web.getDriver().getPageSource().contains("Επιστροφή");
        System.out.println(back);
        web.clickId(Elements.from);
        web.sendToId(Elements.from,records.get(2).get(1));
        sleep(1000);
        web.sendToId(Elements.to,"Θεσσαλονίκη - Makedonia Arpt (SKG) - Ελλάδα");
        //Θεσσαλονίκη - Makedonia Arpt (SKG) - Ελλάδα
        sleep(3000);
        web.sendToId(Elements.date,records.get(2).get(3));
        sleep(2000);
        web.sendToId(Elements.adults,records.get(2).get(4));
        sleep(2000);
        web.clickId(Elements.quicksearch);
        sleep(10000);
        ////page 2
        sleep(2000);
        web.getDriver().switchTo().frame(0);
        assert(web.getDriver().getPageSource().contains("Δεν βρέθηκαν αποτελεσματα")) : "Some problem";
        assert(true);
    }


    @AfterClass
    public void tearDown() {
        web.close();
    }
    private void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
