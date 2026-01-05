package org.example.base;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {


    //get calls with different combination
    protected Response get(String endpoint){
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    protected Response getWithPathParams(String endpoint, Map<String,String> pathParams){
        return given()
                .pathParams(pathParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    protected Response getWithQueryParams(String endpoint, Map<String,String> queryParams){
        return given()
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    protected Response get(String endpoint, Map<String,String> queryParams, Map<String,String> pathParams){
        return given()
                .pathParams(pathParams)
                .queryParams(queryParams)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }


    //post call
    protected Response post(Object body, String endpoint) {
        return given()
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    //put call
    protected  Response put(Object body,String endpoint){
        return given()
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
    }

    //delete call
    protected Response deleteWithPathParam(String endpoint, Map<String,String> pathParams){
        return given()
                .pathParams(pathParams)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }





}
