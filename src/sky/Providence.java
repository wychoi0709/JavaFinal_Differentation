package sky;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.math3.distribution.NormalDistribution;

import logger.DifferLogger;

public class Providence {
	
	private static Providence instance = new Providence();
	
	public static synchronized Providence getInstance(){//나중에 Thread에서 사용할 예정 
		
		if(instance  ==null){ 
			instance  = new Providence (); 
		}

		return instance; 
	}

	public int bestowNecessityState(String identity) {
		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		differLogger.fine("START bestowNecessityState()");
			
		try {
			properties.load(new FileInputStream("DistributionStrategy.properties"));
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		double averageAmoutOfNecessity = Double.parseDouble(properties.getProperty("AVERAGE_SET_AMOUNT_OF_NECESSITY"));
		double stdevAmoutOfNecessity = Double.parseDouble(properties.getProperty("STDEV_SET_AMOUNT_OF_NECESSITY"));

		differLogger.fine("Average amount of necessity: "+ averageAmoutOfNecessity);
		differLogger.fine("Stdev amount of necessity: "+ stdevAmoutOfNecessity);
		
		NormalDistribution providenceOfNecessity = new NormalDistribution(averageAmoutOfNecessity, stdevAmoutOfNecessity);
		
		differLogger.fine("END bestowNecessityState()");
		return (int)(providenceOfNecessity.sample());

	}

	public ArrayList<Integer> bestowSeasonState() {

		ArrayList<Integer> busySeasons = new ArrayList<Integer>();
		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		differLogger.fine("START bestowSeasonState()");
			
		try {
			properties.load(new FileInputStream("DistributionStrategy.properties"));
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		double averageBusySeasonNumber = Double.parseDouble(properties.getProperty("AVERAGE_SET_BUSYSEASON_NUMBER"));
		double stdevBusySeasonNumber = Double.parseDouble(properties.getProperty("STDEV_SET BUSYSEASON_NUMBER"));

		differLogger.fine("Average number of busy season: "+ averageBusySeasonNumber);
		differLogger.fine("Stdev number of busy season: "+ stdevBusySeasonNumber);
		
		NormalDistribution providenceOfBusySeason = new NormalDistribution(averageBusySeasonNumber, stdevBusySeasonNumber);
		int numberOfBusySeason = (int)(providenceOfBusySeason.sample());
		differLogger.fine("Number of busy season: "+ numberOfBusySeason);

		if(numberOfBusySeason < 0){
			numberOfBusySeason = 0;
		}
		
		if(numberOfBusySeason > 12){
			numberOfBusySeason = 12;
		}
		
		for(int i =0; i<numberOfBusySeason; i++){
			int season = (int)(Math.random()*12) + 1;//1~12까지 변수
			int j;
			for(j =0 ; j < i; j++){
				if(busySeasons.get(j)==season){
					break;
				}
			}
			if(busySeasons.get(j)==season){
				i--;
				continue;
			}
			
			busySeasons.add(season);
		}
		
		differLogger.fine("END bestowSeasonState()");
		
		
		return busySeasons;
	}

	public int bestowIncrementOfReputation(int reputationOfDifferentation) {
		
		int reputation = reputationOfDifferentation;

		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		differLogger.fine("START bestowIncrementOfReputation()");
			
		try {
			properties.load(new FileInputStream("DistributionStrategy.properties"));
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		double averageIncrementOfReputation = Double.parseDouble(properties.getProperty("AVERAGE_INCREASE_REPUTATION"));
		double stdevIncrementOfReputation = Double.parseDouble(properties.getProperty("STDEV_INCREASE_REPUTATION"));

		differLogger.fine("Average amount of reputation: "+ averageIncrementOfReputation);
		differLogger.fine("Stdev amount of reputation: "+ stdevIncrementOfReputation);
		
		NormalDistribution providenceOfReputation = new NormalDistribution(averageIncrementOfReputation, stdevIncrementOfReputation);
		
		reputation += (int)(providenceOfReputation.sample());
		differLogger.fine("Total reputation: "+ reputation);
		
		differLogger.fine("END bestowIncrementOfReputation()");
		
		
		//얼마나 랜덤하게 증가시켜야 할까?
		
		
		return reputation;
	}
}
