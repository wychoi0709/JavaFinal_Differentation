package customer;

import java.util.ArrayList;

import sky.Providence;

public class Company extends Customer{

	@Override
	public void setNecessityOfSkill() {
		Providence providence = Providence.getInstance();//�ϴ��� �� ����
		
		identity = "Company";
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

}
