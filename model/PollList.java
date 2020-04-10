package model;

import java.util.Scanner;



import java.util.ArrayList;
import java.util.Arrays;


/**Class to add polls and aggregate parties from different polls
* 
*@param polls: different polls gathered together as a Poll type
*@param numOfSeats:  Gives the number of seats in each poll
*@param pollsInList: Gives the number of polls in the poll list in any stage of adding polls process
*The instance variable pollsInList should be removed and should not be included in your final version*/

public class PollList {
	
	/** This class represents a collection of polls that all collect data for the same election */ 
	private Poll[] polls;   
	private int numOfSeats;
	private int pollsInList;
	
	
	
	
	
	/**Constructor that takes numOfSeats and numOfPolls
	 * 
	 * @param numOfPolls:  assigning the initial number of polls to the related instance variable in the constructor
	 * @param numOfSeats:  assigning the initial number of seats to the related instance variable in the constructor
	 
	 * pollsInList will be set to zero at the beginning*/
	
	public PollList(int numOfPolls, int numOfSeats) {

		polls = new Poll[numOfPolls];
		this.numOfSeats = numOfSeats;
		pollsInList = 0;
	}
	
	
	public Poll[] getPolls() {
		if(polls.length <=0) {
			return null;
		}
		else {
		return polls;
		}
	}
	

	/**Class specifying a method to add the polls in to an array with required conditions
	 * @param a aPoll of Poll type to be added to the specified array
	 * @return does not return anything just processes adding polls
	 * 
	 * conditions:
	 * 1-if the argument is null (error massage)
	 * 2-if the array is full(massage1)
	 * 3-otherwise add to the end of the list!*/
	

	public void addPoll(Poll aPoll) {
		
		
		
		/**Checking if the argument is null!:*/
		/*if (aPoll==null) {
			System.out.println("System Error!");
		}
		
		
		/**Checking if the array is full!*/
		/*else if (pollsInList == polls.length){
			System.out.println("Array is full!");   
		}
		
		
		/**checking if there is a duplicate in the array before inserting the argument to the array and then adding the element 
		 * to the end of the array if it is not null!*/
		/*else  {

			for (int i= 0; i <pollsInList; i++) {

                /**Do all conversion to lower or upper!!!!!*/
				/*if(polls[i].getPollName().equalsIgnoreCase(aPoll.getPollName())) {

					
					/**Replace duplicate element with last unique element*/
					/*polls[i] = aPoll;
					return;
				}
			} 
			polls[pollsInList++] = aPoll;
		}
		*/
		 if(aPoll != null) { // if the argument is not  null:
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		        if(polls[0]!=null) {
			boolean full = true;
			for(Poll p : polls) {
				
				
				
				
				
				
				
				if ( p == null) {
					full = false;
				} // test if the party array is full.
			}
			
			
			
			
			
			
			
			if (full) {
				System.out.println("The poll array is already full!!");
			}
			
			else {
				// if the party array is not full, two cases: duplicate or not;
				boolean samename = false;
				for (Poll p : Arrays.asList(polls).subList(0, pollsInList)){
					
					if(sameNameForPoll(p,aPoll)) {
						samename  = true;
					}
				}
				
				
				
				
				
				// if there is no duplicate
				if(samename == false) {
					polls[pollsInList] = aPoll;// add the new party to the partiesInPoll'th index.
					pollsInList++;  // add the number of parties by 1.
				}
				else /*if there is a duplicate: */{
					int i =0;
					for(Poll p: polls) {
						
						if(p.getPollName().toUpperCase().equals(aPoll.getPollName().toUpperCase())) {
							break;
						}
						i++;
					} // Here , i is the index of the duplicate element.
					
					
					polls[i] = aPoll;  // do the replacement.
					
				}
				
				
				
				
				
				
			}
		    }
		    
		    else {
		    	polls[0] = aPoll;
		    	pollsInList = 1;
		    }
		        
		        
		        
		        
		        
		        
		        
		}
		    else {  // the else case: the argument is null, print a warning message:
		    	System.out.println("Cannot add a null party to the array!!!");
		    }
				

	}
	
	public boolean sameNameForPoll(Poll p1,Poll p2) {
		/*int c=0;
		boolean sameName=false;
		while(c<p1.getName().length()){
			if(p1.getName().charAt(c)!=p2.getName().charAt(c)
					&& p1.getName().charAt(c)+32!=p2.getName().charAt(c)
					&& p1.getName().charAt(c)-32!=p2.getName().charAt(c)) {
				c=p1.getName().length();
				sameName=false;
			}
			else{
				sameName=true;
				c++;
			}
					
		}*/
		if(p1.getPollName()==null && p2.getPollName()==null) {
			return true;
		}
		else if(p1.getPollName()== null || p2.getPollName() == null) {
			return false;
		}
		else {
		return p1.getPollName().toUpperCase().equals(p2.getPollName().toUpperCase());
		}
	}	



	/**Class get aggregate: aggregating different parties from different polls and adding them into one array
	 *checking if the total number of seats for a party from all the polls is equal to number of seats 
	 *(The same for projected percentage of votes) and if not fixes them according to their distributions 
	 *
	 *@param partyNames:   Array of string type for party names as an argument
	 *@param count:        Keep the track of number of parties reading into temp array 
	 *@return An array of Poll type which has the aggregate of parties from different polls*/
	
	

public Poll getAggregatePoll(String[] partyNames) {

	int aggregatelen = 0;
	String[] partynamesincluded = new String[partyNames.length];
	
 int numofpartiesincluded =0;
	for(String partyname : partyNames) {
		
		//boolean included = false;
		
		for(Poll poll : polls) {
			if(poll.getParty(partyname).equals(null) ==false ) {
				aggregatelen ++;
				//included = true;
			
				partynamesincluded[numofpartiesincluded] = partyname;
				/* this is a string array of the names of all parties 
				that is included in any poll in the poll[]; */
				
				
			 numofpartiesincluded ++;
				break;
			}
			
		}
	}
	
	Poll aggregate = new Poll("aggregate",aggregatelen);

	float totalnumofseats = 0, totalpercentageofvotes  = 0;
	
	for(String partyname :partynamesincluded) {
		float totalnumofseatsoftheparty = 0;
		float totalpercentageofvotesoftheparty = 0;
		int denominator = 0;
		Party newparty = new Party("");
		for(Poll p: polls) {
			if (p.getParty(partyname).equals(null)== false){
				totalnumofseatsoftheparty += p.getParty(partyname).getProjectedNumberOfSeats();
				totalnumofseats += p.getParty(partyname).getProjectedNumberOfSeats();
				totalpercentageofvotesoftheparty += p.getParty(partyname).getProjectedPercentageOfVotes();
				totalpercentageofvotes += p.getParty(partyname).getProjectedPercentageOfVotes();
				denominator ++;
			}
		}
		newparty = new Party(partyname, 
				totalnumofseatsoftheparty/denominator,
				totalpercentageofvotesoftheparty/denominator);
		aggregate.addParty(newparty);
	}
	
	if(totalnumofseats > numOfSeats) {
	    for( Party p  : aggregate.getPartiesSortedBySeats()) {
	    	p.setProjectedNumberOfSeats(p.getProjectedNumberOfSeats()*numOfSeats/totalnumofseats);
	    }
	    
	}
	
	if(totalpercentageofvotes > 1) {
	for(Party p : aggregate.getPartiesSortedByVotes()) {
		p.setProjectedPercentageOfVotes(p.getProjectedPercentageOfVotes()/totalpercentageofvotes);
	}
		
	}
		
		return aggregate;
        
    /**Creating of a Poll type named aggregate to to put the final results in that*/
	//Poll aggregate = new Poll("aggregate", partyNames.length);

	/**Counter to keep the number of parties reading into temp array*/
	//int count=0;


	/**A temporary array to pre-process that all polls to make sure that the have all the parties included:*/
	//Poll[] temp=new Poll[polls.length];
	

	/**Looping through the polls to check if they have all partyNames:*/
	/*for (int i=0; i<polls.length; i++ ) {
		boolean included=true;
		for (int j=0; j<partyNames.length; j++ ) {


			/**look if there is a party with this name or not*/

			/*Party p=polls[i].getParty(partyNames[j]);


			/**If any party name is not in the polls (null)that poll will be ignored*/
			/*if (p == null) {
				included=false;
			}

		}

		/**polls that have all parties will be added to temp*/
		/*if (included) {
			temp[count] = polls[i];
			count=count+1;
		}

	}

	/**looping through partyNames to calculate the number of seats and PPV*/
	/*for(int n=0; n < partyNames.length; n++) {


		/**defined for each party!*/
		/*double sum_seat = 0.0;
		double sum_perc = 0.0;


		/**Creating a party object(p) to go through all partyNames 
		* with its related variable in its constructor*/
		
		/*for (int i=0; i<temp.length; i++) {
			Party p = temp[i].getParty(partyNames[n]);
			sum_seat += p.getProjectedNumberOfSeats();
			sum_perc += p.getProjectedPercentageOfVotes();

		}
       
		/**adding each part from different polls and theirs num of seats and PPV to the aggregate array*/
		/*Party new_p = new Party(partyNames[n], (float)sum_seat/partyNames.length, (float)sum_perc/partyNames.length);
		aggregate.addParty(new_p);
	}


	float sumOfSeats=0;
	float sumOfPerc=0;

	for (int i=0; i< partyNames.length; i++) {
		Party new_p2= aggregate.getParty(partyNames[i]);
		sumOfSeats+=new_p2.getProjectedNumberOfSeats();
		sumOfPerc+=new_p2.getProjectedPercentageOfVotes();
	}


		/**Checking the condition if the number of seats are more than total number of seats:
		 * Rearranging the number of seats and projected percentage of votes according to unchanged distribution:
		 */

	/*if (sumOfSeats> numOfSeats) {

		for (int i=0; i< partyNames.length; i++) {
			Party new_p2= aggregate.getParty(partyNames[i]);
			new_p2.projectedPercentOfSeats((int)(numOfSeats*(new_p2.getProjectedNumberOfSeats()/sumOfSeats)));

			new_p2.setProjectedPercentageOfVotes((int)(100*(new_p2.getProjectedPercentageOfVotes()/sumOfPerc)));
		}

	}

	/**returning the aggregate poll for all the polls of each party:*/
	//return aggregate;
}

	









/**Getter and Setter methods:
	 *@return number of seats
	 *@return the array named polls
	 *@Param takes the array polls of Poll type
	 *@param takes the number of seats */	

	

public int getNumOfSeats() {
	return numOfSeats;
}


public void setPolls(Poll[] polls) {
	this.polls = polls;
}


public void setNumOfSeats(int numOfSeats) {
	this.numOfSeats = numOfSeats;
}

}