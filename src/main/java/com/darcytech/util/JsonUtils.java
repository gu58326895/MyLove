package com.darcytech.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    private static ObjectMapper objectMapper = null;
    public static String objToJson(Object obj) {
        throw new UnsupportedOperationException("未实现");
    }

    public static <T> String arrayToJson(T[] arr) {
        throw new UnsupportedOperationException("未实现");
    }


    public static <T> T jsonToArray(String json, Class<T> clazz) {
        try {
            return  objectMapper.readValue(json,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
           return null;
    }


    public static <T> T jsonToObject(String json, Class<T> clazz) {

        try {
            return  objectMapper.readValue(json,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return  null;
    }
}