package differentation;

public class CoursePromotion extends Decorator{

	public CoursePromotion(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		
		Differentation differentation = Differentation.getInstance();
		
		super.doAction();
		
		//�ڽ� ���θ�ǿ� ���� ���� ������ ��
		differentation.setCoursePromotion(true);
		
	}

}
