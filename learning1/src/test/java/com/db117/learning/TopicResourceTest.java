package com.db117.learning;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

/** 验证主题 CRUD、输入校验和异常映射。 */
@QuarkusTest
class TopicResourceTest {

    @Test
    void createsListsUpdatesAndDeletesTopics() {
        String title = "Arc basics";
        Number idValue = given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"" + title + "\"}")
                .when().post("/topics")
                .then()
                .statusCode(201)
                .header("X-Study-Chapter", is("04"))
                .extract().path("id");
        long id = idValue.longValue();

        given()
                .when().get("/topics/{id}", id)
                .then()
                .statusCode(200)
                .body("title", is(title));

        given()
                .when().get("/topics")
                .then()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\"Updated Arc basics\"}")
                .when().put("/topics/{id}", id)
                .then()
                .statusCode(200)
                .body("title", is("Updated Arc basics"));

        given()
                .when().delete("/topics/{id}", id)
                .then()
                .statusCode(204);

        given()
                .when().get("/topics/{id}", id)
                .then()
                .statusCode(404)
                .body("error", is("Topic not found: " + id));
    }

    @Test
    void rejectsBlankTopicTitle() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"title\":\" \"}")
                .when().post("/topics")
                .then()
                .statusCode(400);
    }
}
