package org.example.start.JsonSimple;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainClass {
    public static void main(String[] args) throws IOException, ParseException {
        File file = new File("/Users/nurdinbakytbekov/Desktop/jsonLearn/src/main/java/org/example/db.json");

        BufferedReader br = new BufferedReader(new FileReader(file));
        Object obj = new JSONParser().parse(br);
        JSONObject ho = (JSONObject) obj;
        String firstName = (String) ho.get("firstName");
        String lastName = (String) ho.get("lastName");
        System.out.println("ФИО: " + firstName + " " + lastName);

        JSONArray phonesNum = (JSONArray) ho.get("phoneNumbers");
        Iterator iterator = phonesNum.iterator();

        while (iterator.hasNext()) {
            JSONObject test = (JSONObject) iterator.next();
            System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
        }
    }
}
