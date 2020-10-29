package nl.inholland.tentamen.teijevanhemert.repository;

import nl.inholland.tentamen.teijevanhemert.model.Concert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends CrudRepository<Concert, Long>
{
    //@Query("select c from Car c, Driver d where c.driver.id = d.id and d.wonBefore = :hasWon")
    @Query("select c from Concert c, Venue v where c.venue.id = v.id and v.country = :country")
    List<Concert> GetConcertsByCountry(String country);
}
