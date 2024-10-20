package org.countries.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Country {
    public String _id;
    public String country;
    public String description;
    public List<Cities> cities;
    public List<String> images;
}
