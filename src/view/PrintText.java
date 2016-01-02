package view;

import differentation.Differentation;
import logger.DifferLogger;

public class PrintText {
	
	public static void printStart(){

		System.out.println(" ");
		System.out.println("=====================================");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("|||                               |||");
		System.out.println("|||       Simulation of           |||");
		System.out.println("|||       DIFFERENTATION          |||");
		System.out.println("|||       Business                |||");
		System.out.println("|||                               |||");
		System.out.println("|||       1. Start                |||");
		System.out.println("|||       2. End                  |||");
		System.out.println("|||                               |||");
		System.out.println("||=================================||");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("=====================================");//'=' 33개
		System.out.println(" ");
		System.out.print("Input Commend: ");
		
	}
	
	
	
	public static void printInputCommendText(){
		
		System.out.println(" ");
		System.out.println("=====================================");//'=' 33개
		System.out.println("|||                               |||");
		System.out.println("|||  Choose Action of this week   |||");
		System.out.println("|||   1.Brand Marketing           |||");
		System.out.println("|||   2.Course Promotion          |||");
		System.out.println("|||   3.Teach Individuals         |||");
		System.out.println("|||   4.Teach in Company          |||");
		System.out.println("|||   5.Teach in University       |||");
		System.out.println("|||   0.End This Simulation       |||");
		System.out.println("|||                               |||");
		System.out.println("=====================================");//'=' 33개
		System.out.println(" ");
		System.out.print("Input Commend: ");
		
	}
	

	public static void printEnd() {

		clearScreen();
		
		System.out.println(" ");
		System.out.println("=====================================");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("|||                               |||");
		System.out.println("|||       Simulation of           |||");
		System.out.println("|||       DIFFERENTATION          |||");
		System.out.println("|||       Business                |||");
		System.out.println("|||                               |||");
		System.out.println("|||       Thank you!!             |||");
		System.out.println("|||       Have a good day!        |||");
		System.out.println("|||                               |||");
		System.out.println("||=================================||");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("=====================================");//'=' 33개
		System.out.println(" ");
		
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 80; i++){
		    	System.out.println("");
		}
	}



	public static void printWrongNum() {
		
		System.out.println(" ");
		System.out.println("=====================================");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("|||                               |||");
		System.out.println("|||       You entered             |||");
		System.out.println("|||       an wrong number..!      |||");
		System.out.println("|||                               |||");
		System.out.println("|||       Please enter            |||");
		System.out.println("|||       another number..!       |||");
		System.out.println("|||                               |||");
		System.out.println("||=================================||");//'=' 33개
		System.out.println("||=================================||");//'=' 33개
		System.out.println("=====================================");//'=' 33개
		System.out.println(" ");
		
	}



	public static void printCurrentState() {
		DifferLogger logger = DifferLogger.getLogger();
		Differentation differentation = Differentation.getInstance();
		logger.fine("START printCurrentState()");

		differentation.setRequestNumberOfLecture();//고객 중 요청을 몇명했는지 각 변수에 설정해주는 함수
		
		int tempInvestedTime;//0으로 나누는 것을 방지하기 위해 임시로 만든 변수
		
		if(differentation.getTotalInvestedTime() == 0){
			tempInvestedTime = 1;
		}else{
			tempInvestedTime = differentation.getTotalInvestedTime();
		}
		
		int hourlyEarnings = differentation.getTotalRevenue()/tempInvestedTime;
		
		System.out.println("=====================================");//'=' 33개
		System.out.println("");
		System.out.print(" A. Reputation for individual: " + differentation.getReputationForIndividual());
		System.out.println("        B. Reputation for organization: " + differentation.getReputationForOrganization());
		System.out.print(" C. Total revenue: " + differentation.getTotalRevenue() + " Won");
		System.out.println("                D. Total invested time: " + differentation.getTotalInvestedTime());
		System.out.print(" E. Total Request from individuals: " + differentation.getRequestOfLectureFromIndividual());
		System.out.println("   F. Total Request from companies: " + differentation.getRequestOfLectureFromCompany());
		System.out.print(" G. Total Request from universities: " + differentation.getRequestOfLectureFromUniversity());
		System.out.println("");
		System.out.println("");
		System.out.println(" ★ Hourly earnings: " + hourlyEarnings + " Won/Hour");
		System.out.println("");
		System.out.println("=====================================");//'=' 33개
		
		logger.fine("END printCurrentState()");

	}
}
