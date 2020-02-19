package heroku_demo.repository;

import heroku_demo.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    List <Reservation> findAll();
}
