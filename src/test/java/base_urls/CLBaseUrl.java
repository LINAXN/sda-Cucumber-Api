package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;

public class CLBaseUrl {

    public static RequestSpecification spec;
    private static String baseUrl = "https://thinking-tester-contact-list.herokuapp.com";

    static {//Whatever we call from this class, first this block will run.
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }

    private static String getToken() {
        String credentials = "{\"email\": \"claruswaysda@hotmail.com\", \"password\": \"Sda.123\"}";
        return given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .post(baseUrl + "/users/login")
                .jsonPath()
                .getString("token");
    }

}

