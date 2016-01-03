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
		
		gregorianCalendar.add(GregorianCalendar.DAY_OF_MONTH, 7);//�̰� �´� ����ΰ�?
		
		//Date Ŭ���� ��� Calendar�� �ٲ��ٰ� ��. �ٽ� �˾� �� ��
		
	
		
		return day;
	}


	

}
