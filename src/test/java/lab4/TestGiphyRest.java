package lab4;


import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class TestGiphyRest {

    private static final String REQUEST_URL = "http://jsonplaceholder.typicode.com";

    @Test
    public void testRightGet() {

        given()
                .get(REQUEST_URL + "/posts/1")
        .then()
                .body(containsString("quia"))
                .statusCode(200);

    }


    @Test
    public void testRightPost() {

        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("firstName", "John");
        jsonAsMap.put("lastName", "Doe");

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .post(REQUEST_URL + "/posts")
        .then()
                .statusCode(201);

    }


    @Test
    public void testRightPut() {

        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("firstName", "John");
        jsonAsMap.put("lastName", "Doe");

        given()
                .contentType("application/json")
                .body(jsonAsMap)
                .put(REQUEST_URL + "/posts/1")
        .then()
                .statusCode(200);

    }


    @Test
    public void testRightDelete() {

        given()
                .delete(REQUEST_URL + "/posts/1")
        .then()
                .statusCode(200);

    }


    @Test
    public void testWrongDelete() {

        given()
                .delete(REQUEST_URL + "/posts")
        .then()
                .statusCode(404);

    }

}
