package org.example.utility;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataUtils {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T getTestDataAsObject(String fileName, Class<T> tClass){

        try {
            return MAPPER.readValue(new File("src/test/resources/testdata/" + fileName),
                    tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> getTestDataAsList(String fileName, Class<T> tClass){
        try {
            return MAPPER.readValue(new File("src/test/resources/testdata/" + fileName),
                    MAPPER.getTypeFactory().constructCollectionType(List.class,tClass));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
