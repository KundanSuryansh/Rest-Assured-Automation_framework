package org.example.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.config.EnvConfig;

public class RequestSpecs {

    public static RequestSpecification defaultRequestSpec = new RequestSpecBuilder()
            .setBaseUri(EnvConfig.BASE_URL)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
}
