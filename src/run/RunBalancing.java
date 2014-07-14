package run;

import java.util.Locale;

import persistence.IPersistence;
import persistence.PersistenceCSV;
import persistence.PersistenceException;
import balancers.IBalancer;
import balancers.SerpentineTwist;

public class RunBalancing {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US")); 
		
		IPersistence persistence = new PersistenceCSV();
		IBalancer balancer = new SerpentineTwist();
		
		try {
			persistence.loadPlayers();
			balancer.balance();
			balancer.printResult();
		} catch (IllegalArgumentException le) {
			System.err.println(le.getMessage());
		} catch(PersistenceException pe) {
			pe.printStackTrace();
		}
	}
	
}
