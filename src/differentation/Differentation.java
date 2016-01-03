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
	private int requestOfLectureFromIndividual=0;
	private int requestOfLectureFromUniversity=0;
	private int requestOfLectureFromCompany=0;
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
		this.totalInvestedTime += totalInvestedTime;
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
	
	public void setRequestOfLectureFromIndividual(int requestOfLectureFromIndividual) {
		this.requestOfLectureFromIndividual += requestOfLectureFromIndividual;
	}
	
	public void setRequestOfLectureFromUniversity(int requestOfLectureFromUniversity) {
		this.requestOfLectureFromUniversity += requestOfLectureFromUniversity;
	}
	
	public void setRequestOfLectureFromCompany(int requestOfLectureFromCompany) {
		this.requestOfLectureFromCompany += requestOfLectureFromCompany;
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
		
		this.setRequestOfLectureFromIndividual(requestOfLectureFromIndividual);
		this.setRequestOfLectureFromCompany(requestOfLectureFromCompany);
		this.setRequestOfLectureFromUniversity(requestOfLectureFromUniversity);
		
		differLogger.fine("End setRequestOfLecture()");
	}

	public void brandMarketing(){
		BrandMarketing brandMarketing = new BrandMarketing(new MarketingBuzz());
		brandMarketing.doAction();
	}
	
	public void promotionOfLecture(){
		PromotionOfLecture promotionOfLecture = new PromotionOfLecture(new MarketingBuzz());
		promotionOfLecture.doAction();
	}
	
	public void doLectureOfIndividual(){
		DoLectureOfIndividual doLectureOfIndividual = new DoLectureOfIndividual(new MarketingBuzz());
		doLectureOfIndividual.doAction();
	}
	
	public void doLectureOfCompany(){
		DoLectureOfCompany doLectureOfCompany = new DoLectureOfCompany(new MarketingBuzz());
		doLectureOfCompany.doAction();
	}
	
	public void doLectureOfUniversity(){
		DoLectureOfUniversity doLectureOfUniversity = new DoLectureOfUniversity(new MarketingBuzz());
		doLectureOfUniversity.doAction();
	}

	public void coursePromotion() {
		CoursePromotion coursePromotion = new CoursePromotion(new MarketingBuzz());
		coursePromotion.doAction();
		
	}




	
}
