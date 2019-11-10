package dk.jarry.bookstore.publisher.boundary;

import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.jarry.bookstore.book.entity.Book;
import dk.jarry.bookstore.publisher.entity.Publisher;

@RestController
@RequestMapping("/publishers")
public class PublisherResource {

	@GetMapping
    public List<Publisher> getPublishers() {
		return Publisher.findAll() //
				.page(0, 100) //
				.list();
    }

    @PostMapping
    public void create(Publisher publisher) {
    	publisher.persist();;
    }
    
    @GetMapping(path = "/{id}" , produces = "application/json")
    public Publisher readById(@PathVariable Long id) {
    	Publisher publisher = Publisher.findById(id);
		return publisher;
    }
    
    @PutMapping(path = "/{id}" , produces = "application/json")
    public void updateById(@PathVariable Long id, Publisher publisher) {
    	if(Publisher.findById(id) == null) {
			throw new WebApplicationException( //
					"publisher with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
    	publisher.persist();
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
    	Publisher publisher = Book.findById(id);
    	if(Publisher.findById(id) == null) {
			throw new WebApplicationException( //
					"publisher with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
    	publisher.persist();
    }
    
    @GetMapping(path = "/test" , produces = "application/json")
    public Publisher readForTest(@PathVariable Long id) {
    	Publisher publisher = new Publisher();
		publisher.id = Long.parseLong("17");
		return publisher;
    }

}
