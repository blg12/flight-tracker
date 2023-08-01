package flight.tracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import flight.tracker.entity.Airlines;

public interface AirlinesDao extends JpaRepository<Airlines, Long> {

}
