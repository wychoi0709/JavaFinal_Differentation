package differentation;

public class Differentation {


	private static Differentation instance = new Differentation();
	
	private Differentation(){
		//기본 고객풀(초기화값)을 고객배열에 집어넣을 것
	}
	
	public static synchronized Differentation getInstance(){//나중에 Thread에서 사용할 예정 
		
		if(instance  ==null){ 
			instance  = new Differentation(); 
		}

		return instance;
	}
	
	//필요한 변수들 선언 START
	private int reputationForIndividual;//개인고객(재학생, 휴학생, 일반인)에 대한 명성
	private int getReputationForOrganization;//기관고객(기업, 학교)에 대한 명성
	
	private int totalRevenue;//총 수입
	private int totalInvestedTime;//총 투자 시간
	//필요한 변수들 선언 END
	
	
	//Getter, Setter 선언 START
	public int getReputationForIndividual() {
		return reputationForIndividual;
	}
	public void setReputationForIndividual(int reputationForIndividual) {
		this.reputationForIndividual = reputationForIndividual;
	}

	public int getReputationForOrganization() {
		return getReputationForOrganization;
	}

	public void setReputationForOrganization(int reputationForOrganization) {
		this.getReputationForOrganization = reputationForOrganization;
	}

	public int getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public int getTotalInvestedTime() {
		return totalInvestedTime;
	}

	public void setTotalInvestedTime(int totalInvestedTime) {
		this.totalInvestedTime = totalInvestedTime;
	}
	//Getter, Setter 선언 END

	
	
	
	
}
