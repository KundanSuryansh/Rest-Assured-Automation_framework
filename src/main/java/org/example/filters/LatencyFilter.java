package org.example.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LatencyFilter implements Filter {


    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification,
                           FilterableResponseSpecification filterableResponseSpecification,
                           FilterContext filterContext) {

        Response response = filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        long endTime = response.time();
        System.out.println("API Time (ms) : " + endTime);

        return response;
    }
}
