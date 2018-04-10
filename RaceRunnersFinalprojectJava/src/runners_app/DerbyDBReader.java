package runners_app;

import java.sql.*;
import java.util.*;

/**
 * This class reads from the Derby database.
 * @author pratishtha
 *
 */

public class DerbyDBReader implements RunnerDAO {
	
	/**
	 * Set the connection to Derby database.
	 * @return An object of the connection.
	 */
	private Connection connect() {
		Connection connection = null;
		
		String dbDirectory = "Resources";
		
		System.setProperty("derby.system.home", dbDirectory);

		String url = "jdbc:derby:RunnersDB";
		
		String user = "";
		
		String pw = "";
		/*
		 * use the DriverManager to create a Connection object
		 */
		try {
			connection = DriverManager.getConnection(url, user, pw);

		} catch (SQLException e) {
			
			System.err.println("Error Loading database driver " + e);
		}
		return connection;
	}

	/**
	 * Disconnects the connection to Derby database.
	 * @return True if connection was successfull.
	 */
	private boolean disconnect() {
		
		String shutDownURL = "jdbc:derby:RunnersDB;shutdown=true";
		
		try {
			DriverManager.getConnection(shutDownURL);

		} catch (SQLException e) {
			
			if (e.getMessage().equals("Derby system shutdown."))
				return true;
		}
		return false;
	}

	/*
	 *Return the list of all runners from the Derby database by overriding the method
	 *implementing from RunnerDAO 
	 */
	@Override
	public ArrayList<Runner> getRunners() {
		
		//Set the connection.
		Connection connection = connect();
		
		ArrayList<Runner> runners = new ArrayList<Runner>();
		
		//Select all the records from the RunnerStats
		String query = "SELECT *FROM RunnerStats";
		
		PreparedStatement ps;
		
		try {
			
			//Prepare statement for the query.
			ps = connection.prepareStatement(query);
			
			//Execute the query.
			ResultSet rs = ps.executeQuery();
			
			//Loop through the result set till we get all the data from RunnerStats.
			while (rs.next()) {
				
				//Data from RunnersName column.
				String runnerName = rs.getString("RunnersName");
				
				//Data from RunnersSpeed column.
				int runnerSpeed = rs.getInt("RunnersSpeed");
				
				//Data from RestPercentage column.
				int restPercentage = rs.getInt("RestPercentage");
				
				//This instance will create a runner for Derby database.
				Runner r = new Runner(runnerName, runnerSpeed, restPercentage);
				
				runners.add(r);
				
			} // end while
			
			//close the connection
			rs.close();
			
			ps.close();
			
			return runners;
			
			//Catch any SQL Exception occurred.
		} catch (SQLException sqle) {
			
			sqle.printStackTrace();
			
			return null;
		
		} finally {
		
			disconnect();
		}

	}

}
