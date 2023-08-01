package flight.tracker.service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import flight.tracker.controller.model.AirlinesData;
import flight.tracker.controller.model.DestinationAirportsData;
import flight.tracker.controller.model.FlightNumberData;
import flight.tracker.controller.model.OriginAirportsData;
import flight.tracker.dao.AirlinesDao;
import flight.tracker.dao.DestinationAirportsDao;
import flight.tracker.dao.OriginAirportsDao;
import flight.tracker.dao.FlightNumberDao;
import flight.tracker.entity.Airlines;
import flight.tracker.entity.DestinationAirports;
import flight.tracker.entity.FlightNumber;
import flight.tracker.entity.OriginAirports;

@Service
public class FlightNumberService {

	@Autowired
	private FlightNumberDao flightNumberDao;

	@Autowired
	private AirlinesDao airlinesDao;

	@Autowired
	private OriginAirportsDao originAirportsDao;

	@Autowired
	private DestinationAirportsDao destinationAirportsDao;

	// Create flight number
	@Transactional
	public FlightNumberData saveFlightNumber(Long originAirportId, Long destinationAirportId, FlightNumberData flightNumberData) {
		Long flightNumberId = flightNumberData.getFlightNumberId();
		FlightNumber flightNumber = findOrCreateFlightNumber(flightNumberId);
		DestinationAirports destinationAirport = destinationAirport.findDestinationAirportById(destinationAirportId);
		OriginAirports originAirport = originAirport.findOriginAirportById(originAirportId);
		copyFlightNumberFields(flightNumber, flightNumberData);
		FlightNumber.setOriginAirport(originAirport);
		FlightNumber.setDestinationAirport(destinationAirport);
		destinationAirport.getDestinationFlightNumber().add(flightNumber);
		originAirport.getOriginFlightNumber().add(flightNumber);
		FlightNumber savedFlightNumber = flightNumberDao.save(flightNumber);
		return new FlightNumberData(savedFlightNumber);
	}

	private FlightNumber findOrCreateFlightNumber(Long flightNumberId) {
		FlightNumber flightNumber;

		if (Objects.isNull(flightNumberId)) {
			flightNumber = new FlightNumber();
		} else {
			flightNumber = findFlightNumberById(flightNumberId);
		}
		return flightNumber;
	}

	private void copyFlightNumberFields(FlightNumber flightNumber, FlightNumberData flightNumberData) {
		flightNumber.setFlightNumber(flightNumberData.getFlightNumberId());
		flightNumber.setDestinationAirport(flightNumberData.getDestinationAirport());
		flightNumber.setOriginAirport(flightNumberData.getOriginAirport());

	}

	private FlightNumber findFlightNumberById(Long flightNumberId) {
		return flightNumberDao.findById(flightNumberId).orElseThrow(
				() -> new NoSuchElementException("Flight Path with ID=" + flightNumberId + " does not exist."));
	}

	// create Airlines
	@Transactional
	public AirlinesData saveAirlines(AirlinesData airlinesData) {
		Long airlineId = airlinesData.getAirlineId();
		Airlines airlines = findOrCreateAirlines(airlineId);
		copyAirlinesFields(airlines, airlinesData);
		Airlines savedAirlines = airlinesDao.save(airlines);
		return new AirlinesData(savedAirlines);
	}

	private void copyAirlinesFields(Airlines airlines, AirlinesData airlinesData) {
		airlines.setAirlineId(airlinesData.getAirlineId());
		airlines.setAirlineName(airlinesData.getAirlineName());

	}

	private Airlines findOrCreateAirlines(Long airlineId) {
		Airlines airline;
		if (Objects.isNull(airlineId)) {
			airline = new Airlines();

		} else {
			airline = findAirlineById(airlineId);
		}
		return airline;
	}

	private Airlines findAirlineById(Long airlineId) {
		
		return airlinesDao.findById(airlineId)
				.orElseThrow(() -> new NoSuchElementException(
						"Airline with ID=" + airlineId + "was not found.")); 
	}
	
	public DestinationAirportsData saveDestinationAirports(DestinationAirportsData destinationAirportsData) {
		Long destinationAirportId = destinationAirportsData.getDestinationAirportId();
		DestinationAirports destinationAirports = findOrCreateDestinationAirports(destinationAirportId);
		copyDestinationAirportsFields(destinationAirports, destinationAirportsData);
		DestinationAirports savedDestinationAirports = destinationAirportsDao.save(destinationAirports);
		return new DestinationAirportsData(savedDestinationAirports);
	}
	
	private void copyDestinationAirportsFields(DestinationAirports destinationAirports,
			DestinationAirportsData destinationAirportsData) {
		destinationAirports.setDestinationAirportId(destinationAirports.getDestinationAirportId());
		destinationAirports.setDestinationCity(destinationAirports.getDestinationCity());
		destinationAirports.setDestinationCountry(destinationAirports.getDestinationCountry());
	}

	private DestinationAirports findOrCreateDestinationAirports(Long destinationAirportId) {
		DestinationAirports destinationAirport;
		if (Objects.isNull(destinationAirportId)) {
			destinationAirport = new DestinationAirports();
			
		} else {
			destinationAirport = findDestinationAirportById(destinationAirportId);
		}
		return destinationAirport;
	}

	private DestinationAirports findDestinationAirportById(Long destinationAirportId) {
		
		return destinationAirportsDao.findById(destinationAirportId)
				.orElseThrow(() -> new NoSuchElementException(
						"Destination Airport with ID=" + destinationAirportId + "was not found."));
	}
	
	public OriginAirportsData saveOriginAirports(OriginAirportsData originAirportsData) {
		Long originAirportId = originAirportsData.getOriginAirportId();
		OriginAirports OriginAirports = findOrCreateOriginAirports(originAirportId);
		copyOriginAirportsFields(OriginAirports, originAirportsData);
		OriginAirports savedOriginAirports = originAirportsDao.save(OriginAirports);
		return new OriginAirportsData(savedOriginAirports);
	}
	private void copyOriginAirportsFields(OriginAirports originAirports, OriginAirportsData originAirportsData) {
		originAirports.setOriginAirportId(originAirports.getOriginAirportId());
		originAirports.setOriginCity(originAirports.getOriginCity());
		originAirports.setOriginCountry(originAirports.getOriginCountry());
	}

	private OriginAirports findOrCreateOriginAirports(Long originAirportId) {
		OriginAirports originAirport;
		if (Objects.isNull(originAirportId)) {
			originAirport = new OriginAirports();
			
		} else {
			originAirport = findOriginAirportById(originAirportId);
		}
		return originAirport;
	}

	private OriginAirports findOriginAirportById(Long originAirportId) {
		
		return originAirportsDao.findById(originAirportId)
				.orElseThrow(() -> new NoSuchElementException(
						"Destination Airport with ID=" + originAirportId + "was not found."));
}
}
