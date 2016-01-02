package differentation;

import java.util.ArrayList;

import customer.Customer;
import logger.DifferLogger;
import sky.Providence;

public class Differentation {


	private static Differentation instance = new Differentation();
	
	private Differentation(){
		//�⺻ ��Ǯ(�ʱ�ȭ��)�� ���迭�� ������� ��
	}
	
	public static synchronized Differentation getInstance(){//���߿� Thread���� ����� ���� 
		
		if(instance  ==null){ 
			instance  = new Differentation(); 
		}

		return instance;
	}
	
	//�ʿ��� ������ ���� START
	private int reputationForIndividual;//���ΰ�(���л�, ���л�, �Ϲ���)�� ���� ��
	private int reputationForOrganization;//�����(���, �б�)�� ���� ��
	
	private int totalRevenue;//�� ����
	private int totalInvestedTime;//�� ���� �ð�
	
	public ArrayList<Customer> customerOfDifferentation = new ArrayList<Customer>();//���۷����̼� �� ����Ʈ
	private int requestOfLectureFromIndividual;
	private int requestOfLectureFromUniversity;
	private int requestOfLectureFromCompany;
	//�ʿ��� ������ ���� END
	
	
	//Getter, Setter ���� START
	public int getReputationForIndividual() {
		return reputationForIndividual;
	}
	
	public void setReputationForIndividual(int reputationForIndividual) {
		this.reputationForIndividual = reputationForIndividual;
	}

	public int getReputationForOrganization() {
		return reputationForOrganization;
	}

	public void setReputationForOrganization(int reputationForOrganization) {
		this.reputationForOrganization = reputationForOrganization;
	}

	public int getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public int getTotalInvestedTime() {
		return totalInvestedTime;
	}

	public void setTotalInvestedTime(int totalInvestedTime) {
		this.totalInvestedTime = totalInvestedTime;
	}
	
	public int getRequestOfLectureFromIndividual() {
		return requestOfLectureFromIndividual;
	}

	public int getRequestOfLectureFromUniversity() {
		return requestOfLectureFromUniversity;
	}

	public int getRequestOfLectureFromCompany() {
		return requestOfLectureFromCompany;
	}
	
	//Getter, Setter ���� END



	public void setRequestNumberOfLecture() {
		DifferLogger differLogger = DifferLogger.getLogger();
		
		differLogger.fine("Start setRequestOfLecture()");
		int requestOfLectureFromIndividual = 0;
		int requestOfLectureFromCompany = 0;
		int requestOfLectureFromUniversity = 0;
		
		for(int i = 0; i < customerOfDifferentation.size(); i++){
			
			//��������, �������, �б����� �ľ��ؼ� ���� �ش��ϴ� request ���� �ϳ��� �÷��� �� START
			if(customerOfDifferentation.get(i).getidentity()=="Student"||customerOfDifferentation.get(i).getidentity()=="GeneralIndividual"){
				requestOfLectureFromIndividual++;
			}else if(customerOfDifferentation.get(i).getidentity()=="Company"){
				requestOfLectureFromCompany++;
			}else if(customerOfDifferentation.get(i).getidentity()=="University"){
				requestOfLectureFromUniversity++;
			}
			//��������, �������, �б����� �ľ��ؼ� ���� �ش��ϴ� request ���� �ϳ��� �÷��� �� END
		}
		
		differLogger.fine("Requests of lecture from individuals: "+ requestOfLectureFromIndividual);
		differLogger.fine("Requests of lecture from companies: "+ requestOfLectureFromCompany);
		differLogger.fine("Requests of lecture from universities: "+ requestOfLectureFromUniversity);
		
		this.requestOfLectureFromIndividual = requestOfLectureFromIndividual;
		this.requestOfLectureFromCompany = requestOfLectureFromCompany;
		this.requestOfLectureFromUniversity = requestOfLectureFromUniversity;
		
		differLogger.fine("End setRequestOfLecture()");
	}

	public void brandMarketing(){
		Providence providence = Providence.getInstance();
		//�귣�� �������� ���θ��� 3�� ������Ű��, ������� 1�� ������Ų�� START
		reputationForIndividual = providence.bestowReputation(reputationForIndividual);
		reputationForIndividual = providence.bestowReputation(reputationForIndividual);
		reputationForIndividual = providence.bestowReputation(reputationForIndividual);
		reputationForOrganization = providence.bestowReputation(reputationForOrganization);
		//�귣�� �������� ���θ��� 3�� ������Ű��, ������� 1�� ������Ų�� END
	}
	
	public void promotionOfLecture(){
		
	}
	
	public void doLectureOfIndividual(){
		
	}
	
	public void doLectureOfCompany(){
		
	}
	
	public void doLectureOfUniversity(){
		
	}


	
}
