package flight.tracker.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class FlightNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long flightNumberId;
	private Long flightNumber;

	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "destination_airport_id")
	private DestinationAirports destinationAirport;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "origin_airport_id")
	private OriginAirports originAirport;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "airline_flight_path", 
	joinColumns = @JoinColumn(name = "airline_id"), 
	inverseJoinColumns = @JoinColumn(name = "flight_path_id"))
	Set<Airlines> airlines = new HashSet<>();
	
}
