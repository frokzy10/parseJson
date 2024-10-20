package org.countries.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Cities {
    public String _id;
    public String name;
    public int population;
    public String descriptions;
    public List<Hotels> hotels;
    public List<Cafes> cafes;
    public List<Attractions> attractions;
}
