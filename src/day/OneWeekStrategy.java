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
	public Day setDayData(Day day) {//date �����ؼ� �Ѿ�� ��. �ش� ���� �����͸� ���� week, month, year�� �ٽ� �����ٰ�
		// TODO Auto-generated method stub
		Date dd = new Date();
//		dd.
		return null;
	}
	

}
