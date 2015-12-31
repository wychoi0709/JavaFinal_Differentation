package differentation;

public class Differentation {


	private static Differentation instance = new Differentation();
	
	private Differentation(){
		//�⺻ ��Ǯ(�ʱ�ȭ��)�� ���迭�� ������� ��
	}
	
	public static synchronized Differentation getInstance(){//���߿� Thread���� ����� ���� 
		
		if(instance  ==null){ 
			instance  = new Differentation(); 
		}

		return instance;
	}
	
	//�ʿ��� ������ ���� START
	private int reputationForIndividual;//���ΰ�(���л�, ���л�, �Ϲ���)�� ���� ��
	private int getReputationForOrganization;//�����(���, �б�)�� ���� ��
	
	private int totalRevenue;//�� ����
	private int totalInvestedTime;//�� ���� �ð�
	//�ʿ��� ������ ���� END
	
	
	//Getter, Setter ���� START
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
	//Getter, Setter ���� END

	
	
	
	
}
