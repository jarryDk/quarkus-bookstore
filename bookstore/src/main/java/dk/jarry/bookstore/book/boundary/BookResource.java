package dk.jarry.bookstore.book.boundary;

import java.util.List;

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

import dk.jarry.bookstore.book.entity.Book;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

	@GET
	public List<Book> getBooks() {
		return Book.findAll() //
				.page(0, 100) //
				.list();
	}

	@POST
	@Transactional	
	public void create(Book book) {
		book.persist();
	}
	
	@GET
	@Path("id/{id}")
	public Book getById(@PathParam("id") Long id) {
		Book book = Book.findById(id);
		if (book == null) {
			throw new WebApplicationException( //
					"book with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		return book;
	}
	
	@GET
	@Path("isbn/{isbn}")
	public Book getByIsbn(@PathParam("isbn") Long isbn) {
		Book book = Book.find("isbn", isbn).firstResult();
		if (book == null) {
			throw new WebApplicationException( //
					"book with isbn of " + isbn + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		return book;
	}
	
	@PUT
	@Path("id/{id}")
	@Transactional
	public void updateById(@PathParam("id") Long id, Book book ) {
		if(Book.findById(id) == null) {
			throw new WebApplicationException( //
					"book with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		book.persist();
	}
	
	@DELETE
	@Path("id/{id}")
	@Transactional
	public void deleteById(@PathParam("id") Long id) {
		Book book = Book.findById(id);
		if(book == null) {
			throw new WebApplicationException( //
					"book with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		book.delete();
	}
	
}
