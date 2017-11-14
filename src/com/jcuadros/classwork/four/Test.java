package com.jcuadros.classwork.four;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static Connection conn;

	private static final long SEED = 2121212;
	private static long state = SEED;
	private static DecimalFormat df3 = new DecimalFormat(".##");

	public static void main(String[] args) {
		Integer[] arr = { 1,2,3,4,5,6 };
		
		List<Integer> num = Arrays.asList(arr);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < 100000; i++) {
			int tmp = rollItUp();
			if (num.contains(tmp)) {
				Integer prevVal = map.get(tmp);
				if (prevVal != null)
					map.put(tmp, prevVal + 1);
				else
					map.put(tmp, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":\t" + df3.format(((double) entry.getValue() / 100000) * 100) + "%");
		}
		
		
//		testRollItUpFunc();
		
	}
	
	public static void testRollItUpFunc(){
		System.out.println("-------------------------------------");
		rollItUp();
		System.out.println("-------------------------------------");
		rollItUp();
		System.out.println("-------------------------------------");
		rollItUp();
		System.out.println("-------------------------------------");
	}

	public static int rollItUp() {
		int max = 0;
//		System.out.println("current max: " + max);
		for (int i = 0; i < 3; i++){
//			System.out.print("rolling the dice #" + (i+1) + " showing: ");
			int temp = equililikely(1, 6);
//			System.out.println(temp);
			if(max < temp){
				max = temp;
//				System.out.println("assigning new max: " + max);
			}
		}
		return max;
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
		return (int) (a + ((long) b - a + 1) * random());
	}

}