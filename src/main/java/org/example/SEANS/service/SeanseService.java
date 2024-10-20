package org.example.SEANS.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.SEANS.model.Seanse;
import org.example.SEANS.model.Sessions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeanseService {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/nurdinbakytbekov/Desktop/jsonLearn/src/main/java/org/example/SEANS/seanse.json");

        BufferedReader br = new BufferedReader(new FileReader(file));

        Gson gson = new Gson();
        Type type = new TypeToken<HashMap<String, Seanse>>() {
        }.getType();
        Map<String, Seanse> myMap = gson.fromJson(br, type);

        for (Map.Entry<String, Seanse> entry : myMap.entrySet()) {
            String key = entry.getKey();
            Seanse value = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Name: " + value.getName());
            System.out.println("Metro: " + value.getMetro());
            System.out.println("Локация: " + value.getLocate());
            System.out.println("=====");

            List<Sessions> sessionsList = value.getSessions();
            System.out.println("Sessions:");
            for (Sessions session : sessionsList) {
                System.out.println(" - Time: " + session.getTime() + ", Price: " + session.getPrice());
            }
            System.out.println("---------------------");
        }
    }
}
