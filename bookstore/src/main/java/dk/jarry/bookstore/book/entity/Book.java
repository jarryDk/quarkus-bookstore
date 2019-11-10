package dk.jarry.bookstore.book.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Book extends PanacheEntity {

	@NotNull
	public String isbn;

	@NotNull
	public String title;

	@NotNull
	public Long authorId;

	@NotNull
	public Long publisherId;

}
