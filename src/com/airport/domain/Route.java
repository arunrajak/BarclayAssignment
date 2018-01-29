package com.airport.domain;

import java.io.Serializable;
import java.util.List;

import com.airport.graph.Vertex;

public class Route implements Serializable{
	
	private static final long serialVersionUID = 3L;
	
	private List<Vertex> path;
	private int duration = -1;
	
	public List<Vertex> getPath() {
		return path;
	}
	public void setPath(List<Vertex> path) {
		this.path = path;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
