package nl.inholland.tentamen.teijevanhemert.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Venue
{
    @Id
    @SequenceGenerator(name = "venue_seq", initialValue = 1000001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venue_seq")
    private long id;
    private String name;
    private String city;
    Country country;
    int capacity;

    public Venue(String name, String city, Country country, int capacity)
    {
        this.name = name;
        this.city = city;
        this.country = country;
        this.capacity = capacity;
    }
}
