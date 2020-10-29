package nl.inholland.tentamen.teijevanhemert.repository;

import nl.inholland.tentamen.teijevanhemert.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long>
{
    @Query("select v from Venue v where v.name = :name")
    Venue findVenueByName(String name);
}
