import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class OpenWeatherMap extends WProvider {
	
	String name;
	String key;
	String url;
	
	public OpenWeatherMap(String name, String url, String key) {
		super(name, url, key);
			
	this.name=name;
	this.key=key;
	this.url=url;
}
	public void setKey(String key){
		this.key=key;
		}
	
	public void setUrl(String url){
		this.url=url;
		}
	
	public String getUrl(){
		return url;
		}
	
	public String getKey(){
		return key;
		}
	
	public String getName(){
		return name;
		}
	
	public void setName(String name){
		this.name=name;
		}

	 
	public void parse(String resp) {
		
		Object obj=JSONValue.parse(resp);  
		JSONObject jsonObject =  (JSONObject) obj;  
		String name = (String) jsonObject.get("name"); 
		 
		System.out.print(name +" ");
		Map wcountry = (Map)jsonObject.get("sys");
		System.out.print(wcountry.get("country") + " ");	
		Map wcity = (Map)jsonObject.get("main");
		System.out.println(wcity.get("temp") + " Celsius by " + this.getName());	
		}

	public String getConnection() {
		
		String gc_url;
		String gc_key;
		String ur;
		WProvider wp = this;
		ur = wp.getUrl();
		gc_key = wp.getKey(); 
		gc_url = ur;
		gc_url += "q="+ "moscow" + gc_key;		
		return gc_url;
	}
	
	public String getData(String city) {
		
		String urdata;
		String ur1;
		String gd_key;
		WProvider wp1 = this;
		ur1 = wp1.getUrl();
		gd_key = wp1.getKey(); 
		urdata = ur1;
		urdata += "q="+ city + "&key=" + gd_key;		
		return urdata;
	}

	public String getData(String lat, String lon) {
	
		String urdata;
		String ur1;
		String gd_key;
		WProvider wp1 = this;
		ur1 = wp1.getUrl();
		gd_key = wp1.getKey(); 
		urdata = ur1;
		urdata += "lat=" + lat + "&lon="+ lon + gd_key;		
		return urdata;
}
		
}
	
