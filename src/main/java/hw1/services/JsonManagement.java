package hw1.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hw1.domain.Person;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonManagement {
    // сериализация списка Person в формат JSON
    public static String serialization(List<Person> persons) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(persons);
    }

    // десериализация строки JSON в список Person
    public static List<Person> deserialization(String json) {
        // приведение параметерезиного класса Person к типу, понятного для последующей обработки Gson
        Type listPerson = new TypeToken<ArrayList<Person>>(){}.getType();
        return new Gson().fromJson(json, listPerson);
    }
}
