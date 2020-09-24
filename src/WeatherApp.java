public class WeatherApp {
	
	
	public static void main(String args[]) {
		
		Aggregator ag = new Aggregator();
		
		ag.addProvider(new OpenWeatherMap("OpenWeatherMap", 
	"http://api.openweathermap.org/data/2.5/weather?","&appid=663e17302421b7868bf6edad17527e11&units=metric"));
		ag.addProvider(new WeatherBit("WeatherBit",
	"https://api.weatherbit.io/v2.0/current?city=","7cdc52db60ab47338faf348ed45745c9"));
			
		ag.getServices();
		ag.getWeather("Dubai");
		ag.getWeather("Paris");
		ag.getWeather("55.20","37.89");
		
	}

}
