package com.jcuadros.homework.three;

public class Job {

	private int seed;
	private double wbar;
	
	public Job(){};
	
	public Job(int seed, int wbar){
		this.seed = seed;
		this.wbar = wbar;
	}

	public int getSeed() {
		return seed;
	}

	public void setSeed(int seed) {
		this.seed = seed;
	}

	public double getWbar() {
		return wbar;
	}

	public void setWbar(double wbar) {
		this.wbar = wbar;
	}
	
}
