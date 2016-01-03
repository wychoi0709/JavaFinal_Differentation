package day;

import java.util.Date;
import java.util.GregorianCalendar;

public class OneWeekStrategy implements DayStrategy{

	@Override
	public Day passNextUnitOfDate(Day day) {
		
		int year = day.getYear();
		int month = day.getMonth();
		int date = day.getDate();

		GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, date);
		
		gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, 7);//이게 맞는 방법인가?
		
		//Date 클래스 대신 Calendar로 바꼈다고 함. 다시 알아 볼 것
		
	
		
		return day;
	}


	

}
