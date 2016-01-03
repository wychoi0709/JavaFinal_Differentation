package day;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;


import logger.DifferLogger;

public class OneWeekStrategy implements DayStrategy{

	Day day = new Day();

	@Override
	public Day initDayData() {
		
		return null;
	}

	@Override
	public Day setDayData(Day day) {//date 조절해서 넘어올 것. 해당 년의 데이터를 토대로 week, month, year를 다시 맞춰줄것
		// TODO Auto-generated method stub
		Date dd = new Date();
//		dd.
		return null;
	}
	

}
