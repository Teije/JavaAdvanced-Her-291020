package nl.inholland.tentamen.teijevanhemert.service;

import nl.inholland.tentamen.teijevanhemert.model.Venue;
import nl.inholland.tentamen.teijevanhemert.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService
{
    private VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository)
    {
        this.venueRepository = venueRepository;
    }

    public int GetCapacity()
    {
        List<Venue> venues = (List<Venue>) venueRepository.findAll();
        return venues.stream()
                .mapToInt(Venue::getCapacity)
                .sum();
    }
}
