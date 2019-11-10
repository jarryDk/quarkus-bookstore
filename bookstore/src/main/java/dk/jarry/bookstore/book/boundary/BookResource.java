package dk.jarry.bookstore.book.boundary;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.jarry.bookstore.book.entity.Book;


@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

	@GET
	public List<Book> getBooks() {
		return Book.listAll();
	}
	
	@GET
	@Path("id/{id}")
	public Book getBookById(@PathParam("id") Long id) {
		Book book = Book.findById(id);
		return book;
	}
	
	@GET
	@Path("isbn/{isbn}")
	public Book getBookByIsbn(@PathParam("isbn") Long isbn) {
		Book book = Book.find("isbn", isbn).firstResult();
		return book;
	}
	
	@POST
	@Transactional	
	public void createBook(Book book) {
		book.persist();
	}
	
}
