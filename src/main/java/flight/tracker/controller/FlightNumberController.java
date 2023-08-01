package flight.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import flight.tracker.controller.model.FlightNumberData;
import flight.tracker.service.FlightNumberService;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/flight_tracker")
@Slf4j
public class FlightNumberController {

	@Autowired
	private FlightNumberService flightNumberService;
	
	//Create a flight path
	@PostMapping("/flight_number")
	@ResponseStatus(code = HttpStatus.CREATED)
	public FlightNumberData createFlightNumber (
			@RequestBody FlightNumberData flightNumberData) {
		log.info("Creating the Flight Path {}", flightNumberData);
		
		return flightNumberService.saveFlightNumber(flightNumberData);
	}
		
	//Update a flight path
	@PutMapping("/flight_number,{flightNumberId}")
	public FlightNumberData updateFlightNumber (
			@PathVariable Long flightNumberId, @RequestBody FlightNumberData flightNumberData) {
			flightNumberData.setFlightNumberId(flightNumberId);
			log.info("Updating the flight path {}", flightNumberData);
			return flightNumberService.saveFlightNumber(flightNumberData);
			
	
			
			
	}
	
}
