package com.airport.test;

import com.airport.dao.FlightDao;
import com.airport.domain.Flight;

import junit.framework.TestCase;

public class FlightDaoTest extends TestCase {
	
	public void testScenario1() {
        FlightDao flightDao = new FlightDao();
        Flight flight = flightDao.getFlight("UA17");
        assertTrue(flight.getFlightId().equalsIgnoreCase("UA17"));               
    }
	
	public void testScenario2() {
        FlightDao flightDao = new FlightDao();
        Flight flight = flightDao.getFlight("UA1898");
        assertTrue(flight == null);
    }
}
