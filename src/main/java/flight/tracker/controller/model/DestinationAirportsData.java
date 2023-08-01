package flight.tracker.controller.model;

import java.util.HashSet;
import java.util.Set;

import flight.tracker.entity.FlightNumber;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class DestinationAirportsData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long destinationAirportId;
	private String destinationCity;
	private String destinationCountry;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "destinationAirport")
	Set<FlightNumber> destinationFlightPaths = new HashSet<>();
}
