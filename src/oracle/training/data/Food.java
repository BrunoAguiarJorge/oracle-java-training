package oracle.training.data;

import java.time.LocalDate;

public class Food extends Product{

	LocalDate bestBefore;

	public Food() {
		super();
	}

	public LocalDate getBestBefore() {
		return bestBefore;
	}

	public void setBestBefore(LocalDate bestBefore) {
		this.bestBefore = bestBefore;
	}
	
	
	
	
}
