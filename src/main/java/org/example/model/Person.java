package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Person{
    public String firstName;
    public String lastName;
    public int age;
    public Address address;
    public List<Phones> phoneNumbers;
    public List<Person> friends;
}
