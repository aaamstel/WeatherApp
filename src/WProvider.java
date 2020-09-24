
public abstract class WProvider implements AbProvider {

	
	String name;
	String key;
	String url;
	
	public WProvider(String name,String url, String key){
		
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

	abstract public String getConnection(); 
	abstract public String getData(String city);
	abstract public String getData(String lat, String lon);
}

