package customer;

import java.util.ArrayList;

import logger.DifferLogger;

public abstract class Customer {
	
	protected int necessityOfSkill;	//스킬에 대한 필요성
	protected ArrayList<Integer> busySeason = new ArrayList<Integer>();	//바쁜 시즌
	protected String identity;	//어떤 고객인지
 	protected boolean requestOfLecture = false;	//강의요청
	
	
	protected abstract void setNecessityOfSkill();
	protected abstract void setBusySeason();
	public abstract int getNecessityOfSkill();
	public abstract ArrayList<Integer> getBusySeason();
	public abstract boolean getRequestOfLecture();
	public abstract String getidentity();
	
	
	public void initial(){	//템플릿 메소드 패턴
		DifferLogger logger = DifferLogger.getLogger();	//로거 생성
		
		logger.fine("START generateCustomer()");
		
		setBusySeason();
		setNecessityOfSkill();
		
		logger.fine("END generateCustomer()");
	}

}
