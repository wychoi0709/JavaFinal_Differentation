package day;

import java.util.Date;

public class OneWeekStrategy implements DayStrategy{

	Day day = new Day();

	@Override
	public Day initDayData(int currentDate) {

		Integer cd = new Integer(currentDate);
		cd.//currentDate�� �߶� year / month / week / date�� ������ ��(��. 1�� ������ ���� ��)
		
		return null;
	}

	@Override
	public Day setDayData(Day day) {//date �����ؼ� �Ѿ�� ��. �ش� ���� �����͸� ���� week, month, year�� �ٽ� �����ٰ�
		// TODO Auto-generated method stub
		Date dd = new Date();
		dd.
		return null;
	}
	

}
