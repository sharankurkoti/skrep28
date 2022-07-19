package com.sprint.qa.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class POST_Method_2FAUtil {
	

	public static String TOKEN;
	public static String ACCESS_TOKEN;
	public static String REFRESH_TOKEN;
		
//	private final CloseableHttpClient httpClient = HttpClients.createDefault();
//	
//    public static void main(String[] args) throws Exception {
//
//        POST_Method_2FA obj = new POST_Method_2FA();
//        
//
//        try {
//
//            System.out.println("Testing 1 - Send Http POST request");
//            obj.sendPost1();
//       
//   		 ACCESS_TOKEN = TOKEN.substring(0,793);
//   		 System.out.println(ACCESS_TOKEN);
//   		 
//   		 REFRESH_TOKEN = TOKEN.substring(812,848);
//   		 System.out.println(REFRESH_TOKEN);
//            
//        } finally {
//            obj.close();
//        }
//        
//        return;
//    }
//  
//	public void close() throws IOException {
//        httpClient.close();
//    }
	
    public static void sendPost1() throws Exception {
        HttpPost post = new HttpPost("https://myorders-api-shadow.presidio.com/auth/token");

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("grant_type", "client_credentials"));
        urlParameters.add(new BasicNameValuePair("client_id", "cbw6msqEY8j4FftOlDK93ODxcC9vEL/HvdRDKf1VedcHJFW3wikPEE5vkitofaMi1BBQRXw8hYElUQnw5g8uZuIxH3skp/65Ug9lpfpZBzA="));
        urlParameters.add(new BasicNameValuePair("client_secret", "SGZc9tKeHBroIA6cKFSddtVKBAz9rqLh2resNXD6RipCzrskBeSPADkwQs0vt1SPi48Ow8zTFqVLLGdetNMjZ1icbmpJoCuD4QC10+MuG2I="));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {
           
        	BufferedReader br = new BufferedReader(new     
        			InputStreamReader((response.getEntity().getContent())));
        			String response1 = br.readLine();
//        			System.out.println("response" + response1 );
        			
        			TOKEN = response1.substring(135,983);
        			
      		 ACCESS_TOKEN = response1.substring(135,928);
//        		 System.out.println(ACCESS_TOKEN);
        		 
        		 REFRESH_TOKEN = response1.substring(947,983);
//        		 System.out.println(REFRESH_TOKEN);
        			
        }
    }     
}

