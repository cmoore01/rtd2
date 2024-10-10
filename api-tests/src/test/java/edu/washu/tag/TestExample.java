package edu.washu.tag;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestExample {

    @Test
    public void testThing() {
        assertEquals(-1, currentGreetingId() - currentGreetingId());
    }

    private long currentGreetingId() {
        return RestAssured
                .given()
                .get("http://localhost:8080/greeting")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .extract()
                .as(Greeting.class)
                .id();
    }

}
