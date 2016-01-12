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
		
		Differentation differentation = Differentation.getInstance();//���۷����̼� ��� ����
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
		
		PrintText.printStart();//���� �ؽ�Ʈ ���
		

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
			PrintText.printEnd();//�¹��� �ؽ�Ʈ ���
			//�ؽ�Ʈ�� ���̰� return�Ǵ��� Ȯ���� ��(�Ⱥ��̸� s.nextInt()�� �ϳ� �ֱ�
			System.exit(0);//����
		}
		
		//commendNum�� 1�� ���
		//=======================================================================
		//                                 ����
		//=======================================================================
		
		providence.setRequestOfLecture(day);
		
		PrintText.clearScreen();
		PrintText.printCurrentState(day);
		PrintText.printInputCommendText();//��ɹ޴� �ؽ�Ʈ ���
		
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
			
			day = dayStrategy.passNextUnitOfDate(day);//���ڸ� �Ѵܰ�(���� �������Ͽ� ����) �Ű��ֽ�
			providence.bestowIncrementOfCustomer();//��Ҹ� �ݿ��ؼ� ���� ���������ֽ�
			providence.bestowChangeNecessity();//�ʿ伺�� ����
			providence.bestowChangeBudget();//������ ����(��� �������� ���� ���� ���ǹ�)
			providence.setRequestOfLecture(day);//�پ��� ���(��¥����)�� �ݿ��ؼ� ���ǿ�û�� �����ֽ�
			
			
			PrintText.clearScreen();
			PrintText.printCurrentState(day);
			PrintText.printInputCommendText();//��ɹ޴� �ؽ�Ʈ ���
			
			
		}
		
		PrintText.printEnd();
		s.close();
		logger.fine("END main()");
		
		logger.fileHandler.close();
		logger.fineHandler.close();
		logger.warningHandler.close();
	}
	
}
