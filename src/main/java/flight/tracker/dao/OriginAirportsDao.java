package flight.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flight.tracker.entity.OriginAirports;

public interface OriginAirportsDao extends JpaRepository<OriginAirports, Long> {

}
