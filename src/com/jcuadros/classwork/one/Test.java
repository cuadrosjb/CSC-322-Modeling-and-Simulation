package com.jcuadros.classwork.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

	public static double START = 0.0;

	private static int arrivalIndex = 0;
	private static int serviceIndex = 0;

	private static List<Double> arrival;
	private static List<Double> serviceTime;

	private static DecimalFormat df3 = new DecimalFormat(".###");
	
//	private static double lBar;
//	private static double qBar;
//	private static double xBar;

	public static void main(String[] args) {

		long index = 0; 			/* job index */
		double arrival = START; 	/* arrival time */
		double delay; 				/* delay in queue */
		double service; 			/* service time */
		double wait; 				/* delay + service */
		double departure = START; 	/* departure time */
		
		double ci = 0.0;

		PrivateStruct sum = new PrivateStruct(0.0, 0.0, 0.0);

		try {
			setArrArrival();
			setArrServicio();
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (index < Test.arrival.size()) {
			
			arrival = getArrival();
			if (arrival < departure)
				delay = departure - arrival; /* delay in queue */
			else
				delay = 0.0; /* no delay */
			service = getService();
			wait = delay + service;
			departure = arrival + wait; /* time of departure */
			sum.delay += delay;
			sum.wait += wait;
			sum.service += service;
			
			ci = Double.parseDouble(df3.format(arrival)) +  Double.parseDouble(df3.format(delay)) +  Double.parseDouble(df3.format(service));
			
			if(index > 998){
				System.out.println("arr: " + arrival);
				System.out.println("delay: " + delay);
				System.out.println("service: " + service);
			}
			
			index++;
		}
		
		System.out.println("ci: " + ci);
		
		
		sum.interarrival = arrival - START;

		System.out.println("\nfor " + index + " jobs\n");
		System.out.println("   average interarrival time = " + df3.format(sum.interarrival / index) + "\n");
		System.out.println("   average service time .... = " + df3.format(sum.service / index) + "\n");
		System.out.println("   average delay ........... = " + df3.format(sum.delay / index) + "\n");
		System.out.println("   average wait ............ = " + df3.format(sum.wait / index) + "\n");
		
//		System.out.println("ci: " + ci + "; sum.service: " + sum.service);	
		
		System.out.println("   l BAR ............ = " + df3.format((1000 * Double.parseDouble(df3.format(sum.wait / index)))/ci) + "\n");
		System.out.println("   q BAR ............ = " + df3.format((1000 * Double.parseDouble(df3.format(sum.delay / index)))/ci) + "\n");
		System.out.println("   x BAR ............ = " + df3.format((1000 * Double.parseDouble(df3.format(sum.service / index)))/ci) + "\n");
		

	}

	public static void setArrArrival() throws IOException {
		arrival = new ArrayList<Double>();
		BufferedReader br = new BufferedReader(new FileReader("src/ssq1.dat"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				line = line.substring(0, line.lastIndexOf(" ")).trim();
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}

			StringTokenizer st = new StringTokenizer(sb.toString(), System.lineSeparator());

			while (st.hasMoreTokens()) {
				arrival.add(Double.parseDouble(st.nextToken().trim()));
			}

		} finally {
			br.close();
		}

	}

	public static void setArrServicio() throws IOException {
		serviceTime = new ArrayList<Double>();
		BufferedReader br = new BufferedReader(new FileReader("src/ssq1.dat"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {

				line = line.substring(line.indexOf(".") + 4, line.length()).trim();

				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

			}

			StringTokenizer st = new StringTokenizer(sb.toString(), System.lineSeparator());

			while (st.hasMoreTokens()) {
				String s = st.nextToken().trim();
				serviceTime.add(Double.parseDouble(s));

			}
		} finally {
			br.close();
		}

	}

	public static double getArrival() /* read an arrival time */
	{
		return arrival.get(arrivalIndex++);
	}

	public static double getService() /* read a service time */
	{
		return serviceTime.get(serviceIndex++);
	}

}
