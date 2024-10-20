package org.countries.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Attractions {
    public String description;
    public String history;
    public String image;
    public String name;
    public String street;
    public String time;
    public int year;
    public String _id;
    public boolean isAttraction;
}
