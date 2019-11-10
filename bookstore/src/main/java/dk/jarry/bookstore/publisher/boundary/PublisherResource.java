package dk.jarry.bookstore.publisher.boundary;

import java.util.List;

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

import dk.jarry.bookstore.publisher.entity.Publisher;

@Path("/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

	@GET
	public List<Publisher> getPublishers() {
		return Publisher.findAll() //
				.page(0, 100) //
				.list();
	}

	@POST
	public void create(Publisher publisher) {
		publisher.persist();
	}

	@GET
	@Path("/id/{id}")
	public Publisher readById(@PathParam("id") Long id) {
		Publisher publisher = Publisher.findById(id);
		if (publisher == null) {
			throw new WebApplicationException( //
					"publisher with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		return publisher;
	}

	@PUT
	@Path("/id/{id}")
	public void updateById(@PathParam("id") Long id, Publisher publisher) {
		if (Publisher.findById(id) == null) {
			throw new WebApplicationException( //
					"publisher with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		publisher.persist();
	}

	@DELETE
	@Path("/id/{id}")
	public void deleteById(@PathParam("id") Long id) {
		Publisher publisher = Publisher.findById(id);
		if (publisher == null) {
			throw new WebApplicationException( //
					"publisher with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		publisher.delete();
	}

	@GET()
	@Path("/test")
	public Publisher readForTest() {
		Publisher publisher = new Publisher();
		return publisher;
	}

}
