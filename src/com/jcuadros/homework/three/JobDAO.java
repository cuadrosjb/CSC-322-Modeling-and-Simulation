package com.jcuadros.homework.three;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JobDAO implements JobDAOI{

	private static Connection conn;
	private final static String QUERY = "INSERT INTO job (seed, wbar) VALUES(?, ?)";
	private PreparedStatement preStm;
	
	
	@Override
	public Job getJob() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveJob(int seed, double wbar) throws ClassNotFoundException, SQLException {
		
		conn = new MyConnection().getConn();
		
		preStm = conn.prepareStatement(QUERY);
		
		preStm.setInt(1, seed);
		preStm.setDouble(2, wbar);
		
		preStm.execute();
		
		preStm.close();
		
		conn.close();
		
	}

}
