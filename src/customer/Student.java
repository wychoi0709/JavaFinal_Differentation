package customer;

import java.util.ArrayList;

import sky.Providence;

public class Student extends Customer{

	
	@Override
	public void setNecessityOfSkill() {
		Providence providence = Providence.getInstance();//�ϴ��� �� ����
		
		identity = "Student";
		necessityOfSkill = providence.bestowNecessityState(identity);	//�ϴ��� ���
	}

	@Override
	public void setBusySeason() {
		//Schedule of University(Seasons of Exam) Setting START
		busySeason.add(4);	//1�б� �߰����
		busySeason.add(6);	//1�б� �⸻���
		busySeason.add(10);	//2�б� �߰����
		busySeason.add(12);	//2�б� �⸻���
		//Schedule of University(Seasons of Exam) Setting END
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

	@Override
	public boolean getIsPassedLecture() {
		// TODO Auto-generated method stub
		return this.isPassedLecture;
	}


	@Override
	public void changeNecessityOfSkill(int necessityOfSkill) {
		this.necessityOfSkill = necessityOfSkill;
	}

	@Override
	public void changeBudget(int budget) {
		this.budget = budget;
	}
	@Override
	public int getBudget() {
		
		return this.budget;
	}

}
