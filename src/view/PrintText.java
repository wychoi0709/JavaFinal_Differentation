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
		int tempInvestedTime;
		
		if(differentation.getTotalInvestedTime() == 0){
			tempInvestedTime = 1;
		}else{
			tempInvestedTime = differentation.getTotalInvestedTime();
		}
		int hourlyEarnings = (int)(differentation.getTotalRevenue()/tempInvestedTime);
		
		logger.fine("START printCurrentState()");
		System.out.println("=====================================");//'=' 33개
		System.out.println("");
		System.out.println(" A. Reputation for individual: " + differentation.getReputationForIndividual());
		System.out.println(" B. Reputation for organization: " + differentation.getReputationForOrganization());
		System.out.println(" C. Total revenue: " + differentation.getTotalRevenue() + " Won");
		System.out.println(" D. Total invested time: " + differentation.getTotalInvestedTime());
		System.out.println("");
		System.out.println(" ★ Hourly earnings: " + hourlyEarnings + " Won/Hour");
		System.out.println("");
		System.out.println("=====================================");//'=' 33개
		logger.fine("END printCurrentState()");

	}
}
