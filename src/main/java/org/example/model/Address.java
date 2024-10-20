package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
    public String street;
    public String city;
    public String state;
    public int postalCode;
}
