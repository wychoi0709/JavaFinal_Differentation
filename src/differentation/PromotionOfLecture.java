package differentation;

public class PromotionOfLecture extends Decorator{

	public PromotionOfLecture(Action action) {
		super(action);
		// TODO Auto-generated constructor stub
	}
	
	public void doAction(){
		super.doAction();
		
		//properties 파일에서 개인강의요청 여부의 기준(평균, 표준편차)을 불러와서 변화시킬 것(기준을 낮출 것)
	}

}
