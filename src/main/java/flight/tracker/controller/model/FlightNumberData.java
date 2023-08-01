package flight.tracker.controller.model;

import java.util.HashSet;
import java.util.Set;
import flight.tracker.entity.Airlines;
import flight.tracker.entity.DestinationAirports;
import flight.tracker.entity.OriginAirports;
import flight.tracker.entity.FlightNumber;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FlightNumberData {

	private Long flightNumberId;
	private Long flightNumber;
	private DestinationAirports destinationAirport;
	private OriginAirports originAirport;
	
	
	
	public FlightNumberData(FlightNumber flightNumber) {
		flightNumberId = flightNumber.getFlightNumberId();
		destinationAirport = flightNumber.getDestinationAirport();
		originAirport = flightNumber.getOriginAirport();
	}
}
