package com.jcuadros.homework.three;
import java.sql.SQLException;


public interface NodeWaitDAOI {

	public void saveNodeWait(double seed, double wbar) throws ClassNotFoundException, SQLException;
	
}
