package customer;

import java.util.ArrayList;

import logger.DifferLogger;

public abstract class Customer {
	
	protected int necessityOfSkill;	//��ų�� ���� �ʿ伺
	protected ArrayList<Integer> busySeason = new ArrayList<Integer>();	//�ٻ� ����
	protected String identity;
	
	
	protected abstract void setNecessityOfSkill();
	protected abstract void setBusySeason();
	public abstract int getNecessityOfSkill();
	public abstract ArrayList<Integer> getBusySeason();
	
	
	public void initial(){	//���ø� �޼ҵ� ����
		DifferLogger logger = DifferLogger.getLogger();	//�ΰ� ����
		
		logger.fine("START generateCustomer()");
		
		setBusySeason();
		setNecessityOfSkill();
		
		logger.fine("END generateCustomer()");
	}

}
