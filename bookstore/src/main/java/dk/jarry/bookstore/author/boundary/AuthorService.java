package dk.jarry.bookstore.author.boundary;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import dk.jarry.bookstore.author.entity.Author;

@ApplicationScoped
public class AuthorService {

	@Inject
	EntityManager entityManager;
		
	public AuthorService() {
	}
	
	@Transactional
	public Author create(Author author) {
		
		if (author.getId() != null) {
			throw new WebApplicationException( //
					"author not valid.", //
					Response.Status.BAD_REQUEST);
		}
		
		entityManager.persist(author);
		entityManager.flush();
		entityManager.refresh(author);
		
		return author;
	}

	@Transactional
	public Author read(Object id) {
		
		Author author = entityManager.find(Author.class, id);
		if (author != null) {
			return author;
		} else {
			throw new WebApplicationException( //
					"author with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
	}

	@Transactional
	public void update(Long id, Author author) {	
				
		if (read(id) != null) {
			entityManager.merge(author);			
		} else {
			throw new WebApplicationException( //
					"author with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
		
	}

	@Transactional
	public void delete(Long id) {

		Author author = read(id);

		if (author != null) {
			entityManager.remove(author);
		} else {
			throw new WebApplicationException( //
					"author with id of " + id + " does not exist.", //
					Response.Status.NOT_FOUND);
		}
	}

	@Transactional
	public List<Author> list(Long from, Long limit) {
		return entityManager
				.createNamedQuery("authors.findAll", Author.class)
				.getResultList();
	}

}
