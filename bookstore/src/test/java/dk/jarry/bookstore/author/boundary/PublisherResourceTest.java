package dk.jarry.bookstore.author.boundary;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PublisherResourceTest {

    @Test
    public void testEndpoint() {
        given()
          .when().get("/publishers/test")
          .then()
             .statusCode(200)
             .body(containsString("id"));
    }

}