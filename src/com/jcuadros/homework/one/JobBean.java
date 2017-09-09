package com.jcuadros.homework.one;

public class JobBean {
	
	private int a_i;
	private int b_i;
	private int d_i;
	private int c_i;
	private int s_i;
	private int w_i;
	
	private JobBean prevJob;
	
	
	public JobBean(){}
	
	public JobBean(int a_i, int s_i){
		this.a_i = a_i;
		this.s_i = s_i;
	}
	
	public JobBean(int a_i, int s_i, JobBean prevJob){
		
//		System.out.println("a_i: " +  a_i  + "s_i: " + s_i);
		this.a_i = a_i;
		this.s_i = s_i;
		this.prevJob = prevJob;
	}


	public JobBean(int a_i, int b_i, int d_i, int c_i, int s_i, int w_i) {
		this.a_i = a_i;
		this.b_i = b_i;
		this.d_i = d_i;
		this.c_i = c_i;
		this.s_i = s_i;
		this.w_i = w_i;
	}


	public int getA_i() {
		return a_i;
	}


	public void setA_i(int a_i) {
		this.a_i = a_i;
	}


	public int getB_i() {
		return b_i;
	}


	public void setB_i(int b_i) {
		this.b_i = b_i;
	}


	public int getD_i() {
		return d_i;
	}


	public void setD_i(int d_i) {
		this.d_i = d_i;
	}


	public int getC_i() {
		return c_i;
	}


	public void setC_i(int c_i) {
		this.c_i = c_i;
	}


	public int getS_i() {
		return s_i;
	}


	public void setS_i(int s_i) {
		this.s_i = s_i;
	}


	public int getW_i() {
		return w_i;
	}


	public void setW_i(int w_i) {
		this.w_i = w_i;
	}


	public JobBean getPrevJob() {
		return prevJob;
	}


	public void setPrevJob(JobBean prevJob) {
		this.prevJob = prevJob;
	}


	public String toString(int index) {
		return "Job " + index + " [a_i=" + a_i + ", b_i=" + b_i + ", d_i=" + d_i + ", c_i=" + c_i + ", s_i=" + s_i + ", w_i="
				+ w_i + "]" ;
	}
	
	
	
	
	

}
