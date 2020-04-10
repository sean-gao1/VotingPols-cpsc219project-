package model; 

public class HippoMain {
	
	// Goal: To run the classes in Iteration 1 and help in debugging 

	
	public static void main ( String args[]) {
				
		// Create partyOne  
		Party partyOne = new Party("partyOne", 25, 25); 
		System.out.println(partyOne);

		// Create partyTwo  
		Party partyTwo = new Party("partyTwo", 25, 25); 
		System.out.println(partyTwo);
		
		// Create partyThree 
		Party partyThree = new Party("partyThree", 75, 75); 
		System.out.println(partyThree);
		
		// Create partyFour 
		Party partyFour = new Party("partyFour", 30, 30); 
		System.out.println(partyFour);
		
		
		// Create PollOne 
		Poll pollOne = new Poll("PollOne", 1); 		
		pollOne.addParty(partyOne);

		// Create PollTwo 
		Poll pollTwo = new Poll("PollTwo", 2); 		
		pollTwo.addParty(partyOne);
		pollTwo.addParty(partyTwo);

		
		// Create PollThree
		Poll pollThree = new Poll("PollThree", 3); 		
		pollThree.addParty(partyOne);
		pollThree.addParty(partyTwo);
		pollThree.addParty(partyThree);
		
		// Create PollFour
		Poll pollFour = new Poll("PollFour", 4); 		
		pollFour.addParty(partyOne);
		pollFour.addParty(partyTwo);
		pollFour.addParty(partyThree);
		
		
		// Create PollList 
		PollList pollList = new PollList (3, 100); 
		pollList.addPoll(pollOne);
		pollList.addPoll(pollTwo); 
		pollList.addPoll(pollThree);
		pollList.addPoll(pollFour);
		System.out.println("End of Code"); 
	} 
	
	
}
