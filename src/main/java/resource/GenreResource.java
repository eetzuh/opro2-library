package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Genre;
import repository.GenreRepository;

@Path("/genre/")
public class GenreResource {
    @Inject 
    private GenreRepository genreRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addGenre")
    public Response createGenre(Genre genre){
        Genre g = genreRepository.createGenre(genre);
        return Response.ok().entity(g).build();
    }
}
