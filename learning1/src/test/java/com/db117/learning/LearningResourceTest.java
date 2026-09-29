package com.db117.learning;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/** 验证 /learning 返回的配置和 CDI 示例数据。 */
@QuarkusTest
class LearningResourceTest {

    @Test
    void showsConfigAndCdiExamples() {
        given()
                .when().get("/learning")
                .then()
                .statusCode(200)
                .body("config.message", is("hello"))
                .body("config.locale", is("zh-CN"))
                .body("config.suffix", is("未配置"))
                .body("greetings", containsInAnyOrder(
                        "Hi, Quarkus",
                        "Welcome, Quarkus",
                        "Produced greeting, Quarkus"))
                .body("requestId", notNullValue())
                .body("applicationCall", notNullValue());
    }
}
