package customer;

import java.util.ArrayList;

import sky.Providence;

public class Student extends Customer{

	int isPassedLecture = 0; //0은 아직 안들음, 1은 들음
	
	@Override
	public void setNecessityOfSkill() {
		Providence providence = Providence.getInstance();//하늘의 뜻 생성
		
		identity = "Student";
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
