package nl.inholland.tentamen.teijevanhemert.repository;

import nl.inholland.tentamen.teijevanhemert.model.Concert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertRepository extends CrudRepository<Concert, Long>
{

}
