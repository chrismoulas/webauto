package testing;

import framework.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Test {

     Driver web;
    private String URL;

    @BeforeClass
    public void setUp() {
       web = new Driver();
       web.run();
       this.URL="https://www.calendar.topaction.gr/";

    }

    @AfterClass
    public void tearDown() {
       web.close();
    }

    @org.testng.annotations.Test
    public void OpenUrl() {
        web.open(URL);
    }
}
