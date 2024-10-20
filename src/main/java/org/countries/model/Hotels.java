package org.countries.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Hotels {
    public String name;
    public int costAnHour;
    public String image;
    public String _id;
    public boolean isHotel;
    public String description;
}
