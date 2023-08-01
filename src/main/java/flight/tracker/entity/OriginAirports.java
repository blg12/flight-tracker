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
public class OriginAirports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long originAirportId;
	private String originCity;
	private String originCountry;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "originAirport", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<FlightNumber> originFlightNumber = new HashSet<>();


}
	



