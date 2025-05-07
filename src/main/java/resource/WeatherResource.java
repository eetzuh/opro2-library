package resource;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.client.Forecast;
import model.client.Weather;
import repository.ForecastRepository;
import repository.WeatherRepository;
import restclient.WeatherClient;

@Path("/weather")
public class WeatherResource {
    @Inject
    @RestClient
    private WeatherClient weatherClient;

    @Inject
    WeatherRepository weatherRepository;

    @Inject
    ForecastRepository forecastRepository;

    @POST
    @Path("/getForecast/{city}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveWeather(@PathParam("city") String city) {
        Weather weather = weatherClient.getWeatherForCity(city);
        for (Forecast forecast : weather.getForecast()) {
            forecastRepository.saveForecast(forecast);
        }
        weatherRepository.saveWeather(weather);

        return Response.ok(weather).build();
    }

}
