package customer;

import java.util.ArrayList;

import sky.Providence;

public class GeneralIndividual extends Customer{

	int isPassedLecture = 0; //0�� ���� �ȵ���, 1�� ����
	
	@Override
	public void setNecessityOfSkill() {
		Providence providence = Providence.getInstance();//�ϴ��� �� ����
		
		identity = "GeneralIndividual";
		necessityOfSkill = providence.bestowNecessityState(identity);	//�ϴ��� ���
	}

	@Override
	public void setBusySeason() {
		Providence providence = Providence.getInstance();//�ϴ��� �� ����
		
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
}
