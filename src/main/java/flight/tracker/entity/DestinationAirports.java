package flight.tracker.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class DestinationAirports {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long destinationAirportId;
	private String destinationCity;
	private String destinationCountry;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "destinationAirport", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<FlightNumber> destinationFlightNumber = new HashSet<>();
}
