package resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.jboss.resteasy.reactive.multipart.FileUpload;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Author;
import multipartrestclient.MuptipartRequest;
import repository.AuthorRepository;

@Path("/author")
public class AuthorResource {
    @Inject
    private AuthorRepository authorRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addAuthor")
    public Response createAuthor(Author author) {
        Author a = authorRepository.createAuthor(author);
        return Response.ok().entity(a).build();
    }

    @GET
    @Path("/getAuthor")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthor(@QueryParam("id") int id) {
        Author author = authorRepository.getAuthorByID(id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Autor sa id: " + id + " ne postoji").build();
        }
        if (author.getFilePath() != null) {
            try {
                java.nio.file.Path path = Paths.get(author.getFilePath());
                if (Files.exists(path)) {
                    byte[] content = Files.readAllBytes(path);
                    author.setFileContent(content);
                }
            } catch (IOException e) {
                return Response.serverError().entity("Doslo je do greske").build();
            }
        }

        return Response.ok(author).build();
    }

    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@QueryParam("id") int id, MuptipartRequest request) {
        Author author = authorRepository.getAuthorByID(id);
        if (author == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Autor sa id: " + id + " ne postoji").build();
        }
        FileUpload fileUpload = request.getFile();
        String fileName = fileUpload.fileName();
        java.nio.file.Path uploadDirectory = Paths.get("uploads");
        java.nio.file.Path filePath = uploadDirectory.resolve(fileName);
        try {
            Files.createDirectories(uploadDirectory);
            Files.copy(fileUpload.uploadedFile(), filePath, StandardCopyOption.REPLACE_EXISTING);
            author.setFilePath(filePath.toString());
            authorRepository.updateAuthor(author);
            return Response.ok(author).build();

        } catch (Exception e) {
            return Response.serverError().entity("Doslo je do greske").build();
        }
    }

}
