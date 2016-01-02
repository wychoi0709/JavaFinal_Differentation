package differentation;


public class Decorator extends Action{

	Action action;
	
	public Decorator(Action action){
		this.action = action;
	}

	@Override
	public void doAction() {
		action.doAction();
	}
		
}
