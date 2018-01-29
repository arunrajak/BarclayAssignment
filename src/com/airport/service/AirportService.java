package com.airport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.airport.dao.ConveyorSystemDao;
import com.airport.dao.FlightDao;
import com.airport.domain.ConveyorSystem;
import com.airport.domain.Flight;
import com.airport.domain.Route;
import com.airport.graph.DijkstraAlgorithm;
import com.airport.graph.Edge;
import com.airport.graph.Vertex;

public class AirportService {
	ConveyorSystemDao conveyorSystDao = new ConveyorSystemDao();
	FlightDao flightDao = new FlightDao();
	
	public Route findRoute(String source, String destination) {
		Route optimalRoute = new Route();
		List<ConveyorSystem> conveyorSystemData = conveyorSystDao.getConveyorSystemData();
		//build list of unique Vertex
		List<Vertex> node1 = conveyorSystemData.stream().map(s->s.getNode1()).collect(Collectors.toList()).stream().map(s->new Vertex(s, s)).collect(Collectors.toList());
		List<Vertex> node2 = conveyorSystemData.stream().map(s->s.getNode2()).collect(Collectors.toList()).stream().map(s->new Vertex(s, s)).collect(Collectors.toList());
		Set<Vertex> vertex = new TreeSet<>((o1, o2)->o1.compareTo(o2));
		vertex.addAll(node1);
		vertex.addAll(node2);
		List<Vertex> nodes = new ArrayList<>();
		nodes.addAll(vertex);
		Map<String, Vertex> vertexMap = new HashMap<>();
		vertex.forEach(v->vertexMap.put(v.getId(), v));
		
		//build list of edges. Since its bi-directional graph, created edge for both directions
		List<Edge> edges = new ArrayList<>();
		conveyorSystemData.forEach(s->edges.add(new Edge(s.getNode1()+":"+s.getNode2(), vertexMap.get(s.getNode1()), vertexMap.get(s.getNode2()), s.getDuration())));
		conveyorSystemData.forEach(s->edges.add(new Edge(s.getNode2()+":"+s.getNode1(), vertexMap.get(s.getNode2()), vertexMap.get(s.getNode1()), s.getDuration())));
		
		if (source.equalsIgnoreCase(destination)) { // if source and destination are same, then don't invoke algorithm.
			List<Vertex> path = new LinkedList<>();
			path.add(vertexMap.get(source));
			path.add(vertexMap.get(destination));
			optimalRoute.setPath(path);
	        optimalRoute.setDuration(0);
		} else {
			//call algorithm to find optimal path
			DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(edges);
			
			if (vertexMap.get(source) != null && vertexMap.get(destination) != null) {
		        dijkstra.execute(vertexMap.get(source));
		        List<Vertex> path = dijkstra.getPath(vertexMap.get(destination));
		        int duration = dijkstra.getFinalDuration(vertexMap.get(destination));
		        optimalRoute.setPath(path);
		        optimalRoute.setDuration(duration);
			}
		}
		
        return optimalRoute;
	}
	
	public Flight getFlightData(String flightId) {
		return flightDao.getFlight(flightId);
	}
	
	//Test method
	public static void main(String args[]) {
		AirportService service = new AirportService();
		
		Route routeFound = service.findRoute("A7", "BaggageClaim");

		System.out.println("Duration: "+routeFound.getDuration());
		routeFound.getPath().forEach(System.out::println);
		
		routeFound = service.findRoute("A7", "A7");

		System.out.println("Duration: "+routeFound.getDuration());
		routeFound.getPath().forEach(System.out::println);
	}
}
