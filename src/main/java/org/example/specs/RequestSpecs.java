package org.example.specs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.config.EnvConfig;
import org.example.utility.TokenManager;

public class RequestSpecs {

    public static RequestSpecification defaultRequestSpec;

    private static RequestSpecBuilder getDefaultRequestSpecification(){
        return  new RequestSpecBuilder()
                .setBaseUri(EnvConfig.BASE_URL)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL);
    }

    public static void initDefaultSpec() {
        defaultRequestSpec = getDefaultRequestSpecification().build();

        RestAssured.requestSpecification = defaultRequestSpec;
    }

    public static void initAuthSpec(String username) {
        String token = TokenManager.getToken(username);
        defaultRequestSpec = getDefaultRequestSpecification()
                .addHeader("x-auth-token",token).build();

        RestAssured.requestSpecification = defaultRequestSpec;
    }
}
