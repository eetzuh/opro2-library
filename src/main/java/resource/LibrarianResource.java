package resource;

import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Librarian;
import repository.LibrarianRepository;

@Path("/librarian/")
public class LibrarianResource {
	@Inject
	private LibrarianRepository librarianRepository;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addLibrarian")
	public Response createLibrarian(Librarian librarian) {
		if (librarian == null) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Librarian data is required" + librarian).build();
		}
		Librarian l = librarianRepository.createLibrarian(librarian);
		return Response.ok().entity(l).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllLibrarians")
	public Response getAllLibrarians() {
		List<Librarian> librarians = librarianRepository.getAllLibrarians();

		return Response.ok().entity(librarians).build();
	}
}
