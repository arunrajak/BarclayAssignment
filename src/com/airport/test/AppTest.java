package com.airport.test;

import com.airport.domain.Route;
import com.airport.service.AirportService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(AppTest.class, FlightDaoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testScenario1()
    {
    	AirportService service = new AirportService();
    	Route route = service.findRoute("A5", "A5");
    	assertTrue(route.getDuration()==0);
    }
    
    public void testScenario2()
    {
    	AirportService service = new AirportService();
    	Route route = service.findRoute("A1", "A2");
    	assertTrue(route.getDuration()==1);
    }
}
