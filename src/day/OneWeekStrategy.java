package day;

import java.util.Date;

public class OneWeekStrategy implements DayStrategy{

	Day day = new Day();

	@Override
	public Day initDayData(int currentDate) {

		Integer cd = new Integer(currentDate);
		cd.//currentDate를 잘라서 year / month / week / date를 설정할 것(덧. 1주 단위로 맞출 것)
		
		return null;
	}

	@Override
	public Day setDayData(Day day) {//date 조절해서 넘어올 것. 해당 년의 데이터를 토대로 week, month, year를 다시 맞춰줄것
		// TODO Auto-generated method stub
		Date dd = new Date();
		dd.
		return null;
	}
	

}
