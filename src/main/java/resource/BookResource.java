package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Book;
import model.client.BookGenre;
import repository.BookRepository;

@Path("/book/")
public class BookResource {
    @Inject
    private BookRepository bookRepository;

    // @RestClient
    // private TimeClient TimeClient;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addBook")
    public Response createBook(Book book) {
        Book b = bookRepository.createBook(book);
        return Response.ok().entity(b).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createBookGenre")
    public Response createBookGenre(BookGenre bg) {
        BookGenre book = bookRepository.createBookGenre(bg);
        return Response.ok().entity(book).build();
    }
}
