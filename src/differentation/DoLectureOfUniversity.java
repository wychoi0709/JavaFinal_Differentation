package differentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import logger.DifferLogger;

public class DoLectureOfUniversity extends Decorator{

	public DoLectureOfUniversity(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}

	public void doAction(){
		super.doAction();
		
		//대학 강의 적어줄 것
		Differentation differentation = Differentation.getInstance();
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		
		differLogger.fine("START DoLectureOfUniversity().doAction()");
		
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
		
		int priceOfUniversityLecture = Integer.parseInt(properties.getProperty("UNIVERSITY_LECTURE"));
		
		
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
		
		int investedTimeOfUniversityLecture = Integer.parseInt(properties.getProperty("LECTURE_OF_COMPANY"));
		
		for(int i =0; i<differentation.customerOfDifferentation.size(); i++){
			if(differentation.customerOfDifferentation.get(i).getidentity().equals("University")){
				if(differentation.customerOfDifferentation.get(i).getRequestOfLecture()==true){ //강의요청을 했니?
					differentation.customerOfDifferentation.get(i).switchRequestOfLecture();//강의 요청 없앰
					differentation.customerOfDifferentation.get(i).switchIsPassedLecture(); //강의를 들음
					int totalRevenue = differentation.getTotalRevenue()+priceOfUniversityLecture;	//돈을 받음
					differentation.setTotalRevenue(totalRevenue);	//총 수익에 더함
					differentation.setTotalInvestedTime(investedTimeOfUniversityLecture);
					differentation.customerOfDifferentation.remove(i);//수업을 들은 고객은 없어짐
					differentation.setRequestOfLectureFromUniversity(-1);
				}
			}
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		differLogger.fine("END DoLectureOfUniversity().doAction()");
	}
}
