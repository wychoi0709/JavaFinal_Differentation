package startSimulation;

import java.util.Scanner;


import differentation.Differentation;
import logger.DifferLogger;
import sky.Providence;
import view.PrintText;

public class StartSimulation {

	public static void main(String[] args) {
		
		Differentation differentation = Differentation.getInstance();//���۷����̼� ��� ����
		Providence providence = Providence.getInstance();//�ϴ��� �� ����
		DifferLogger logger = DifferLogger.getLogger();
		Scanner s = new Scanner(System.in);
		

		logger.fine("START main()");

		PrintText.printStart();//���� �ؽ�Ʈ ���
		
		//���Ժ��� ���� ���!!!!!!!!!!
//		NormalDistribution nd = new NormalDistribution(100, 25);
//		double ii  = nd.sample();
//		System.out.println(ii);
		
		
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
		
		PrintText.clearScreen();
		PrintText.printCurrentState();
		PrintText.printInputCommendText();//��ɹ޴� �ؽ�Ʈ ���
		
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
			PrintText.printInputCommendText();//��ɹ޴� �ؽ�Ʈ ���
		}
		
		PrintText.printEnd();
		s.close();
		logger.fine("END main()");
		
	}
	
}
