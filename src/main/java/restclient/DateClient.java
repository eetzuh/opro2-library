package restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import model.client.CountryResonse;
import model.client.PublicHoliday;

@Path("/api/v3")
@RegisterRestClient(configKey = "nager-api")
public interface DateClient {

    @GET
    @Path("/AvailableCountries")
    CountryResonse getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    public PublicHoliday getNextPublicHolidays(@PathParam("countryCode") String code);

}
