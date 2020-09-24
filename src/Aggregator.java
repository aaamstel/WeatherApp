
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.simple.parser.ParseException;


public class Aggregator {

	CloseableHttpClient httpclient = HttpClients.createDefault();

	List<WProvider> providers = new ArrayList<WProvider>();

	public void addProvider(WProvider provider) {
		
		providers.add(provider);		
	}

	public void getServices() {
		
		String url;	
		int statusCode = 0;
		
		for(int i=0; i<providers.size();i++){
			
			url = providers.get(i).getConnection();	
			HttpGet request = new HttpGet(url);
			
			try (CloseableHttpResponse response = httpclient.execute(request)) {
				statusCode = response.getStatusLine().getStatusCode();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int code = HttpStatus.SC_OK;
			
			if (code == statusCode) {
				System.out.println("Server is ready: " + code + " Provider: "+ providers.get(i).getName());
			} else {
			System.out.println("Error" + code);
			}
		}
}
	
	public void getWeather(String city) {
		
		String url;
		System.out.print("Weather in: ");
		
		for(int i=0; i<providers.size();i++){
			
			url = providers.get(i).getData(city);
			HttpGet request = new HttpGet(url);
			try (CloseableHttpResponse response = httpclient.execute(request)) {
			
			HttpEntity ht = response.getEntity();			
			String resp = EntityUtils.toString(ht);	
			providers.get(i).parse(resp);			
				
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {	
				e.printStackTrace();
			}
			    
		}
		
	}
	
	public void getWeather(String lat, String lon) {
	
		String url;
		System.out.print("Weather in: ");
		
		for(int i=0; i<providers.size();i++){
			
			url = providers.get(i).getData(lat, lon);
			HttpGet request = new HttpGet(url);
			try (CloseableHttpResponse response = httpclient.execute(request)) {
			
			HttpEntity ht = response.getEntity();			
			String resp = EntityUtils.toString(ht);	
			providers.get(i).parse(resp);			
				
			} catch (ClientProtocolException e) {	
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			    
		}
		
	}

}

