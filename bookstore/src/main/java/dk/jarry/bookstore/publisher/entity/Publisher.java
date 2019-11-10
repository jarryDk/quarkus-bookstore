package dk.jarry.bookstore.publisher.entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Publisher extends PanacheEntity{
	
	public String name;

}
