import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class WeatherBit extends WProvider {

	String name;
	String key;
	String url;
	
	public WeatherBit(String name, String url, String key) {
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
		JSONArray ja = (JSONArray) jsonObject.get("data");
		
		JSONObject jsonObject1 = (JSONObject) ja.get(0);
		
		String city_name = (String) jsonObject1.get("city_name");
		String ccode = (String) jsonObject1.get("country_code");
		double apptemp = (long) jsonObject1.get("temp");
		
		System.out.println("Weather in: " + city_name + " " + ccode +" "+ apptemp + " Celsius by " + this.getName());
	
		}

	public String getConnection() {
		
		String ur;
		String gc_ur;
		String gc_key;
		WProvider wp = this;
		ur = wp.getUrl();
		gc_key = wp.getKey(); 
		gc_ur = ur;
		gc_ur += "moscow" + "&key=" + gc_key;		
		return gc_ur;
	}
	
	public String getData(String city) {
		
		String urdata;
		String gd_ur;
		String gd_key;
		WProvider wp = this;
		gd_ur = wp.getUrl();
		gd_key = wp.getKey(); 
		urdata = gd_ur;
		urdata += city + "&key=" + gd_key;		
		return urdata;
	}

	public String getData(String lat, String lon) {
		
		String urdata;
		String gd_ur;
		String gd_key;
		
		WProvider wp = this;
		gd_ur = wp.getUrl();
		gd_key = wp.getKey(); 
		urdata = gd_ur;
		urdata += "&lat=" + lat + "&lon=" + lon + "&key=" + gd_key;		
		return urdata;
	}
	
	
}
