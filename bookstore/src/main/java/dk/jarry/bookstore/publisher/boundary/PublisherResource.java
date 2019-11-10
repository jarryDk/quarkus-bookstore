package dk.jarry.bookstore.publisher.boundary;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dk.jarry.bookstore.publisher.entity.Publisher;

@Path("publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {
	
	@GET
	public List<Publisher> getPublishers() {
		return null;
	}
	
}
