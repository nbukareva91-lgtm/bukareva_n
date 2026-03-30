package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static java.util.Collections.emptyMap;

class PostFormDataTest {

    @Test
    void testPostFormData() {

        given()
                .log().ifValidationFails()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("data", equalTo(""))
                .body("files", equalTo(emptyMap()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));
    }
}