package startSimulation;

import java.io.FileInputStream;
import java.io.IOException;
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
		
		Differentation differentation = Differentation.getInstance();//���۷����̼� ��� ����
		Providence providence = Providence.getInstance();
		DifferLogger logger = DifferLogger.getLogger();
		Scanner s = new Scanner(System.in);
		Properties properties = new Properties();
		Day day = new Day();
		
		logger.fine("START main()");

		try{
			properties.load(new FileInputStream("dayConfig.properties"));
		} catch (IOException e) {
			logger.warning("IOException: "+ e.getMessage());
		}

		String passNextUnitOfDate = properties.getProperty("DAY_STRATEGY");
		DayStrategy dayStrategy = null;
		
		if(passNextUnitOfDate == "ONEWEEK"){
			dayStrategy = new OneWeekStrategy();
		}else if(passNextUnitOfDate == "THREEWEEK"){
			dayStrategy = new ThreeWeeksStrategy();
		}else if(passNextUnitOfDate == "MONTH"){
			dayStrategy = new MonthStrategy();
		}else{
			logger.warning("There is no DAY STRATEGY CONFIG");
		}
		
		
		
		PrintText.printStart();//���� �ؽ�Ʈ ���
		
		int commendNum = s.nextInt();//1�� ���, 2�� ����
		while(commendNum != 1&&commendNum != 2){
			PrintText.printWrongNum();
			PrintText.printStart();
			commendNum = s.nextInt();//1�� ���, 2�� ����
		}
		if(commendNum == 2){
			PrintText.printEnd();//�¹��� �ؽ�Ʈ ���
			//�ؽ�Ʈ�� ���̰� return�Ǵ��� Ȯ���� ��(�Ⱥ��̸� s.nextInt()�� �ϳ� �ֱ�
			return;//����
		}
		
		//commendNum�� 1�� ���
		//=======================================================================
		//                                 ����
		//=======================================================================
		
		providence.setRequestOfLecture(differentation.customerOfDifferentation);
		
		PrintText.clearScreen();
		PrintText.printCurrentState();
		PrintText.printInputCommendText();//��ɹ޴� �ؽ�Ʈ ���
		
		commendNum=-1;
		while(commendNum != 0){
			commendNum = s.nextInt();
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
			
			day = dayStrategy.passNextUnitOfDate(day);
			providence.setRequestOfLecture(differentation.customerOfDifferentation);
			
			PrintText.clearScreen();
			PrintText.printCurrentState();
			PrintText.printInputCommendText();//��ɹ޴� �ؽ�Ʈ ���
			
			
		}
		
		PrintText.printEnd();
		s.close();
		logger.fine("END main()");
		
	}
	
}
