package reqres.methods;


import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class UserMethods {
    public void getSingleUser() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/users/5")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(5));
    }

    public void userNotFound() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/users/25")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

    public void createUser() {
        String user = "{ \"name\": \"nikita\", \"job\": \"tester\" }"; // BAD PRACTICE
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(user)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("nikita"));
    }

    public void updateUser() {
        String user = "{ \"name\": \"nikita\", \"job\": \"Team Lead\" }"; // BAD PRACTICE
        given()
                .log().uri()
                .log().method()
                .log().body()
                .contentType(JSON)
                .body(user)
                .when()
                .put("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("job", is("Team Lead"));
    }

    public void deleteUser(){
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .delete("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }
}