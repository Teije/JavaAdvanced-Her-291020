package nl.inholland.tentamen.teijevanhemert.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Concert
{
    @Id
    @SequenceGenerator(name = "concert_seq", initialValue = 5000001, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "concert_seq")
    private long id;
    private String artist;
    private LocalDate date;

    @OneToOne
    Venue venue;

    public Concert(Venue venue, String artist, LocalDate date)
    {
        this.venue = venue;
        this.artist = artist;
        this.date = date;
    }
}
