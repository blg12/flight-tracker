package flight.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import flight.tracker.entity.FlightNumber;

@Repository
public interface FlightNumberDao extends JpaRepository<FlightNumber, Long> {

}
