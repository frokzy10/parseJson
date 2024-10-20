package org.countries.service;

import com.google.gson.Gson;
import org.countries.model.Cities;
import org.countries.model.Country;
import org.countries.model.Hotels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CountryService {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/nurdinbakytbekov/Desktop/jsonLearn/src/main/java/org/countries/dbCountry/country.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Gson gson = new Gson();

        Country country = gson.fromJson(br, Country.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название отеля: ");
        String hotelName = scanner.nextLine();

        List<Cities> citiesList = country.getCities();
        List<Hotels> allHotels = citiesList.stream()
                .flatMap(cities -> cities.getHotels().stream())
                .sorted(Comparator.comparing(Hotels::getName))
                .toList();

        Hotels foundH = findByNameHotel(allHotels,hotelName);
        if (foundH != null){
            System.out.println("Отель найден: " + foundH);
        }else{
            System.out.println("Отель не найден: " + hotelName + " не найден");
        }
    }
    private static Hotels findByNameHotel(List<Hotels> hotelList,String hotelName){
        int min = 0;
        int max = hotelList.size() - 1;

        while (min <= max){
            int mid = (max + min) / 2;
            Hotels midHotel = hotelList.get(mid);

            int comp = midHotel.getName().compareToIgnoreCase(hotelName);

            if (comp == 0){
                return midHotel;
            }else if (comp < 0){
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        return null;
    }
}