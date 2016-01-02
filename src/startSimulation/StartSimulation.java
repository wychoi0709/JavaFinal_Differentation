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
		
		
		s.close();
		logger.fine("END main()");
		
	}
	
}
