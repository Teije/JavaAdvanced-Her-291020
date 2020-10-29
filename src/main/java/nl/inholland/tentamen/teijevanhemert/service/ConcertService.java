package nl.inholland.tentamen.teijevanhemert.service;

import nl.inholland.tentamen.teijevanhemert.dto.ConcertDTO;
import nl.inholland.tentamen.teijevanhemert.model.Concert;
import nl.inholland.tentamen.teijevanhemert.model.Venue;
import nl.inholland.tentamen.teijevanhemert.repository.ConcertRepository;
import nl.inholland.tentamen.teijevanhemert.repository.VenueRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ConcertService
{
    private ConcertRepository concertRepository;
    private VenueRepository venueRepository;

    public ConcertService(ConcertRepository concertRepository, VenueRepository venueRepository)
    {
        this.concertRepository = concertRepository;
        this.venueRepository = venueRepository;
    }

    public Concert GetConcertById(long id)
    {
        var driver = concertRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No concert could be found with this id: " + id));

        return driver;
    }

    public List<Concert> GetConcertsByCountry(String country) {
        return concertRepository.GetConcertsByCountry(country);
    }

    public Concert CreateConcert(ConcertDTO concertDTO)
    {
        Venue venue = venueRepository.findVenueByName(concertDTO.getVenueName());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Concert concert = new Concert(
                venue,
                concertDTO.getArtist(),
                LocalDate.parse(concertDTO.getDate(), dateTimeFormatter)
        );
        return concertRepository.save(concert);
    }
}
