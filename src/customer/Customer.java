package customer;

import java.util.ArrayList;

import logger.DifferLogger;
import sky.Providence;

public abstract class Customer {
	
	protected int necessityOfSkill;	//��ų�� ���� �ʿ伺
	protected ArrayList<Integer> busySeason = new ArrayList<Integer>();	//�ٻ� ����
	protected String identity;	//� ������
 	protected boolean requestOfLecture = false;	//���ǿ�û
	protected int budget;
	protected boolean isPassedLecture = false;	//���� ���� ����
	
	protected abstract void setNecessityOfSkill();
	protected abstract void setBusySeason();
	
	public abstract void changeNecessityOfSkill(int necessityOfSkill);
	public abstract void changeBudget(int budget);

	public abstract int getNecessityOfSkill();
	public abstract ArrayList<Integer> getBusySeason();
	public abstract boolean getRequestOfLecture();
	public abstract String getidentity();
	public abstract int getBudget();
	public abstract boolean getIsPassedLecture();
	
	
	public void initial(){	//���ø� �޼ҵ� ����
		DifferLogger logger = DifferLogger.getLogger();	//�ΰ� ����
		
		logger.fine("START generateCustomer()");
		
		setBusySeason();
		setNecessityOfSkill();
		setBudget();
		
		logger.fine("END generateCustomer()");
	}
	
	public void switchRequestOfLecture() {
		
		if(requestOfLecture == true){
			requestOfLecture = false;
		}else if(requestOfLecture == false){
			requestOfLecture = true;
		}
		
	}
	
	public void switchIsPassedLecture() {
		
		if(isPassedLecture == true){
			isPassedLecture = false;
		}else if(isPassedLecture == false){
			isPassedLecture = true;
		}
		
	}

	protected void setBudget(){
		Providence providence = Providence.getInstance();
		this.budget = providence.bestowBudget();
	}
}
