package differentation;

import sky.Providence;

public class MarketingBuzz extends Action{

	@Override
	public void doAction() {

		Differentation differentation = Differentation.getInstance();
		Providence providence = Providence.getInstance();
		
		int reputationForIndividual = differentation.getReputationForIndividual();
		reputationForIndividual = providence.bestowIncrementOfReputation(reputationForIndividual);
		
		differentation.setReputationForIndividual(reputationForIndividual);
		
	}

}
