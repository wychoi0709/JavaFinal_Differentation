package sky;

import java.util.ArrayList;

public class Providence {
	
	private static Providence instance = new Providence();
	
	public static synchronized Providence getInstance(){//���߿� Thread���� ����� ���� 
		
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

		//�󸶳� �����ϰ� �������Ѿ� �ұ�?
		
		
		return reputation;
	}
}
