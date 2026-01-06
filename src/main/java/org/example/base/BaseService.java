package org.example.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.List;
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

    //post call
    protected Response postWithMultipart(Object body, File file, String endpoint) {
        return given()
                .multiPart(file)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

    //post call
    protected Response postWithListOfMultipart(Object body, List<File> files, String endpoint) {
        RequestSpecification requestSpecification = given();

        for(File f : files){
            requestSpecification.multiPart(f);
        }
        return requestSpecification
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


    protected <T, E> Object handleResponse(Response response,
                                           Class<T> successClass,
                                           Class<E> errorClass) {

        int statusCode = response.getStatusCode();

        if (statusCode >= 200 && statusCode < 300) {
            // Treat 2xx as success → deserialize to successClass
            return response.as(successClass);
        } else {
            // Errors (4xx, 5xx) → deserialize to errorClass
            return response.as(errorClass);
        }
    }



}
