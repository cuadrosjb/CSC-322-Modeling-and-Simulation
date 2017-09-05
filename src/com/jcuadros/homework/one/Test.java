package com.jcuadros.homework.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Test {

	private static int arrivalIndex = 0;
	private static int serviceIndex = 0;

	private static List<Integer> arrival;
	private static List<Integer> serviceTime;

	public static void main(String[] args) {

		try {

			setArrArrival();
			setArrServicio();
			
			run();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void setArrArrival() throws IOException {
		arrival = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader("src/arrivals.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			StringTokenizer st = new StringTokenizer(sb.toString(), " ");

			while (st.hasMoreTokens()) {

				arrival.add(Integer.parseInt(st.nextToken().trim()));

			}

		} finally {
			br.close();
		}

	}

	public static void setArrServicio() throws IOException {
		serviceTime = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader("src/service.txt"));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			StringTokenizer st = new StringTokenizer(sb.toString(), " ");

			while (st.hasMoreTokens()) {

				serviceTime.add(Integer.parseInt(st.nextToken().trim()));

			}
		} finally {
			br.close();
		}

	}

	public static int getService() {
		return arrival.get(serviceIndex++);
	}

	public static int getArrival() {
		return arrival.get(arrivalIndex++);
	}

	public static void run() {

		int c_i_1 = 0;

		int a_i;
		int b_i;
		int d_i;
		int c_i;
		int s_i;
		int w_i;

		a_i = getArrival();
		
		if (a_i < c_i_1) {
			d_i = c_i_1 - a_i;
		} else {
			d_i = 0;
			int i = 0;
			while (i < 10) {
				i++;
				a_i = getArrival();
				if (a_i < c_i_1) {
					d_i = c_i_1 - a_i;
				} else {
					d_i = 0;

				}

				s_i = getService();

				c_i = d_i + d_i + s_i;

			}

		}

	}

}
