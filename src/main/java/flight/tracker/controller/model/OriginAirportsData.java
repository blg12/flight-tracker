package flight.tracker.controller.model;


import flight.tracker.entity.OriginAirports;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OriginAirportsData {
		
		private Long airportId;
		private String originCity;
		private String originCountry;
		
	public OriginAirportsData(OriginAirports airports) {
		airportId = airports.getOriginAirportId();
		originCity = airports.getOriginCity();
		originCountry = airports.getOriginCountry();
		
	}
}
