package sky;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.math3.distribution.NormalDistribution;

import customer.Company;
import customer.Customer;
import customer.GeneralIndividual;
import customer.Student;
import customer.University;
import day.Day;
import differentation.Differentation;
import logger.DifferLogger;

public class Providence {
	
	private static Providence instance = new Providence();
	
	public static synchronized Providence getInstance(){//나중에 Thread에서 사용할 예정 
		
		if(instance  ==null){ 
			instance  = new Providence (); 
		}

		return instance; 
	}

	public int bestowNecessityState(String identity) {
		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		differLogger.fine("START bestowNecessityState()");
			
		FileInputStream filestream = null;
		try {
			filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		
		try {
			properties.load(filestream);
			
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		
		double averageAmoutOfNecessity = Double.parseDouble(properties.getProperty("AVERAGE_SET_AMOUNT_OF_NECESSITY"));
		double stdevAmoutOfNecessity = Double.parseDouble(properties.getProperty("STDEV_SET_AMOUNT_OF_NECESSITY"));

		differLogger.fine("Average amount of necessity: "+ averageAmoutOfNecessity);
		differLogger.fine("Stdev amount of necessity: "+ stdevAmoutOfNecessity);
		
		NormalDistribution providenceOfNecessity = new NormalDistribution(averageAmoutOfNecessity, stdevAmoutOfNecessity);
		
		differLogger.fine("END bestowNecessityState()");

		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (int)(providenceOfNecessity.sample());

	}

	public ArrayList<Integer> bestowSeasonState() {

		ArrayList<Integer> busySeasons = new ArrayList<Integer>();
		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		differLogger.fine("START bestowSeasonState()");
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		double averageBusySeasonNumber = Double.parseDouble(properties.getProperty("AVERAGE_SET_BUSYSEASON_NUMBER"));
		double stdevBusySeasonNumber = Double.parseDouble(properties.getProperty("STDEV_SET_BUSYSEASON_NUMBER"));

		differLogger.fine("Average number of busy season: "+ averageBusySeasonNumber);
		differLogger.fine("Stdev number of busy season: "+ stdevBusySeasonNumber);
		
		NormalDistribution providenceOfBusySeason = new NormalDistribution(averageBusySeasonNumber, stdevBusySeasonNumber);
		int numberOfBusySeason = (int)(providenceOfBusySeason.sample());
		differLogger.fine("Number of busy season: "+ numberOfBusySeason);

		if(numberOfBusySeason < 0){
			numberOfBusySeason = 0;
		}
		
		if(numberOfBusySeason > 12){
			numberOfBusySeason = 12;
		}
		
		if(numberOfBusySeason != 0){
			int season = (int)(Math.random()*12) + 1;//1~12까지 변수
			busySeasons.add(season);
		}
		
		if(numberOfBusySeason !=1){
			for(int i =0; i<numberOfBusySeason; i++){
				int season = (int)(Math.random()*12) + 1;//1~12까지 변수
				boolean isDuplication = false;
				
				for(int j =0 ; j <= i; j++){
					if(busySeasons.get(j)==season){
						isDuplication = true;
					}
				}
				
				if(isDuplication){
					busySeasons.remove(i);
					i--;
					continue;
				}
				busySeasons.add(season);
				
			}
		}
//f		정해진 개수만큼 중복되지 않은 임의의 순자를 배열에 담는 방법
		
 		differLogger.fine("END bestowSeasonState()");
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busySeasons;
	}

	public int bestowIncrementOfReputation(int reputationOfDifferentation) {
		
		int reputation = reputationOfDifferentation;

		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		differLogger.fine("START bestowIncrementOfReputation()");
			
		
		
		FileInputStream filestream = null;
		try {
			 filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		double averageIncrementOfReputation = Double.parseDouble(properties.getProperty("AVERAGE_INCREASE_REPUTATION"));
		double stdevIncrementOfReputation = Double.parseDouble(properties.getProperty("STDEV_INCREASE_REPUTATION"));

		differLogger.fine("Average amount of reputation: "+ averageIncrementOfReputation);
		differLogger.fine("Stdev amount of reputation: "+ stdevIncrementOfReputation);
		
		NormalDistribution providenceOfReputation = new NormalDistribution(averageIncrementOfReputation, stdevIncrementOfReputation);
		
		reputation += (int)(providenceOfReputation.sample());
		differLogger.fine("Total reputation: "+ reputation);
		
		differLogger.fine("END bestowIncrementOfReputation()");
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reputation;
	}
	
	public void setRequestOfLecture(Day day){//강의 요청을 결정해주는 함수

		Properties properties = new Properties();
		DifferLogger differLoger = DifferLogger.getLogger();
		Differentation differentation = Differentation.getInstance();
		differLoger.fine("START setRequestOfLecture()");
		
		ArrayList<Customer> customerOfDifferentation = differentation.customerOfDifferentation;
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLoger.warning("IOException: " + e.getMessage());
		}
		
		double averageCriteriaOfRequestForIndividual = Double.parseDouble(properties.getProperty("AVERAGE_CRITERIA_OF_REQUEST_FOR_INDIVIDUAL"));
		int stdevCriteriaOfRequestForIndividual = Integer.parseInt(properties.getProperty("STDEV_CRITERIA_OF_REQUEST_FOR_INDIVIDUAL"));

		int averageCriteriaOfRequestForOrganization = Integer.parseInt(properties.getProperty("AVERAGE_CRITERIA_OF_REQUEST_FOR_ORGANIZATION"));
		int stdevCriteriaOfRequestForOrganization = Integer.parseInt(properties.getProperty("STDEV_CRITERIA_OF_REQUEST_FOR_ORGANIZATION"));

		double probabilityChangeDealtWithPromotion = Double.parseDouble(properties.getProperty("PROBABILITY_CHAGE_DEALT_WITH_PROMOTION"));
		
		differLoger.fine("Average Criteria Of Request For Individual: "+averageCriteriaOfRequestForIndividual);
		differLoger.fine("Stdev Criteria Of Request For Individual: "+stdevCriteriaOfRequestForIndividual);
		differLoger.fine("Average Criteria Of Request For Organization: "+averageCriteriaOfRequestForOrganization);
		differLoger.fine("Stdev Criteria Of Request For Organization: "+stdevCriteriaOfRequestForOrganization);
		
		//만약 프로모션 중이라면, 설정된 %만큼 증가시켜서 개인고객의 요청이 증가한다 START
		
		if(differentation.isCoursePromotion() == true){
			averageCriteriaOfRequestForIndividual = (int)(averageCriteriaOfRequestForIndividual*probabilityChangeDealtWithPromotion);
			differentation.setCoursePromotion(false);
		}
		
		//만약 프로모션 중이라면, 설정된 %만큼 증가시켜서 개인고객의 요청이 증가한다 END
		
		NormalDistribution providenceOfRequestCriteriaForIndividual = new NormalDistribution(averageCriteriaOfRequestForIndividual, stdevCriteriaOfRequestForIndividual);
		NormalDistribution providenceOfRequestCriteriaForOrganization = new NormalDistribution(averageCriteriaOfRequestForOrganization, stdevCriteriaOfRequestForOrganization);
		
		int requestCriteriaForIndividual = (int)(providenceOfRequestCriteriaForIndividual.sample());
		int requestCriteriaForOrganization = (int)(providenceOfRequestCriteriaForOrganization.sample());
		
		for(int i = 0; i<customerOfDifferentation.size(); i++){
			if(customerOfDifferentation.get(i).getidentity().equals("Student")||customerOfDifferentation.get(i).getidentity().equals("GeneralIndividual")){
				if(customerOfDifferentation.get(i).getBusySeason().equals(day.getMonth())){	//시즌에 안맞음
					differLoger.fine("One Busy Season of individual");
					continue;
				}else if(customerOfDifferentation.get(i).getIsPassedLecture()==true){	//강의를 이미 들음
					differLoger.fine("Already Passed Lecture // individual");
					continue;
				}else{
					if(customerOfDifferentation.get(i).getNecessityOfSkill()>requestCriteriaForIndividual){	//필요성 기준 통과
						if(customerOfDifferentation.get(i).getRequestOfLecture()==false){	//기존에 강의 신청 안함
							customerOfDifferentation.get(i).switchRequestOfLecture();	//강의신청함
							differentation.setRequestOfLectureFromIndividual(1);	//강의신청 증가
						}
					}
				}
			}else if(customerOfDifferentation.get(i).getidentity().equals("Company")){	//회사
				if(customerOfDifferentation.get(i).getBusySeason().equals(day.getMonth())){	//시즌에 안맞음
					differLoger.fine("One Busy Season of Company");
					continue;
				}else{
					if(customerOfDifferentation.get(i).getNecessityOfSkill()>requestCriteriaForOrganization){	//필요성 기준 통과
						if(customerOfDifferentation.get(i).getRequestOfLecture()==false){	//기존 강의신청 안함
							customerOfDifferentation.get(i).switchRequestOfLecture();	//강의요청함
							differentation.setRequestOfLectureFromCompany(1);	//강의요청증가
						}
					}
				}
			}else if(customerOfDifferentation.get(i).getidentity().equals("University")){
				if(customerOfDifferentation.get(i).getBusySeason().equals(day.getMonth())){
					differLoger.fine("One Busy Season of University");
					continue;
				}else{
					if(customerOfDifferentation.get(i).getNecessityOfSkill()>requestCriteriaForOrganization){
						if(customerOfDifferentation.get(i).getRequestOfLecture()==false){
							customerOfDifferentation.get(i).switchRequestOfLecture();
							differentation.setRequestOfLectureFromUniversity(1);
						}
					}
				}
			}
		}
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		differLoger.fine("END setRequestOfLecture()");
		return;
		
	}

	public void bestowIncrementOfCustomer() {

		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		Differentation differentation = Differentation.getInstance();
		differLogger.fine("START bestowIncrementOfCustomer()");
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("TotalCustomerNumber.properties");
		} catch (FileNotFoundException e1) {
			differLogger.warning("FileNotFoundException: " + e1.getMessage());
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		double totalIndividualCustomer = Double.parseDouble(properties.getProperty("TOTAL_INDIVIDUAL_CUSTOMER"));
		double totalCompanyCustomer = Double.parseDouble(properties.getProperty("TOTAL_COMPANY_CUSTOMER"));
		double totalUniversityCustomer = Double.parseDouble(properties.getProperty("TOTAL_UNIVERSITY_CUSTOMER"));
		
		try {
			properties.load(new FileInputStream("DistributionStrategy.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double averageIncrementOfIndividualCustomer = Double.parseDouble(properties.getProperty("AVERAGE_INCREMENT_OF_INDIVIDUAL_CUSTOMER"));
		double stdevIncrementOfIndividualCustomer = Double.parseDouble(properties.getProperty("STDEV_INCREMENT_OF_INDIVIDUAL_CUSTOMER"));
		
		double averageIncrementOfOrganizationCustomer = Double.parseDouble(properties.getProperty("AVERAGE_INCREMENT_OF_ORGANIZATION_CUSTOMER"));
		double stdevIncrementOfOrganizationCustomer = Double.parseDouble(properties.getProperty("STDEV_INCREMENT_OF_ORGANIZATION_CUSTOMER"));
		
		double probabilityOfStudent = Double.parseDouble(properties.getProperty("PROBABILITY_OF_STUDENT"));
		
		NormalDistribution normalDistributionOfIndividualCustomer = new NormalDistribution(averageIncrementOfIndividualCustomer, stdevIncrementOfIndividualCustomer);
		NormalDistribution normalDistributionOfOrganizationCustomer = new NormalDistribution(averageIncrementOfOrganizationCustomer, stdevIncrementOfOrganizationCustomer);

		
		int incrementOfIndividualCustomer = (int)
				((normalDistributionOfIndividualCustomer.sample()*differentation.getReputationForIndividual())
						*totalIndividualCustomer);
		
		int incrementOfCompanyCustomer = (int)
				((normalDistributionOfOrganizationCustomer.sample()*differentation.getReputationForOrganization())
						*totalCompanyCustomer);
		int incrementOfUniversityCustomer = (int)
				((normalDistributionOfOrganizationCustomer.sample()*differentation.getReputationForOrganization())
						*totalUniversityCustomer);
		int incrementOfStudentCustomer = (int)(incrementOfIndividualCustomer* probabilityOfStudent);
		int incrementOfGeneralIndividualCustomer = (int)(incrementOfIndividualCustomer* (1-probabilityOfStudent));		

		for(int i = 0; i < incrementOfCompanyCustomer; i++){
			Customer company = new Company();
			company.initial();
			differentation.customerOfDifferentation.add(company);
		}
		
		for(int i = 0; i< incrementOfUniversityCustomer; i++){
			Customer university = new University();
			university.initial();
			differentation.customerOfDifferentation.add(university);
		}
		
		for(int i = 0; i< incrementOfStudentCustomer; i++){
			Customer student = new Student();
			student.initial();
			differentation.customerOfDifferentation.add(student);
		}
		
		for(int i = 0; i < incrementOfGeneralIndividualCustomer; i++){
			Customer generalIndividual = new GeneralIndividual();
			generalIndividual.initial();
			differentation.customerOfDifferentation.add(generalIndividual);
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		differLogger.fine("END bestowIncrementOfCustomer()");
	}

	public void bestowChangeNecessity() {

		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		Differentation differentation = Differentation.getInstance();
		differLogger.fine("START bestowChangeNecessity()");
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			differLogger.warning("FileNotFoundException: " + e1.getMessage());
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		int averageChangeAmountOfNecessity = Integer.parseInt(properties.getProperty("AVERAGE_CHANGE_AMOUNT_OF_NECESSITY"));
		int stdevChangeAmountOfNecessity = Integer.parseInt(properties.getProperty("STDEV_CHANGE_AMOUNT_OF_NECESSITY"));
		
		NormalDistribution normalDistributionOfChangeAmount = new NormalDistribution(averageChangeAmountOfNecessity, stdevChangeAmountOfNecessity);
		int amount = (int)normalDistributionOfChangeAmount.sample();
		
		for(int i=0; i<differentation.customerOfDifferentation.size(); i++){
			int originalData = differentation.customerOfDifferentation.get(i).getNecessityOfSkill();
			differentation.customerOfDifferentation.get(i).changeNecessityOfSkill(originalData+amount);
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		differLogger.fine("END bestowChangeNecessity()");
	}

	public void bestowChangeBudget() {

		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		Differentation differentation = Differentation.getInstance();
		differLogger.fine("START bestowChangeBudget()");
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			differLogger.warning("FileNotFoundException: " + e1.getMessage());
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		int averageChangeAmountOfBudget = Integer.parseInt(properties.getProperty("AVERAGE_CHANGE_AMOUNT_OF_BUDGET"));
		int stdevChangeAmountOfBudget = Integer.parseInt(properties.getProperty("STDEV_CHANGE_AMOUNT_OF_BUDGET"));
		
		NormalDistribution normalDistributionOfChangeAmount = new NormalDistribution(averageChangeAmountOfBudget, stdevChangeAmountOfBudget);
		int amount = (int)normalDistributionOfChangeAmount.sample();
		
		for(int i=0; i<differentation.customerOfDifferentation.size(); i++){
			int originalData = differentation.customerOfDifferentation.get(i).getNecessityOfSkill();
			differentation.customerOfDifferentation.get(i).changeBudget(originalData+amount);
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		differLogger.fine("END bestowChangeBudget()");
	}
	
	public int bestowBudget() {//고객 만들때 쓰임

		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();

		differLogger.fine("START bestowBudget()");
		int budget = 0;
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("DistributionStrategy.properties");
		} catch (FileNotFoundException e1) {
			differLogger.warning("FileNotFoundException: " + e1.getMessage());
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		int averageAmountOfBudget = Integer.parseInt(properties.getProperty("AVERAGE_SET_AMOUNT_OF_BUDGET "));
		int stdevAmountOfBudget = Integer.parseInt(properties.getProperty("STDEV_SET_AMOUNT_OF_BUDGET "));
		
		NormalDistribution normalDistributionOfAmount = new NormalDistribution(averageAmountOfBudget, stdevAmountOfBudget);
		budget = (int)normalDistributionOfAmount.sample();
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		differLogger.fine("END bestowBudget()");
		
		
		//예산 바꿔줄 것
		
		return budget;
	}
}
