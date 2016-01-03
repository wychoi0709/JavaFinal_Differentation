package day;

import java.util.GregorianCalendar;

public class OneWeekStrategy implements DayStrategy{

	@Override
	public Day passNextUnitOfDate(Day day) {
		
		int year = day.getYear();
		int month = day.getMonth();
		int date = day.getDate();

		GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, date);
		
		gregorianCalendar.add(GregorianCalendar.DATE, 7);//�̰� �´� ����ΰ�?
		
		//Date Ŭ���� ��� Calendar�� �ٲ��ٰ� ��. �ٽ� �˾� �� ��
		
		day.setYear(gregorianCalendar.get(GregorianCalendar.YEAR));
		day.setMonth(gregorianCalendar.get(GregorianCalendar.MONTH));
		day.setDate(gregorianCalendar.get(GregorianCalendar.DATE));
		
		return day;
	}


	

}
