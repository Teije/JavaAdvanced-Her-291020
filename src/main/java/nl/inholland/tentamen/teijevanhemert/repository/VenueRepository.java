package nl.inholland.tentamen.teijevanhemert.repository;

import nl.inholland.tentamen.teijevanhemert.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long>
{

}
