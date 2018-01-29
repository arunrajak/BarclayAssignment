package com.airport.application;

import java.util.stream.Collectors;

import com.airport.domain.Flight;
import com.airport.domain.Route;
import com.airport.service.AirportService;

public class CalculateRoute {
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Please check input data.");
			return;
		}
		String bagId = args[0];
		String entryPoint = args[1];
		String flightId = args[2];
		 
		AirportService airportService = new AirportService();
		
		Flight flight = airportService.getFlightData(flightId);
		
		if (flight == null && !"ARRIVAL".equalsIgnoreCase(flightId)) {
			System.out.println(flightId + " flight not found.");
		} else {	
			String flightGate = "";
			if ("ARRIVAL".equalsIgnoreCase(flightId)) {
				flightGate = "BaggageClaim";
			} else {
				flightGate = flight.getFlightGate();
			}
			Route routeFound = airportService.findRoute(entryPoint, flightGate);
			if (routeFound.getDuration() >= 0) {
				String path = routeFound.getPath().stream().map(v->v.getName()).collect(Collectors.joining(" "));			
				System.out.println(bagId + " " + path + " " + routeFound.getDuration());
			} else {
				System.out.println("invalid data entered.");
			}
		}
		
	}
}
