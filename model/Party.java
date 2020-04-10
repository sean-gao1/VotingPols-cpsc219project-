package model; 
public class Party {
	/**
	 * I made a private instance variable name 
	 * and you can change it by a public setter method 
	 * or check it by a getter method
	 */
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	/**
	 * I made a private instance variable projectedNumberOfSeats 
	 * and you can change it by a public setter method 
	 * or check it by a getter method
	 */	
	private float projectedNumberOfSeats;
	public void setProjectedNumberOfSeats(float projectedNumberOfSeats) {
		if(projectedNumberOfSeats > 0) {
			this.projectedNumberOfSeats = projectedNumberOfSeats;
		}
	}
	public float getProjectedNumberOfSeats() {
		return projectedNumberOfSeats;
	}
	
	/**
	 * I made a private instance variable projectedPercentageOfVotes 
	 * and you can change it by a public setter method 
	 * or check it by a getter method
	 */		
	private float projectedPercentageOfVotes;
	public void setProjectedPercentageOfVotes(float projectedPercentageOfVotes) {
		if(projectedPercentageOfVotes <= 1 && projectedPercentageOfVotes >=0) {
			this.projectedPercentageOfVotes = projectedPercentageOfVotes;
		}
	}
	public float getProjectedPercentageOfVotes() {
		return projectedPercentageOfVotes;
	}
	

	
	/**
	 * These are two constructor for the class
	 */
	public Party(String partyName) {
		setName(partyName);
		
	}
	public Party(String partyName, float projectedSeats, float projectedPercentOfVote) {
		setName(partyName);
		setProjectedNumberOfSeats(projectedSeats);
		setProjectedPercentageOfVotes(projectedPercentOfVote);
	}
	
	/**
	 * This is a simple toString method
	 */
	public String toString() {
		return name + "(" + projectedPercentageOfVotes*100 + "%, " + projectedNumberOfSeats + ")";
	}
	
	/**
	 * The returned value is the percentage of seats the the party is expected to win
	 * the value is a number between 0 and 1
	 */
	public double projectedPercentOfSeats(int totalSeats) {
		return projectedNumberOfSeats/totalSeats;
	}
	
	/**
	 * This method returns a string, which contain * and |, to represent whether the party has more seats than needed for majority or not
	 * The method has two version, if the # of star's first decimal point is >= 5, then the int of stars'# plus one(10.56 = 11 stars)
	 * if the # of star's first decimal point is < 5, then the int of stars'# remain the same(5.43478 = 5 stars)
	 * the returned string contains *, |, name of the Party, expected percentage of votes and expected # of seats
	 */
	public String textVisualizationBySeats(int maxStars, int starsNeededForMajority, double numOfSeatsPerStar) {
		double projected = projectedNumberOfSeats/numOfSeatsPerStar;
		String text = "";
		int sum = 0; 
		
		if (projected-(int)projected >= 0.5) {
			for(double star = 0; star <= projected; star = star + 1.0) {
				text = text + "*";
				sum++;
				if(sum == starsNeededForMajority-1) {
					text = text + "|";
				}
			}
			int sum2 = sum;
			if(projected < maxStars) {
				for(int blank = 0; blank < maxStars - sum; blank++) {
					text = text + " ";
					sum2++;
					if(sum2 == starsNeededForMajority-1) {
						text = text + "|";
					}	
				}
			}
		}
		else if (projected-(int)projected < 0.5) {
			for(double star = 1; star <= projected; star = star + 1.0) {
				text = text + "*";
				sum++;
				if(sum == starsNeededForMajority-1) {
					text = text + "|";
				}
			}
			int sum2 = sum;
			if(projected < maxStars) {
				for(int blank = 0; blank < maxStars - sum; blank++) {
					text = text + " ";
					sum2++;
					if(sum2 == starsNeededForMajority-1) {
						text = text + "|";
					}	
				}
			}
		}
		return text + "  " + toString();
	}
	
	/**
	 *same as textVisualizationBySeats, it takes percentageOfVotesPerStar as an argument instead of percentageOfSeatsPerStar
	 */
	public String textVisualizationByVotes(int maxStars, int starsNeededForMajority, double percentOfVotesPerStar) {
		double projected = (projectedPercentageOfVotes*100)/percentOfVotesPerStar;
		String text = "";
		int sum = 0; 
		
		if (projected-(int)projected >= 0.5) {
			for(double star = 0; star <= projected; star = star + 1.0) {
				text = text + "*";
				sum++;
				if(sum == starsNeededForMajority-1) {
					text = text + "|";
				}
			}
			int sum2 = sum;
			if(projected < maxStars) {
				for(int blank = 0; blank < maxStars - sum; blank++) {
					text = text + " ";
					sum2++;
					if(sum2 == starsNeededForMajority-1) {
						text = text + "|";
					}	
				}
			}
		}
		else if (projected-(int)projected < 0.5) {
			for(double star = 1; star <= projected; star = star + 1.0) {
				text = text + "*";
				sum++;
				if(sum == starsNeededForMajority-1) {
					text = text + "|";
				}
			}
			int sum2 = sum;
			if(projected < maxStars) {
				for(int blank = 0; blank < maxStars - sum; blank++) {
					text = text + " ";
					sum2++;
					if(sum2 == starsNeededForMajority-1) {
						text = text + "|";
					}	
				}
			}
		}
		return text + "  " + toString();
	}
	
	public static void main(String[] args) {


	    Party p2 = new Party("William", 190, 0.53f);
	    Party p1 = new Party("Tonny", 25, 0.36f);
	    System.out.println("Expect output: *********|**           William (53%, 190)");
	    System.out.println("Actual output: "+p2.textVisualizationBySeats(20, 10, 18.0));
	    System.out.println("Expect output: *****  |          Tonny (36%, 25)");
	    System.out.println("Actual output: "+p1.textVisualizationBySeats(15, 8, 4.6));
	    System.out.println("Actual output: "+p2.textVisualizationByVotes(20, 10, 18.0));
	}
}