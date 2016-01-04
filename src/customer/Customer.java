package customer;

import java.util.ArrayList;

import logger.DifferLogger;
import sky.Providence;

public abstract class Customer {
	
	protected int necessityOfSkill;	//스킬에 대한 필요성
	protected ArrayList<Integer> busySeason = new ArrayList<Integer>();	//바쁜 시즌
	protected String identity;	//어떤 고객인지
 	protected boolean requestOfLecture = false;	//강의요청
	protected int budget;
	protected boolean isPassedLecture = false;	//강의 수강 여부
	
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
	
	
	public void initial(){	//템플릿 메소드 패턴
		DifferLogger logger = DifferLogger.getLogger();	//로거 생성
		
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
