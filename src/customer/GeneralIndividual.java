package customer;

import java.util.ArrayList;

import sky.Providence;

public class GeneralIndividual extends Customer{

	private int isPassedLecture = 0; //0은 아직 안들음, 1은 들음
	
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
	
	@Override
	public boolean getRequestOfLecture() {
		// TODO Auto-generated method stub
		return requestOfLecture;
	}
	
	@Override
	public String getidentity() {
		// TODO Auto-generated method stub
		return identity;
	}

	public int getIsPassedLecture() {
		return isPassedLecture;
	}

	public void setIsPassedLecture(int isPassedLecture) {
		this.isPassedLecture = isPassedLecture;
	}


	@Override
	public void changeNecessityOfSkill(int necessityOfSkill) {
		this.necessityOfSkill = necessityOfSkill;
	}

	@Override
	public void changeBudget(int budget) {
		this.budget = budget;
	}
	

}
