package startSimulation;

import java.util.Scanner;


import differentation.Differentation;
import logger.DifferLogger;
import sky.Providence;
import view.PrintText;

public class StartSimulation {

	public static void main(String[] args) {
		
		Differentation differentation = Differentation.getInstance();//디퍼런테이션 기업 생성
		Providence providence = Providence.getInstance();//하늘의 뜻 생성
		DifferLogger logger = DifferLogger.getLogger();
		Scanner s = new Scanner(System.in);
		

		logger.fine("START main()");

		PrintText.printStart();//시작 텍스트 출력
		
		//정규분포 쓰는 방법!!!!!!!!!!
//		NormalDistribution nd = new NormalDistribution(100, 25);
//		double ii  = nd.sample();
//		System.out.println(ii);
		
		
		int commendNum = s.nextInt();//1은 계속, 2는 종료
		
		while(commendNum != 1&&commendNum != 2){
			PrintText.printWrongNum();
			PrintText.printStart();
			commendNum = s.nextInt();//1은 계속, 2는 종료
		}

		if(commendNum == 2){
			PrintText.printEnd();//굿바이 텍스트 출력
			//텍스트가 보이고 return되는지 확인할 것(안보이면 s.nextInt()라도 하나 넣기
			return;//종료
		}
		
		//commendNum이 1인 경우
		//=======================================================================
		//                                 시작
		//=======================================================================
		
		PrintText.clearScreen();
		PrintText.printCurrentState();
		PrintText.printInputCommendText();//명령받는 텍스트 출력
		
		commendNum=0;
		while(commendNum != 6){
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
			PrintText.clearScreen();
			PrintText.printCurrentState();
			PrintText.printInputCommendText();//명령받는 텍스트 출력
		}
		
		PrintText.printEnd();
		s.close();
		logger.fine("END main()");
		
	}
	
}
