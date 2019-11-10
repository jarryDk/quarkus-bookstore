package dk.jarry.bookstore.author.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String name;
	
	public Long getId() {
		return id;
	}

}
