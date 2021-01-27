package com.devxschool.summer.utility;

import com.google.gson.Gson;

public class ObjectConverter {
    //static method //generic

    private static Gson gson = new Gson();

    public static <T> String convertObjectToJson(T object){ // only convert to String
        return gson.toJson(object);


    }
    public static <T> T convertJsonToObject(String json, Class<T> clazz){ //need to have json(what to) what different type
        return gson.fromJson(json, clazz);
    }
}
