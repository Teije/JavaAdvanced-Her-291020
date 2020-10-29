package nl.inholland.tentamen.teijevanhemert.service;

import nl.inholland.tentamen.teijevanhemert.model.Concert;
import nl.inholland.tentamen.teijevanhemert.repository.ConcertRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ConcertService
{
    private ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository)
    {
        this.concertRepository = concertRepository;
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
}
