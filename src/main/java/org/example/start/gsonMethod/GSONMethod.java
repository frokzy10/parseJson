package org.example.start.gsonMethod;

import com.google.gson.Gson;
import org.example.model.Person;
import org.example.model.Phones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GSONMethod {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/nurdinbakytbekov/Desktop/jsonLearn/src/main/java/org/example/db.json");

        BufferedReader br = new BufferedReader(new FileReader(file));
        Gson gson = new Gson();
        Person person = gson.fromJson(br,Person.class);

        for (Person friend : person.getFriends()) {
            for (Phones phone: friend.phoneNumbers) {
                System.out.println(" - phone type: " + phone.type + ", phone number : " + phone.number);
            }
        }

    }
}
