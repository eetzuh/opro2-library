package resource;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.client.PublicHoliday;
import repository.PublicHolidayRepository;
import restclient.DateClient;

@Path("/publicHolidays")
public class PublicHolidayResource {
    @Inject
    @RestClient
    private DateClient dateClient;
    @Inject
    PublicHolidayRepository publicHolidayRepository;

    @POST
    @Path("/save/{countryCode}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveHolidays(@PathParam("countryCode") String code) {
        List<PublicHoliday> holidays = dateClient.getNextPublicHolidays(code);

        for (PublicHoliday res : holidays) {
            publicHolidayRepository.saveHoliday(res);
        }

        return Response.ok(holidays).build();
    }

}
