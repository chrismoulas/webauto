package testing;

import framework.Client;
import framework.Client2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class HttpTest {
    Client2 clnt;

    @BeforeClass
    public void Setup() throws IllegalAccessException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        clnt = new Client2();
    }

    @AfterClass
    public void TearDOWN(){
    }

    @Test
    public void LoginTest() throws IOException {
        clnt.sendrequest();
    }
}
