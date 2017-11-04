package com.jcuadros.homework.three;

import java.io.IOException;
import java.text.DecimalFormat;

import com.jcuadros.classwork.one.PrivateStruct;

/**
 * 
 * Seed = 2121212 Seed = 12345 Seed = 54321
 * 
 * -Run SSQ2 for 3 different seeds
 * 
 * -gather w-bar for every 50 jobs.
 * 
 * Draw graph
 * 
 **/

public class Test {
	
	final static long LAST = 10000L; /* number of jobs processed */
	final static double START = 0.0; /* initial time */

	private static long state = 2121212;
	private static double arrival = START;

	private static JobDAOI save; 
	private static NodeWaitDAOI nw;
	 
	private static DecimalFormat df3 = new DecimalFormat(".###");

	public static void main(String[] vargs) throws IOException {
			
		int[] nums = {2121212, 12345, 54321};
		
		save = new JobDAO();
		nw = new NodeWaitDAO();
		for(int n : nums){
			state = n;
			run(n);
		}


	}
	
	public static void run(Integer num){
		
		System.out.println("-----------------" + num + "-----------------");
		
		long index = 0; /* job index */
		double arrival = START; /* time of arrival */
		double delay; /* delay in queue */
		double service; /* service time */
		double wait; /* delay + service */
		double departure = START; /* time of departure */

		PrivateStruct sum = new PrivateStruct(0.0, 0.0, 0.0);

		// PutSeed(123456789);

		while (index < LAST) {
			index++;
			arrival = GetArrival();
			if (arrival < departure) {
				delay = departure - arrival; /* delay in queue */
			} else {
				delay = 0.0; /* no delay */
			}
			service = GetService();
			wait = delay + service;
			departure = arrival + wait; /* time of departure */
			sum.delay += delay;
			sum.wait += wait;
			sum.service += service;
			
			if(index % 50 == 0){
//				try {
////					save.saveJob(num, Double.parseDouble(df3.format(sum.wait/index)));
////					nw.saveNodeWait(Double.parseDouble(df3.format(sum.wait/index)), Double.parseDouble(df3.format(sum.wait/departure)));
//				} catch (ClassNotFoundException | SQLException e) {
//						e.printStackTrace();
//						return;
//				}finally {
//					
//				}
			}
		}

		sum.interarrival = arrival - START;

		System.out.println("for " + index + " jobs");
		System.out.println("\taverage interarrival time = " + df3.format(sum.interarrival / index));
		System.out.println("\taverage wait ............ = " + df3.format(sum.wait / index));
		System.out.println("\taverage delay ........... = " + df3.format(sum.delay / index));
		System.out.println("\taverage service time .... = " + df3.format(sum.service / index));

		System.out.println("\taverage # in the node ... = " + df3.format(sum.wait / departure));
		System.out.println("\taverage # in the queue .. = " + df3.format(sum.delay / departure));
		System.out.println("\tutilization ............. = " + df3.format(sum.service / departure));
	}

	public static double random() {
		long A = 48271; /* multiplier */
		long M = 2147483647; /* modulus */
		long Q = M / A; /* quotient */
		long R = M % A; /* remainder */

		// long state = 1;

		long t = A * (state % Q) - R * (state / Q);

		if (t > 0)
			state = t;
		else
			state = t + M;

		return ((double) state / M);
	}

	private static double Exponential(double m) {
		return (-m * Math.log((double) (1.0 - random())));
	}

	private static double Uniform(double a, double b) {
		return (a + (b - a) * random());
	}

	public static double GetService() {
		return (Uniform(1.0, 2.0));
	}

	public static double GetArrival() {

		arrival += Exponential(2.0);

		return arrival;
	}

}
