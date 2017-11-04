package com.jcuadros.homework.three;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NodeWaitDAO implements NodeWaitDAOI{

	private static Connection conn;
	private final static String QUERY = "INSERT INTO wbarnodebar (wbar, nodebar) VALUES(?, ?)";
	private PreparedStatement preStm;
	
	@Override
	public void saveNodeWait(double wbar, double nbar) throws ClassNotFoundException, SQLException {

		conn = new MyConnection().getConn();
		
		preStm = conn.prepareStatement(QUERY);
		
		preStm.setDouble(1, wbar);
		preStm.setDouble(2, nbar);
		
		preStm.execute();
		
		preStm.close();
		
		conn.close();
	
	}

}
