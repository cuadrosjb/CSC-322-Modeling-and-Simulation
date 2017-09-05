package com.jcuadros.homework.one;

public class Process {
	
	private int arrival;
	private int startOfService;
	private int delayBeforeStartOfService;
	private int endOfService;
	private int serviceTime;
	private int waitTime;
	
	public Process(int ai, int si){
		this.arrival = ai;
		this.serviceTime = si;
	}

	public Process(int arrival, int startOfService, int delayBeforeStartOfService, int endOfService, int serviceTime,
			int waitTime) {
		this.arrival = arrival;
		this.startOfService = startOfService;
		this.delayBeforeStartOfService = delayBeforeStartOfService;
		this.endOfService = endOfService;
		this.serviceTime = serviceTime;
		this.waitTime = waitTime;
	}
	
	public void generate(){
		
	}
	

	public int getArrival() {
		return arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	public int getStartOfService() {
		return startOfService;
	}

	public void setStartOfService(int startOfService) {
		this.startOfService = startOfService;
	}

	public int getDelayBeforeStartOfService() {
		return delayBeforeStartOfService;
	}

	public void setDelayBeforeStartOfService(int delayBeforeStartOfService) {
		this.delayBeforeStartOfService = delayBeforeStartOfService;
	}

	public int getEndOfService() {
		return endOfService;
	}

	public void setEndOfService(int endOfService) {
		this.endOfService = endOfService;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public String toString() {
		return "Process [arrival=" + arrival + ", startOfService=" + startOfService + ", delayBeforeStartOfService="
				+ delayBeforeStartOfService + ", endOfService=" + endOfService + ", serviceTime=" + serviceTime
				+ ", waitTime=" + waitTime + "]";
	}
	
	
	
	

}
