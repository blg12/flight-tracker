package flight.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flight.tracker.entity.DestinationAirports;

public interface DestinationAirportsDao extends JpaRepository<DestinationAirports, Long> {

}
