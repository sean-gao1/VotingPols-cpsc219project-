package model;
import java.util.ArrayList;
import java.util.Collections;



import java.util.Arrays;
public class Poll {
	private String name;
	private Party[] parties;
	private int partiesInPoll;

	public Poll(String name, int maxNumberOfParties) {
		if(maxNumberOfParties<1) {
			maxNumberOfParties=10;
		}
		this.name = name; 
		parties = new Party[maxNumberOfParties];
	}
	
	public String getPollName() {
		if(name != null) {
		return name;
		}
		else {
			return "null poll";
		}
	}
	public String setPollName(String Name) {
		name=Name;
		return name;
	}
	
	public int getPartiesInPoll() {
		return partiesInPoll;
	}
	public void setPartiesInPoll(int p) {
		partiesInPoll = p;
	}
	

	public void addParty(Party aParty) {
		/*Party[] newpoll = new Party[partiesInPoll];
		int p=0;
		int i = 0;
		boolean sameName=false;
		for(Party anParty:parties) {
			sameName=sameName(anParty,aParty);
			if(sameName==false){
				newpoll[i] = anParty;
				i++;
			}
			p++;
		}
		parties.add(aParty);*/
		
	    if(aParty != null) { // if the argument is not  null:
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	        if(parties[0]!=null) {
		boolean full = true;
		for(Party p : parties) {
			
			
			
			
			
			
			
			if ( p == null) {
				full = false;
			} // test if the party array is full.
		}
		
		
		
		
		
		
		
		if (full) {
			System.out.println("The party array is already full!!");
		}
		
		else {
			// if the party array is not full, two cases: duplicate or not;
			boolean samename = false;
			for (Party p : parties){
			    if(p != null) {
				if(sameName(p,aParty) ) {
					samename  = true;
				}
			}
			
			}
			
			
			
			// if there is no duplicate
			if(samename == false) {
				parties[partiesInPoll] = aParty;// add the new party to the partiesInPoll'th index.
				partiesInPoll++;  // add the number of parties by 1.
			}
			else /*if there is a duplicate: */{
				int i =0;
				for(Party p: parties) {
					
					if(p.getName().toUpperCase().equals(aParty.getName().toUpperCase())) {
						break;
					}
					i++;
				} // Here , i is the index of the duplicate element.
				
				
				parties[i] = aParty;  // do the replacement.
				
			}
			
			
			
			
			
			
		}
	    }
	    
	    else if (parties[0] == null){
	    	parties[0] = aParty;
	    	partiesInPoll = 1;
	    }
	        
	        
	        
	        
	        
	        
	        
	}
	    else {  // the else case: the argument is null, print a warning message:
	    	System.out.println("Cannot add a null party to the array!!!");
	    }
			
			
	}
	
	
	public boolean sameName(Party p1,Party p2) {
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
		if(p1.getName()==null && p2.getName()==null) {
			return true;
		}
		else if(p1.getName()== null || p2.getName() == null) {
			return false;
		}
		else {
		return p1.getName().toUpperCase().equals(p2.getName().toUpperCase());
		}
	}	

	public Party getParty(String name) {
		boolean exists = false;
		Party p = new Party("");
		for(Party aParty:  Arrays.asList(parties).subList(0, partiesInPoll)) {
			if(aParty.getName().toUpperCase().equals(name.toUpperCase())) {
				p = aParty;
				exists  = true;
			}
			
			
		}
		if(exists == false) {
			return null;
		}
		else {return p;}
		
	}
	
	public Party[] getPartiesSortedBySeats() {
		/*
		//Array list of floats called seats
		ArrayList<Float> seats=new ArrayList<Float>(partiesInPoll);
		//for loop that iterates over parties
		for(Party aParty:parties) {
			//for each item in parties add the projected number of seats for that party to 
			// the array list seats
			seats.add(aParty.getProjectedNumberOfSeats());
		}
		Collections.sort(seats);
		ArrayList<Party> partiesOrdered=new ArrayList<Party>(partiesInPoll);
		int c=0;
		while(c<partiesInPoll) {
			int p=0;
			while(p<partiesInPoll) {
				
				int equals=Float.compare(seats.get(c),parties.get(p).getProjectedNumberOfSeats());
				if(equals==0) {
					if(c==0) {
					partiesOrdered.add(c,parties.get(p));
					p=partiesInPoll;
					}
					else {
						int p1=p;
						for(Party aParty:partiesOrdered) {
							
							boolean sameName=sameName(aParty,parties.get(p));
							if(sameName) {
								p1++;
							}
						}
						if(p1==p) {
							partiesOrdered.add(c,parties.get(p));
							p=partiesInPoll;
						}
						else{
							p=p1;
						}
						
					}
				}
				else {
					p++;
				}
			}
			c++;
		}
		Collections.reverse(partiesOrdered);		
		Collections.copy(parties,partiesOrdered);
		*/
		int i =0;
		Party p =  new Party("");
		
		
		//Use Bubble Sort:
		for(i =0; i <= partiesInPoll-2;i++) {
			for(int j = i;j <= partiesInPoll -2; j ++) {
				if(parties[j+1] != null && 
						parties[j] != null&&
						parties[j].getProjectedNumberOfSeats()<parties[j+1].getProjectedNumberOfSeats()) {// If the previous one is smaller:
					
					p = parties[j];
					parties[j] = parties[j+1];
					parties[j+1] = p; // exchange the j'th and j+1'th element.
				}
			}
		}
		
		return parties;
	}

	public Party[] getPartiesSortedByVotes() {
		/*
		//Array list of floats called seats
		ArrayList<Float> votes=new ArrayList<Float>(partiesInPoll);
		//for loop that iterates over parties
		for(Party aParty:parties) {
			//for each item in parties add the projected number of seats for that party to 
			// the array list seats
			votes.add(aParty.getProjectedPercentageOfVotes());
		}
		Collections.sort(votes);
		ArrayList<Party> partiesOrdered=new ArrayList<Party>(partiesInPoll);
		int c=0;
		while(c<partiesInPoll) {
			int p=0;
			while(p<partiesInPoll) {
						
				int equals=Float.compare(votes.get(c),parties.get(p).getProjectedPercentageOfVotes());
				if(equals==0) {
					if(c==0) {
					partiesOrdered.add(c,parties.get(p));
					p=partiesInPoll;
					}
					else {
						int p1=p;
						for(Party aParty:partiesOrdered) {

							boolean sameName=sameName(aParty,parties.get(p));
							if(sameName) {
								p1++;
							}
						}
						if(p1==p) {
							partiesOrdered.add(c,parties.get(p));
							p=partiesInPoll;
						}
						else{
							p=p1;
						}

					}
				}
				else {
					p++;
				}
			}
			c++;
		}
		Collections.reverse(partiesOrdered);		
		Collections.copy(parties,partiesOrdered);
		*/
		int i =0;
		Party p =  new Party("");
		
		
		//Use Bubble Sort:
		for(i =0; i <= partiesInPoll-2;i++) {
			for(int j = i;j <= partiesInPoll -2; j ++) {
				if(parties[j].getProjectedPercentageOfVotes()<parties[j+1].getProjectedPercentageOfVotes()) {// If the previous one is smaller:
					p = parties[j];
					parties[j] = parties[j+1];
					parties[j+1] = p; // exchange the j'th and j+1'th element.
				}
			}
		}
		
		return parties;

		
}
	
	public String toString() {
		String poll=name;
		for(Party aParty:parties) {
			poll=poll+"\n"+aParty;
		}
		return poll;
	}
	//Test Method
		public static void main(String[] args) {
		Poll Election2019=new Poll("2019 Canadian Federal Election",34);
		Party PC=new Party("Conservative",(float)121,(float)0.34);
		Election2019.addParty(PC);
		Party LB=new Party("Liberal",(float)157,(float)0.33);
		Election2019.addParty(LB);
		Party BQ=new Party("Bloc Quebecois",(float)32,(float)0.076);
		Election2019.addParty(BQ);
		Party NDP=new Party("NDP",(float)24,(float)0.15);
		Election2019.addParty(NDP);
		Party GN=new Party("green",(float)3,(float)0.06);
		Election2019.addParty(GN);
		Party PL=new Party("People's",(float)0,(float)0.02);
		Election2019.addParty(PL);
		Party GR=new Party("Green",(float)3,(float)0.07);
		Election2019.addParty(GR);
		Election2019.getPartiesSortedBySeats();
		System.out.println(Election2019);
		Factory x=new Factory(345);
		/* Poll poll=x.createRandomPoll("P2");
		poll.getPartiesSortedBySeats();
		System.out.println(poll); */
		
		
	}
}
