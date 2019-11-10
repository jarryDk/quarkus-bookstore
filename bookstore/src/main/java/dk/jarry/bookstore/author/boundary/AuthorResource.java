package dk.jarry.bookstore.author.boundary;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.jarry.bookstore.author.entity.Author;

@RestController
@RequestMapping("/authors")
public class AuthorResource {
	
	@Inject
	AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.list(Long.parseLong("0"), Long.parseLong("100"));
    }

    @PostMapping
    public void create(Author author) {
    	authorService.create(author);
    }
    
    @GetMapping(path = "/{id}" , produces = "application/json")
    public Author readById(@PathVariable Long id) {
        return authorService.read(id);
    }
    
    @PutMapping(path = "/{id}" , produces = "application/json")
    public void updateById(@PathVariable Long id, Author author) {
        authorService.update(id, author);
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
    	authorService.delete(id);
    }
    
    @GetMapping(path = "/test" , produces = "application/json")
    public Author readForTest(@PathVariable Long id) {
    	Author author = new Author();
    	author.id = id;
        return author;
    }
}