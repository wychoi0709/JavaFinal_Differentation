package differentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import logger.DifferLogger;

public class DoLectureOfIndividual extends Decorator{

	public DoLectureOfIndividual(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		super.doAction();
		
		//개인 강의하면 변화를 적어줄 것
		Differentation differentation = Differentation.getInstance();
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		
		differLogger.fine("START DoLectureOfIndividual().doAction()");
		
		FileInputStream filestream=null;
		try {
			 filestream = new FileInputStream("PriceStrategy.properties");
		} catch (FileNotFoundException e1) {
			differLogger.warning("FileNotFoundException: " + e1.getMessage());
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		int priceOfIndividualLecture = Integer.parseInt(properties.getProperty("INDIVIDUAL_LECTURE"));
		
		
		try {
			 filestream = new FileInputStream("InvestTimeStrategy.properties");
		} catch (FileNotFoundException e1) {
			differLogger.warning("FileNotFoundException: " + e1.getMessage());
		}
		
		try {
			properties.load(filestream);
		}catch(IOException e) {
			differLogger.warning("IOException: " + e.getMessage());
		}
		
		int investedTimeOfIndividualLecture = Integer.parseInt(properties.getProperty("LECTURE_OF_INDIVIDUAL"));
		
		
		for(int i =0; i<differentation.customerOfDifferentation.size(); i++){
			if(differentation.customerOfDifferentation.get(i).getidentity().equals("Student")||
					differentation.customerOfDifferentation.get(i).getidentity().equals("GeneralIndividual")){
				
				if(differentation.customerOfDifferentation.get(i).getIsPassedLecture() == true){
					continue;
				}else if(differentation.customerOfDifferentation.get(i).getBudget()>priceOfIndividualLecture
						&&differentation.customerOfDifferentation.get(i).getRequestOfLecture()==true){//예산이 있고, 요청은 했니?
					differentation.customerOfDifferentation.get(i).switchRequestOfLecture();//강의 요청 없앰
					differentation.customerOfDifferentation.get(i).switchIsPassedLecture(); //강의를 들음
					int totalRevenue = differentation.getTotalRevenue()+priceOfIndividualLecture;	//돈을 받음
					differentation.setTotalRevenue(totalRevenue);	//총 수익에 더함

					
					differentation.setTotalInvestedTime(investedTimeOfIndividualLecture);
				}
			}
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		differLogger.fine("END DoLectureOfIndividual().doAction()");
		
	}

}
