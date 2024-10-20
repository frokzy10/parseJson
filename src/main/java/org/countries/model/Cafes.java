package org.countries.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Cafes {
    public String _id;
    public boolean isCafes;
    public String cafeName;
    public String cafeRating;
    public CafeSocial cafeSocial;
    public CafeStreet cafeStreet;
    public String cafeDescription;
    public String cafeImage;
    public String cafeTime;
    public CafeMeal[] cafeMeals;

    public static class CafeSocial {
        public String website;
        public String instagram;
    }

    public static class CafeStreet {
        public String name;
        public String address;
    }

    public static class CafeMeal {
        public String _id;
        public String name;
        public String image;
        public String description;
    }
}