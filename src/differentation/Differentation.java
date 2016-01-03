package differentation;

import java.util.ArrayList;

import customer.Customer;
import logger.DifferLogger;
import sky.Providence;

public class Differentation {


	private static Differentation instance = new Differentation();
	
	private Differentation(){
		//기본 고객풀(초기화값)을 고객배열에 집어넣을 것
	}
	
	public static synchronized Differentation getInstance(){//나중에 Thread에서 사용할 예정 
		
		if(instance  ==null){ 
			instance  = new Differentation(); 
		}

		return instance;
	}
	
	//필요한 변수들 선언 START
	private int reputationForIndividual;//개인고객(재학생, 휴학생, 일반인)에 대한 명성
	private int reputationForOrganization;//기관고객(기업, 학교)에 대한 명성
	
	private int totalRevenue;//총 수입
	private int totalInvestedTime;//총 투자 시간
	
	public ArrayList<Customer> customerOfDifferentation = new ArrayList<Customer>();//디퍼런테이션 고객 리스트
	private int requestOfLectureFromIndividual=0;
	private int requestOfLectureFromUniversity=0;
	private int requestOfLectureFromCompany=0;
	//필요한 변수들 선언 END
	
	
	//Getter, Setter 선언 START
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
	//Getter, Setter 선언 END



	public void setRequestNumberOfLecture() {
		DifferLogger differLogger = DifferLogger.getLogger();
		
		differLogger.fine("Start setRequestOfLecture()");
		int requestOfLectureFromIndividual = 0;
		int requestOfLectureFromCompany = 0;
		int requestOfLectureFromUniversity = 0;
		
		for(int i = 0; i < customerOfDifferentation.size(); i++){
			
			//개인인지, 기업인지, 학교인지 파악해서 각각 해당하는 request 값을 하나씩 올려줄 것 START
			if(customerOfDifferentation.get(i).getidentity()=="Student"||customerOfDifferentation.get(i).getidentity()=="GeneralIndividual"){
				requestOfLectureFromIndividual++;
			}else if(customerOfDifferentation.get(i).getidentity()=="Company"){
				requestOfLectureFromCompany++;
			}else if(customerOfDifferentation.get(i).getidentity()=="University"){
				requestOfLectureFromUniversity++;
			}
			//개인인지, 기업인지, 학교인지 파악해서 각각 해당하는 request 값을 하나씩 올려줄 것 END
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
