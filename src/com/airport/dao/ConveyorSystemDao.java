package com.airport.dao;

import java.util.ArrayList;
import java.util.List;

import com.airport.domain.ConveyorSystem;

public class ConveyorSystemDao {
	static List<ConveyorSystem> mockedData = new ArrayList<>();
	
	public List<ConveyorSystem> getConveyorSystemData() {
		buildMockupData();
		return mockedData;
	}
	
	//in real system this data should come from database. These should be part of application meta-data
	void buildMockupData() {		
		if (mockedData.isEmpty()) { //this is static data. So it should be cached after loading from database
			ConveyorSystem record1 = new ConveyorSystem("Concourse_A_Ticketing", "A5", 5);
			mockedData.add(record1);
			ConveyorSystem record2 = new ConveyorSystem("A5", "BaggageClaim", 5);
			mockedData.add(record2);
			ConveyorSystem record3 = new ConveyorSystem("A5", "A10", 4);
			mockedData.add(record3);
			ConveyorSystem record4 = new ConveyorSystem("A5", "A1", 6);
			mockedData.add(record4);
			ConveyorSystem record5 = new ConveyorSystem("A1", "A2", 1);
			mockedData.add(record5);
			ConveyorSystem record6 = new ConveyorSystem("A2", "A3", 1);
			mockedData.add(record6);
			ConveyorSystem record7 = new ConveyorSystem("A3", "A4", 1);
			mockedData.add(record7);
			ConveyorSystem record8 = new ConveyorSystem("A10", "A9", 1);
			mockedData.add(record8);
			ConveyorSystem record9 = new ConveyorSystem("A9", "A8", 1);
			mockedData.add(record9);
			ConveyorSystem record10 = new ConveyorSystem("A8", "A7", 1);
			mockedData.add(record10);
			ConveyorSystem record11 = new ConveyorSystem("A7", "A6", 1);
			mockedData.add(record11);	
		}
	}
}
