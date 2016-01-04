package day;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import logger.DifferLogger;

public class Day {
	
	private int year;
	private int month;
	private int date;
	
	public Day(){//일반 Day 객체를 생성할 경우, Properties에서 설정한 날짜의 객체가 만들어짐
		
		Properties properties = new Properties();
		DifferLogger differLogger = DifferLogger.getLogger();

		differLogger.fine("START Day constructor()");
		
		FileInputStream filestream = null;
		
		try {
			filestream = new FileInputStream("DayConfig.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			properties.load(filestream);
		} catch (IOException e) {
			differLogger.warning("IOException: "+ e.getMessage());
		}
		String currentDate = properties.getProperty("CURRENT_DAY_DATA");
		
		
		
		//예를 들면 20160103
		int year = Integer.parseInt(currentDate.substring(0, 4));
		int month = Integer.parseInt(currentDate.substring(4, 6));
		int date = Integer.parseInt(currentDate.substring(6, 8));
		
		this.year = year;
		this.month = month;
		this.date = date;
		//currentDate를 잘라서 year / month / week / date를 설정할 것(덧. 1주 단위로 맞출 것)
		
		try {
			filestream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		differLogger.fine("END Day constructor");

	}
	
	public Day(String dayData){//dayData를 넣은 경우, 해당하는 값의 Day 객체가 만들어짐

		int year = Integer.parseInt(dayData.substring(0, 3));
		int month = Integer.parseInt(dayData.substring(4, 5));
		int date = Integer.parseInt(dayData.substring(6, 7));
		
		this.year = year;
		this.month = month;
		this.date = date;
		
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
}
