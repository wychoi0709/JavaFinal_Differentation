package differentation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import logger.DifferLogger;

public class DoLectureOfCompany extends Decorator{

	public DoLectureOfCompany(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		super.doAction();
		
		//기업 강의 적어줄 것
		Differentation differentation = Differentation.getInstance();
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();
		
		differLogger.fine("START DoLectureOfCompany().doAction()");
		
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
		
		int priceOfCompanyLecture = Integer.parseInt(properties.getProperty("COMPANY_LECTURE"));
		
		for(int i =0; i<differentation.customerOfDifferentation.size(); i++){
			if(differentation.customerOfDifferentation.get(i).getidentity().equals("Company")){
				if(differentation.customerOfDifferentation.get(i).getRequestOfLecture()==true){ //강의요청을 했니?
					differentation.customerOfDifferentation.get(i).switchRequestOfLecture();//강의 요청 없앰
					differentation.customerOfDifferentation.get(i).switchIsPassedLecture(); //강의를 들음
					int totalRevenue = differentation.getTotalRevenue()+priceOfCompanyLecture;	//돈을 받음
					differentation.setTotalRevenue(totalRevenue);	//총 수익에 더함
				}
			}
		}
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		differLogger.fine("END DoLectureOfCompany().doAction()");
		
		
	}

}
