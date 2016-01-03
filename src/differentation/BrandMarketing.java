package differentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import logger.DifferLogger;
import sky.Providence;

public class BrandMarketing extends Decorator{

	public BrandMarketing(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		
		differLogger.fine("START BrandMarketing's doAction()");
		
		super.doAction();
		
		Differentation differentation = Differentation.getInstance();
		Providence providence = Providence.getInstance();
		
		int reputationForIndividual = differentation.getReputationForIndividual();
		int reputationForOrganization = differentation.getReputationForOrganization();
		
		reputationForIndividual = providence.bestowIncrementOfReputation(reputationForIndividual);
		reputationForIndividual = providence.bestowIncrementOfReputation(reputationForIndividual);
		reputationForOrganization = providence.bestowIncrementOfReputation(reputationForOrganization);
		
		differentation.setReputationForIndividual(reputationForIndividual);
		differentation.setReputationForOrganization(reputationForOrganization);
		
		FileInputStream filestream = null;
		try {
			filestream = new FileInputStream("InvestTimeStrategy.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		int investedTimeForBrandMarketing = Integer.parseInt(properties.getProperty("BRANDMARKETING"));
		differLogger.fine("Invested Time For BrandMarketing: "+ investedTimeForBrandMarketing);
		
		differentation.setTotalInvestedTime(investedTimeForBrandMarketing);
		differLogger.fine("END BrandMarketing's doAction()");
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
