package Structural;

// The existing European API (Adaptee - we can't change this)
class EuropeanWeatherAPI {
    public double getTemperatureCelsius(String city) {
        // Simulates API call returning Celsius
        return 25.0; // Example: 25°C in Paris
    }
}

// What the current app expects (Target Interface)
interface TemperatureService {
    double getTemperatureFahrenheit(String city);
}

// The Adapter - bridges the gap  //using object adapters
class WeatherAdapter implements TemperatureService {
    private final EuropeanWeatherAPI api; // Composition - holds reference to adaptee
    
    public WeatherAdapter(EuropeanWeatherAPI api) {
        this.api = api;
    }
    
    @Override
    public double getTemperatureFahrenheit(String city) {
        // Get Celsius from the API
        double celsius = api.getTemperatureCelsius(city);
        // Convert to Fahrenheit
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        return fahrenheit;
    }
}
// Direct client usage - NO middleman class needed
public class AdapterMain {
    public static void main(String[] args) {
        EuropeanWeatherAPI api = new EuropeanWeatherAPI();
        TemperatureService service = new WeatherAdapter(api);
        
        // Client calls adapter directly
        service.getTemperatureFahrenheit("Paris");  // Output: Temperature in Paris: 77.0°F
        
        // Or get raw temperature
        double temp = service.getTemperatureFahrenheit("London");
        System.out.println("Raw temp: " + temp + "°F");
    }
}