package nl.inholland.tentamen.teijevanhemert.configuration;

import lombok.extern.java.Log;
import nl.inholland.tentamen.teijevanhemert.model.Country;
import nl.inholland.tentamen.teijevanhemert.model.Venue;
import nl.inholland.tentamen.teijevanhemert.repository.VenueRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@Log
public class StartupRunner implements ApplicationRunner
{
    private VenueRepository venueRepository;

    public StartupRunner(VenueRepository venueRepository)
    {
        this.venueRepository = venueRepository;
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
    }
}
