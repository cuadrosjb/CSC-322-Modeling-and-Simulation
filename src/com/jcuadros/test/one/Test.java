package com.jcuadros.test.one;


public class Test {

	//Initial Stated specified on the assignment
	public static long state = 1;

	public static void main(String[] args) {
		//Create a new instance of the class "Test"
		Test t = new Test();
		
		int idx = 0 ;
		
		// "for-loop" for 10,000 times 
		for (int i = 0; i < 10000; i++) {
			//Calling the GNR functions that belongs to the class "Test"
			t.random();
			//Call sysout the last 10 iterations of the "for-loop"
			if (i > 9989)
				System.out.println("#" + ++idx + "\tstate: " + state);
		}

	}

	
	//Random function provided the book at page #54
	public static double random() {
		long A = 48271; /* multiplier */
		long M = 2147483647; /* modulus */
		long Q = M / A; /* quotient */
		long R = M % A; /* remainder */

		long t = A * (state % Q) - R * (state / Q);

		if (t > 0)
			state = t;
		else
			state = t + M;

		return ((double) state / M);
	}

}
