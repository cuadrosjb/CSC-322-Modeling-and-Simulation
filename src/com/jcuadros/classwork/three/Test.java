package com.jcuadros.classwork.three;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static Connection conn;

	private static final long SEED = 2121212;
	private static long state = SEED;
//	private static DecimalFormat df3 = new DecimalFormat(".###");

	public static void main(String[] args) {
		Integer[] arr = {3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		List<Integer> num = Arrays.asList(arr);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i =0 ; i< 100000; i++){
			int tmp =  rollItUp();
			if(num.contains(tmp)){
				Integer prevVal = map.get(tmp);
				if(prevVal!=null)
					map.put(tmp, prevVal+1);
				else
					map.put(tmp, 1);
			}
		}
		
		System.out.println(map.toString());
		
		

	}
	
	public static int rollItUp(){
		int sum = 0;
		for (int i = 0; i < 3; i++)
			sum += equililikely(1, 6);
		return sum;
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

	public static double exponential(double u) {
		return (-u * Math.log(1.0 - random()));
	}

	public static double uniform(double a, double b) {
		return (a + (b - a) * random());
	}

	public static int equililikely(double a, double b) {
		return (int)(a + ((long) b - a + 1) * random());
	}

}
