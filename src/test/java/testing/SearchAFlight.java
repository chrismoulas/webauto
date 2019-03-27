package testing;


import framework.Driver;
import framework.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import tools.CsvReader;

import java.io.IOException;
import java.util.List;

public class SearchAFlight extends Test {
   /* clean install -DsuiteXmlFile=SuitesViva.xml */
   //created by Christos Moulas March 2019
   Driver web;
    WebDriverWait dr;
    CsvReader csv;
    List<List<String>> records;

    @BeforeClass
    public void setUp() throws IOException {
        csv = new CsvReader();
        records = csv.getdata();
        String browserType = records.get(1).get(0);
        System.out.println("info: " + browserType);
        this.web = new Driver(browserType);
        web.run();
    }
    @Parameters({"url"})
    @org.testng.annotations.Test
    public void lookForFlight(String url){
        web.open(url);
        web.clickCss(Elements.cookie);
        ///for test
        //web.clickCss(Elements.login);
        String window = web.getDriver().getWindowHandle();
        System.out.println("info: " + window);
        web.getDriver().switchTo().window(window);
        web.getDriver().switchTo().frame(0);
        dr = new WebDriverWait(web.getDriver(),5);
        web.waitnamevisible(dr,Elements.radio,"click");
        web.clickId(Elements.from);
        web.sendToId(Elements.from,records.get(1).get(1));
        sleep(2000);
        web.clickxPath("//body/ul/li[2]/a");
        web.sendToId(Elements.to,records.get(1).get(2));
        sleep(2000);
        web.clickxPath("//ul[2]/li/a");
        web.sendToId(Elements.date,records.get(1).get(3));
        sleep(2000);
        web.sendToId(Elements.adults,records.get(1).get(4));
        sleep(2000);
        web.clickId(Elements.quicksearch);
        sleep(10000);
        ////page 2
        //web.clickCss(Elements.cookie);
        JavascriptExecutor js = (JavascriptExecutor) web.getDriver();
        js.executeScript("window.scrollBy(0,1000)");
        web.waitnamevisible(dr,Elements.flight0,"click");
        /////page 3
        sleep(10000);
        /////
//        web.getDriver().switchTo().frame(0);
        String flight=".green-price-container";
        String price = web.getDriver().findElement(By.cssSelector(flight)).getText();
        System.out.println(price);
        /////
        js.executeScript("window.scrollBy(0,1000)");
        web.sendToId(Elements.mob,records.get(1).get(5));
        web.sendToId(Elements.mail,records.get(1).get(6));
        sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");
        web.sendToId(Elements.p1firstname,records.get(1).get(7));
        web.sendToId(Elements.p1lastname,records.get(1).get(8));
        web.sendToId(Elements.p2firstname,records.get(1).get(9));
        web.sendToId(Elements.p2lastname,records.get(1).get(10));
        web.sendToId(Elements.gender1,"Άνδρας");
        web.sendToId(Elements.gender2,"Γυναίκα");
        sleep(2000);
        js.executeScript("window.scrollBy(0,1000)");
        web.clickId(Elements.nosec);
        web.clickCss(Elements.margin);
        sleep(4000);
        sleep(5000);
        sleep(3000);
 //       web.clickCss(Elements.margin);
        String totalPriceCss =".total-amount-cute";
        String totalPrice = web.getDriver().findElement(By.cssSelector(totalPriceCss)).getText();
        System.out.println(totalPrice);
        price = price.replace(" €","");
        totalPrice = totalPrice.replace("€","");
        assert(price.equals(totalPrice)) : "No matching prices";
        //we could also convert to integers and check
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
