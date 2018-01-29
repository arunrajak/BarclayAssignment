package com.airport.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.airport.domain.Flight;

public class FlightDao {
	List<Flight> mockedData = new ArrayList<>();
	
	public Flight getFlight(String flightId) {
		buildMockupData();
		
		List<Flight> flights = mockedData.stream().filter(flight->flightId.equalsIgnoreCase(flight.getFlightId())).collect(Collectors.toList());
		
		if (flights.size() > 0) {
			return flights.get(0);
		} else {
			return null;
		}
	}
	
	//in real system this data should come from system that is handling terminal assignment
	void buildMockupData() {		
		if (mockedData.isEmpty()) { 
			Flight record1 = new Flight("UA10", "A1", "MIA", "08:00");
			mockedData.add(record1);	
			Flight record2 = new Flight("UA11", "A1", "LAX", "09:00");
			mockedData.add(record2);
			Flight record3 = new Flight("UA12", "A1", "JFK", "09:45");
			mockedData.add(record3);
			Flight record4 = new Flight("UA13", "A2", "JFK", "08:30");
			mockedData.add(record4);
			Flight record5 = new Flight("UA14", "A2", "JFK", "09:45");
			mockedData.add(record5);
			Flight record6 = new Flight("UA15", "A2", "JFK", "10:00");
			mockedData.add(record6);
			Flight record7 = new Flight("UA16", "A3", "JFK", "09:00");
			mockedData.add(record7);
			Flight record8 = new Flight("UA17", "A4", "MHT", "09:15");
			mockedData.add(record8);
			Flight record9 = new Flight("UA18", "A5", "LAX", "10:15");
			mockedData.add(record9);
		}
	}
}
