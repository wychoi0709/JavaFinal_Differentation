package startSimulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import day.Day;
import day.DayStrategy;
import day.MonthStrategy;
import day.OneWeekStrategy;
import day.ThreeWeeksStrategy;
import differentation.Differentation;
import logger.DifferLogger;
import sky.Providence;
import view.PrintText;

public class StartSimulation {

	public static void main(String[] args) {
		
		Differentation differentation = Differentation.getInstance();//디퍼런테이션 기업 생성
		Providence providence = Providence.getInstance();
		DifferLogger logger = DifferLogger.getLogger();
		Scanner s = new Scanner(System.in);
		Properties properties = new Properties();
		Day day = new Day();
		
		logger.fine("START main()");

		FileInputStream filestream = null;
		try {
			filestream = new FileInputStream("DayConfig.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
			properties.load(filestream);
		} catch (IOException e) {
			logger.warning("IOException: "+ e.getMessage());
		}

		String passNextUnitOfDate = properties.getProperty("DAY_STRATEGY");
		DayStrategy dayStrategy = null;
		
		if(passNextUnitOfDate.equals("ONEWEEK")){
			dayStrategy = new OneWeekStrategy();
		}else if(passNextUnitOfDate.equals("THREEWEEK")){
			dayStrategy = new ThreeWeeksStrategy();
		}else if(passNextUnitOfDate.equals("MONTH")){
			dayStrategy = new MonthStrategy();
		}else{
			logger.warning("There is no DAY STRATEGY CONFIG");
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintText.printStart();//시작 텍스트 출력
		

        boolean continueVar = true;
		int commendNum = -1;
		while (continueVar) {
            try {
                commendNum = s.nextInt();
                if(commendNum != 1 && commendNum != 2){
            		PrintText.printWrongNum();
            		PrintText.printStart();
                	continue;
                }
        		continueVar = false;
            } catch (InputMismatchException i) {
                PrintText.printWrongNum();
                continueVar = true;
                s.next();
            }
    		PrintText.printWrongNum();
    		PrintText.printStart();
        }

		if(commendNum == 2){
			PrintText.printEnd();//굿바이 텍스트 출력
			//텍스트가 보이고 return되는지 확인할 것(안보이면 s.nextInt()라도 하나 넣기
			System.exit(0);//종료
		}
		
		//commendNum이 1인 경우
		//=======================================================================
		//                                 시작
		//=======================================================================
		
		providence.setRequestOfLecture(day);
		
		PrintText.clearScreen();
		PrintText.printCurrentState(day);
		PrintText.printInputCommendText();//명령받는 텍스트 출력
		
		commendNum=-1;
		while(commendNum != 0){

	        continueVar = true;
			commendNum = -1;
			while (continueVar) {
	            try {
	                commendNum = s.nextInt();
	                if(commendNum != 1 && commendNum != 2 && commendNum != 3 && commendNum != 4 && commendNum != 5){
	            		PrintText.clearScreen();
	                	PrintText.printCurrentState(day);
	                	PrintText.printInputCommendText();
	                	continue;
	                }
	        		continueVar = false;
	            } catch (InputMismatchException i) {
	                PrintText.printWrongNum();
	                continueVar = true;
	                s.next();
	            }
	            PrintText.clearScreen();
	    		PrintText.printCurrentState(day);
	    		PrintText.printInputCommendText();
	        }
				
			
			if(commendNum == 1){
				differentation.brandMarketing();
			}else if(commendNum == 2){
				differentation.coursePromotion();
			}else if(commendNum == 3){
				differentation.doLectureOfIndividual();
			}else if(commendNum == 4){
				differentation.doLectureOfCompany();
			}else if(commendNum == 5){
				differentation.doLectureOfUniversity();
			}
			
			day = dayStrategy.passNextUnitOfDate(day);//일자를 한단계(기존 설정파일에 따라) 옮겨주심
			providence.bestowIncrementOfCustomer();//요소를 반영해서 고객을 증가시켜주심
			providence.bestowChangeNecessity();//필요성의 변동
			providence.bestowChangeBudget();//예산의 변동(모든 고객이지만 개인 고객만 유의미)
			providence.setRequestOfLecture(day);//다양한 요소(날짜포함)를 반영해서 강의요청을 내려주심
			
			
			PrintText.clearScreen();
			PrintText.printCurrentState(day);
			PrintText.printInputCommendText();//명령받는 텍스트 출력
			
			
		}
		
		PrintText.printEnd();
		s.close();
		logger.fine("END main()");
		
		logger.fileHandler.close();
		logger.fineHandler.close();
		logger.warningHandler.close();
	}
	
}
