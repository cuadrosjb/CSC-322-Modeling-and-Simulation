package com.jcuadros.classwork.two;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mysql.jdbc.Driver;



/**
 * @author Jeffrey Cuadros
 * 
 * CSC332-Classwork
 *
 */
public class ExponentialDistribution {

	public static Connection conn;
	
	
	//The State is set by default to 2121212
	private static final long SEED = 2121212;
	private static long state = SEED;
	//DecimalFormat is used to print the values to 3 decimal places
	private static DecimalFormat df3 = new DecimalFormat(".###");

	public static void main(String[] args) {
		
		/**
		 * Using a List I can use all the functions avaliable that are build in the Java language
		 * I declare two variable "sum" and "temp" and set them to "0.0"
		 * Sum will keep the sum of all the random number generated and temp will keep only current 
		 * random number genarated.
		 * 
		 * A for loop will repeat for 1000 instances and add each random number generated to the list
		 * 
		 * */

		List<Double> list = new ArrayList<Double>();

		double sum = 0.0;
		double temp = 0.0;

		for (int i = 0; i < 1000; i++) {

			temp = exponential(9);
			list.add(temp);
			sum += temp;

		}

		//This framework allows to sort the List
		
		Collections.sort(list);

		System.out.println("Smallest: " + df3.format(list.get(0)));
		System.out.println("Biggest: " + df3.format(list.get(list.size() - 1)));

		
		//Divide the variable sum with the size of the list
		System.out.println("Average/Mean: " + df3.format(sum / list.size()));
//
//		double cmpr = sum / list.size();
//		
//		
//		startConn();
//
//		for(Double val : list){
//			insertStatement(val);
//		}
//		
//		killConn();
//		
//		
//
//		
//		//Reset all the variables to the initial state to find how many runs will take to get to the average
//		int index = 0;
//		sum = 0.0;
//		temp = 0.0;
//		state = SEED;
//		list = new ArrayList<Double>();
//
//		for (int i = 0; i < 1000; i++) {
//
//			temp = exponential(9);
//			list.add(temp);
//			sum += temp;
//
//			++index;
//
//			if (df3.format(sum / list.size()).equals(df3.format(cmpr))) {
//				System.out.println("It takes as a minimun " + index + " to get the mean equal to 9.478");
//				break;
//			}
//
//		}
//		
//		int lessthanavg = 0;
//		
//		for(Double val : list){
//			if(val < cmpr)
//				lessthanavg++;
//		}
//		
//		System.out.println(lessthanavg + " are the numbers under the average");
//		
//		List<Double> list = new ArrayList<Double>();
//		
//		double utmp = 0.0;
//		double dSum = 0.0;
//		
//		startConn();
//		
//		for(int i = 0; i < 1000; i++){
//			utmp = uniform(0,1);
//			
//			dSum += utmp;
//			list.add(utmp);
//			
//			insertStatement((double)(dSum/list.size()));
//		}
//		
//		killConn();
//		
//		System.out.println("Mean: " + dSum/1000);
//		Collections.sort(list);
//		System.out.println("Maximun: " + list.get(list.size()-1));
//		System.out.println("Minimun: " + list.get(0));

	}
	
	public static void startConn(){
		String URL = "jdbc:mysql://localhost:3306/csc322?useSSL=false";
		String USER = "root";
		String PASS = "root";

			try {
				DriverManager.registerDriver(new Driver());
				conn = DriverManager.getConnection(URL, USER, PASS);
			} catch (SQLException ex) {
				throw new RuntimeException("Error connecting to the database", ex);
			}
		
	}
	
	
	public static void insertStatement(double val){
		String query = "insert into classwork(val) values (?) ";
		PreparedStatement prst =null;
		try{
			prst = conn.prepareStatement(query);
			prst.setDouble(1, val);
			prst.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				prst.close();
			}catch (Exception e) {}
		}
	}
	
	public static void killConn(){
		try{
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
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
	
	private static double uniform(double a, double b) {
		return (a + (b - a) * random());
	}

}
