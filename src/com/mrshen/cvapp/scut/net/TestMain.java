package com.mrshen.cvapp.scut.net;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestMain {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
	            HttpGet httpGet = new HttpGet("http://localhost:8080/MyCook/caixi/004");
	            CloseableHttpResponse response = httpclient.execute(httpGet);
	          
	            try {
	                System.out.println(response.getStatusLine());
	                HttpEntity entity = response.getEntity();
	                // do something useful with the response body
	                // and ensure it is fully consumed
//	                EntityUtils.consume(entity);
	                String result = EntityUtils.toString(entity);
	                System.out.println(result);
	            } finally {
	                response.close();
	            }

	        } finally {
	            httpclient.close();
	        }
	}

}
