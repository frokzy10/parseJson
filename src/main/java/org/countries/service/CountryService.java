package org.countries.service;

import com.google.gson.Gson;
import org.countries.model.Cafes;
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
import java.util.stream.Collectors;

public class CountryService {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/nurdinbakytbekov/Desktop/jsonLearn/src/main/java/org/countries/dbCountry/country.json");
        BufferedReader br = new BufferedReader(new FileReader(file));
        Gson gson = new Gson();

        Country country = gson.fromJson(br, Country.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название отеля: ");
        String hotelName = scanner.nextLine();

        System.out.println("Введите название кафе: ");
        String cafeName = scanner.nextLine();

        // Собираем все отели и кафе в один список
        List<Cities> citiesList = country.getCities();
        List<Hotels> allHotels = citiesList.stream()
                .flatMap(cities -> cities.getHotels().stream())
                .sorted(Comparator.comparing(Hotels::getName))
                .collect(Collectors.toList());

        List<Cafes> allCafes = citiesList.stream()
                .flatMap(cities -> cities.getCafes().stream())
                .sorted(Comparator.comparing(Cafes::getCafeName))
                .collect(Collectors.toList());

        Hotels foundHotel = findByNameHotel(allHotels, hotelName);
        if (foundHotel != null) {
            System.out.println("Отель найден: " + foundHotel);
        } else {
            System.out.println("Отель '" + hotelName + "' не найден.");
        }

        Cafes foundCafe = findByCafeName(allCafes, cafeName);
        if (foundCafe != null) {
            System.out.println("Кафе найдено: " + foundCafe);
        } else {
            System.out.println("Кафе '" + cafeName + "' не найдено.");
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
    private static Cafes findByCafeName(List<Cafes> cafesList,String cafeName){
        int min = 0;
        int max = cafesList.size() - 1;
        while (min <= max){
            int mid = (max + min) / 2;
            Cafes midCafe = cafesList.get(mid);
            int comp = midCafe.getCafeName().compareToIgnoreCase(cafeName);
            if (comp == 0){
                return midCafe;
            }else if (comp < 0){
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return null;
    }
}