package differentation;

public class CoursePromotion extends Decorator{

	public CoursePromotion(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		
		Differentation differentation = Differentation.getInstance();
		
		super.doAction();
		
		//코스 프로모션에 대한 내용 적어줄 것
		differentation.setCoursePromotion(true);
		
	}

}
