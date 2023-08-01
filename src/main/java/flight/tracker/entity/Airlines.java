package flight.tracker.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Airlines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long airlineId;
	private String airlineName;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "airlines")
	Set<FlightNumber> flightPaths = new HashSet<>();
}
