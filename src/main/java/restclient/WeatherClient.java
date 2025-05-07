package restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.client.Weather;

@RegisterRestClient(configKey = "goweather")
public interface WeatherClient {

    @GET
    @Path("/weather/{city}")
    public Weather getWeatherForCity(@PathParam("city") String city);
}
