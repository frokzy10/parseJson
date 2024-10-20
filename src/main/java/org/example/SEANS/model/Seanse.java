package org.example.SEANS.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Seanse {
    public String name;
    public String locate;
    public String metro;
    public List<Sessions> sessions;
}
