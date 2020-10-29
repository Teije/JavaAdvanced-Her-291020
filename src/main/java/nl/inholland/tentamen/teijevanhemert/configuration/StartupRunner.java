package nl.inholland.tentamen.teijevanhemert.configuration;

import lombok.extern.java.Log;
import nl.inholland.tentamen.teijevanhemert.model.Concert;
import nl.inholland.tentamen.teijevanhemert.model.Country;
import nl.inholland.tentamen.teijevanhemert.model.Venue;
import nl.inholland.tentamen.teijevanhemert.repository.ConcertRepository;
import nl.inholland.tentamen.teijevanhemert.repository.VenueRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@Log
public class StartupRunner implements ApplicationRunner
{
    private VenueRepository venueRepository;
    private ConcertRepository concertRepository;

    public StartupRunner(VenueRepository venueRepository, ConcertRepository concertRepository)
    {
        this.venueRepository = venueRepository;
        this.concertRepository = concertRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        List<String> venues = Files.readAllLines(Paths.get("venues.csv"));
        venues.forEach(
                venue ->
                        venueRepository.save(
                                new Venue
                                        (
                                            venue.split(",")[0], // Name
                                            venue.split(",")[1], // City
                                            Country.valueOf(venue.split(",")[2]), // Country
                                            Integer.parseInt(venue.split(",")[3]) // Capacity
                                        )
                                )
                        );

        venueRepository.findAll().forEach(System.out::println);
        log.info("--- Exam Question 2 completed");

        List<String> concerts = Files.readAllLines(Paths.get("concerts.csv"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        concerts.forEach(
                concert ->
                        concertRepository.save(
                                // String artist, LocalDate date, Venue venue
                                new Concert(
                                    venueRepository.findVenueByName(concert.split(",")[0]), // Venue
                                    concert.split(",")[1], // Artist
                                    LocalDate.parse(concert.split(",")[2], dateTimeFormatter) // Date
                                )
                        )
        );

        concertRepository.findAll().forEach(System.out::println);
        log.info("--- Exam Question 3 completed ---");
    }
}
