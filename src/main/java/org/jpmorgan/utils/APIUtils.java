package org.jpmorgan.utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class APIUtils {

    private APIUtils(){
    }

    @SneakyThrows
    public static String readJSONAndGetAsString(String filePath){
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

}
