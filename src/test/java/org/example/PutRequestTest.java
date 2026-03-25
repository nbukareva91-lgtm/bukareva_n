package org.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class PutRequestTest {

    @Test
    void testPutRequest() {

        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .log().ifValidationFails()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
}