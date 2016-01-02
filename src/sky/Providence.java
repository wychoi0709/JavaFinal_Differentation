package sky;

import java.util.ArrayList;

public class Providence {
	
	private static Providence instance = new Providence();
	
	public static synchronized Providence getInstance(){//나중에 Thread에서 사용할 예정 
		
		if(instance  ==null){ 
			instance  = new Providence (); 
		}

		return instance;
	}

	public int bestowNecessityState(String identity) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Integer> bestowSeasonState() {
		// TODO Auto-generated method stub
		return null;
	}

	public int bestowReputation(int reputationOfDifferentation) {
		
		int reputation = reputationOfDifferentation;

		//얼마나 랜덤하게 증가시켜야 할까?
		
		
		return reputation;
	}
}
