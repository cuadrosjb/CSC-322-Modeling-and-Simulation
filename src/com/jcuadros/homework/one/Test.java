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
	private static List<JobBean> lstJobs;
	

	public static void main(String[] args) {

		try {

			setArrArrival();
			setArrServicio();
			
			initListJobs();
			
			start();
			
			for(int j = 1; j < lstJobs.size();j++){
				System.out.println(lstJobs.get(j).toString(j));
			}


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
		return serviceTime.get(serviceIndex++);
	}

	public static int getArrival() {
		return arrival.get(arrivalIndex++);
	}

	public static void initListJobs(){
		JobBean prev = null;
		JobBean curr = null;
		lstJobs = new ArrayList<JobBean>();
		for(int i = 0 ; i < arrival.size();i++){
			curr = new JobBean(getArrival(), getService(), prev);
			lstJobs.add(curr);
			prev = curr;
		}
	}
	
	
	public static void start(){
		
		int i = 0;

		if((lstJobs.get(i).getPrevJob() != null) && (lstJobs.get(i).getA_i() < lstJobs.get(i).getPrevJob().getC_i())){
			lstJobs.get(i).setD_i( lstJobs.get(i).getPrevJob().getC_i() - lstJobs.get(i).getA_i());
		}else{
			if(lstJobs.get(i).getPrevJob()==null){
				lstJobs.get(i).setD_i( 0 - lstJobs.get(i).getA_i());
			}else{
				lstJobs.get(i).setD_i( (lstJobs.get(i).getPrevJob().getC_i()) - lstJobs.get(i).getA_i());
			}
			
			lstJobs.get(i).setC_i(0);
			while(i < lstJobs.size()-1){
				i++;
				if(lstJobs.get(i).getA_i() < lstJobs.get(i).getPrevJob().getC_i()){
					lstJobs.get(i).setD_i(lstJobs.get(i).getPrevJob().getC_i() - lstJobs.get(i).getA_i());
				}else{
					lstJobs.get(i).setD_i(0);
				}
				
				lstJobs.get(i).setC_i(lstJobs.get(i).getA_i() + lstJobs.get(i).getD_i() + lstJobs.get(i).getS_i());
			}
		}
	}
	
}
