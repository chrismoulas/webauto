package framework;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import tools.JSONConverter;
import tools.LoginRequest;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class Client2 {

    SSLContextBuilder builder;
    CloseableHttpClient client;
    HttpPost post;
    EventListener listener;
    CloseableHttpResponse response;
    private static String url ="https://r3feverylfr:8443/owc-servlets/login";

    public Client2() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, IllegalAccessException {
        listener = new EventListener();
        builder = new SSLContextBuilder();
        builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                builder.build());
        client = HttpClients.custom().setSSLSocketFactory(
                sslsf).build();
        this.post = new HttpPost(url);
        LoginRequest req = new LoginRequest("MITSOS", "KITSOS");
        String requestStr = JSONConverter.toJSON(req);
        StringEntity entity = new StringEntity(requestStr, ContentType.create("application/json"));
        post.setEntity(entity);

    }
    public void sendrequest () throws IOException {
        response = client.execute(post);
        try {
            listener.Catch("INFO: Response Code :" + response.getStatusLine().getStatusCode());
            listener.Catch("INFO: Response  :" + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            if (response.getStatusLine().getStatusCode() != 200) {

                listener.Catch("INFO: Login has failed  :" + response.getStatusLine().getStatusCode() + "" +
                        response.getStatusLine().toString());
            }else {
                listener.Catch("INFO: Login success  :" + response.getStatusLine().getStatusCode() + "" +
                        response.getStatusLine().toString());
            }
        }
        finally {
            response.close();
        }

    }
}
