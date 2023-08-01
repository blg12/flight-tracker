package flight.tracker.controller.model;

import java.util.HashSet;
import java.util.Set;

import flight.tracker.entity.Airlines;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AirlinesData {

	private Long airlineId;
	private String airlineName;
	private Set<Airlines> airlines = new HashSet<>();
	
	public AirlinesData(Airlines airlines) {
		airlineId = airlines.getAirlineId();
		airlineName = airlines.getAirlineName();
				
	}
}
