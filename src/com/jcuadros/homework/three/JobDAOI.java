package com.jcuadros.homework.three;

import java.sql.SQLException;

public interface JobDAOI {

	public Job getJob();
	public void saveJob(int seed, double wbar) throws ClassNotFoundException, SQLException;
	
}
