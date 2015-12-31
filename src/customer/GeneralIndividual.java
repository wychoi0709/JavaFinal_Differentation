package customer;

import java.util.ArrayList;

import sky.Providence;

public class GeneralIndividual extends Customer{

	@Override
	public void setNecessityOfSkill() {
		Providence providence = Providence.getInstance();//하늘의 뜻 생성
		
		identity = "GeneralIndividual";
		necessityOfSkill = providence.bestowNecessityState(identity);	//하늘의 계시
	}

	@Override
	public void setBusySeason() {
		Providence providence = Providence.getInstance();//하늘의 뜻 생성
		
		busySeason = providence.bestowSeasonState();
	}

	@Override
	public int getNecessityOfSkill() {
		return necessityOfSkill;
	}

	@Override
	public ArrayList<Integer> getBusySeason() {
		return busySeason;
	}
}
