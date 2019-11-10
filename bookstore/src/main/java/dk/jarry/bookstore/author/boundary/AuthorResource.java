package dk.jarry.bookstore.author.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dk.jarry.bookstore.author.entity.Author;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
	
	@Inject
	AuthorService authorService;
	
	@GET
	public List<Author> getAuthors() {
		return authorService.list(
				Long.parseLong("0"), 
				Long.parseLong("0"));
	}
	
	@POST
	public void create(Author author) {
		authorService.create(author);
	}

	@GET
	@Path("/id/{id}")
	public Author readById(@PathParam("id") Long id) {
		Author author = authorService.read(id);
		if (author == null) {
			throw new WebApplicationException( //
					"author with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		return author;
	}

	@PUT
	@Path("/id/{id}")
	@Transactional
	public void updateById(@PathParam("id") Long id, Author author) {
		if (authorService.read(id) == null) {
			throw new WebApplicationException( //
					"author with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		authorService.update(id, author);
	}

	@DELETE
	@Path("/id/{id}")
	@Transactional
	public void deleteById(@PathParam("id") Long id) {
		if (authorService.read(id) == null) {
			throw new WebApplicationException( //
					"author with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		authorService.delete(id);

	}

	@GET()
	@Path("/test")
	public Author readForTest() {
		Author author = new Author();
		author.id = Long.parseLong("17");
		return author;
	}

    
}