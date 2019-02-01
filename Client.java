package framework;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.http.HttpHeaders.USER_AGENT;

public class Client {
    HttpClient client;
    HttpPost post;
    HttpResponse response;
    EventListener listener;
    private static String url ="https://10.11.244.164:8443/owc-servlets/login";

    public Client() {
        listener = new EventListener();
        listener.run();
        this.client = HttpClientBuilder.create().build();
        this.post = new HttpPost(url);
        post.setHeader("User-Agent Chris", USER_AGENT);
        post.setHeader("application/x-www-form-urlencoded",CONTENT_TYPE );
    }

    public void sendRequest() throws IOException {

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("p800", "C02G8416DRJM"));
        urlParameters.add(new BasicNameValuePair("p801", "kjhghghj"));
        post.setEntity(new UrlEncodedFormEntity(urlParameters));
        String certificatesTrustStorePath = "C:\\Program Files\\Java\\jdk1.8.0_181\\jre\\lib\\security\\cacerts";
        System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);
        response = client.execute(post);
        listener.Catch("INFO: Response Code :" + response.getStatusLine().getStatusCode());
        if (response.getStatusLine().getStatusCode() != 200) {

            listener.Catch("INFO: Login has failed  :" + response.getStatusLine().getStatusCode() + "" +
                    response.getStatusLine().toString());
        }
    }
}
