package dk.jarry.bookstore.author.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorResource {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @RequestMapping("{id}")
    public String getAuthor() {
        return "hello";
    }

}