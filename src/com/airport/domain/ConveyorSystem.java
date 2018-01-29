package com.airport.domain;

import java.io.Serializable;

public class ConveyorSystem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String node1;
	private String node2;
	private int duration;
	
	public ConveyorSystem (String node1, String node2, int duration) {
		this.node1 = node1;
		this.node2 = node2;
		this.duration = duration;
	}
	
	
	public String getNode1() {
		return node1;
	}
	public void setNode1(String node1) {
		this.node1 = node1;
	}
	public String getNode2() {
		return node2;
	}
	public void setNode2(String node2) {
		this.node2 = node2;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
