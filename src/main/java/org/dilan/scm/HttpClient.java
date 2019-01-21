package org.dilan.scm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;


public class HttpClient {

    private CloseableHttpClient client = HttpClientBuilder.create().build();
    final static Logger LOGGER = Logger.getLogger(HttpClient.class);

    public String sendRequest(String url) throws IOException {

        HttpGet request = new HttpGet(url);

        request.addHeader("Authorization", "Basic " + Base64.encodeBase64String("dilan:1314246dilan".getBytes()));
        request.addHeader("Content-Type", "application/json");
        HttpResponse response = client.execute(request);

        LOGGER.debug("Response Code : " + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        Gson gson = new Gson();


        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }


        gson.toJson(result.toString());
        return gson.toString();
    }
}
