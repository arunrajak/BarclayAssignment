package com.airport.graph;

public class Vertex implements Comparable<Vertex> {
	final private String id;
    final private String name;


    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
    	return name;
    }
    
    @Override
    public String toString() {
        return id+":"+name;
    }
	@Override
	public int compareTo(Vertex o) {
		return this.id.compareTo(o.id);
	}

}
