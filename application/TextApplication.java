package application;

import java.util.Scanner;
import model.Factory;
import model.Party;
import model.Poll;
import model.PollList;

import java.util.ArrayList;
public class TextApplication {
	
	private int MAX_NUMBER_OF_STARS = 25;
	private static  PollList polls;
	private int starsNeededForMajority = 10;
	private int numOfSeatsPerStar = 5;
	
	
	public TextApplication() {
		
	}
	
	public TextApplication(PollList polls) {
		TextApplication.polls = polls;
	}
	
	public int getMaxStar() {
		return MAX_NUMBER_OF_STARS;
	}
	
	public void displayPollDataBySeat(Poll poll) {
		Party[] parties = poll.getPartiesSortedBySeats();
		System.out.println(poll.getPollName());
		for(Party p : parties) {
			if(p != null ) {
			System.out.println(p.textVisualizationBySeats(MAX_NUMBER_OF_STARS, starsNeededForMajority, numOfSeatsPerStar));
			}
		}
		
		/*
		Party[] allParties= new Party[100];
		allParties= apoll.getPartiesSortedBySeats();
		int numberOfSeats = polls.getNumOfSeats();
		int starsNeededForMajority = Max_NUMBER_OF_STARS / 2 + 1;
		double numOfSeatsPerStar = (int) Math.ceil(numberOfSeats / Max_NUMBER_OF_STARS);
		System.out.println(apoll.getPollName());
		for (Party aparty:allParties) {
			System.out.println(aparty.textVisualizationBySeats(Max_NUMBER_OF_STARS, starsNeededForMajority, numOfSeatsPerStar));
		} */
		
	}
	
	public void displayPollsBySeat(String[] partyNames) {
		for (Poll apoll : polls.getPolls()) {
			displayPollDataBySeat(apoll);
		}
		System.out.println("");
		displayPollDataBySeat(polls.getAggregatePoll(partyNames));
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the poll tracker");
		
		System.out.println("How many seats are available in the election?");
		Scanner innum = new Scanner(System.in);
		int numOfSeats = innum.nextInt();
		
		
		System.out.println("Which parties are in the election (provide names, comma separated):");
		Scanner intext = new Scanner(System.in);
		String[] partyNames = intext.nextLine().split(",");
		for(String s : partyNames) {
		System.out.println(s);}
		
		System.out.println("How many polls do you want to track with this application?");
		int numOfPolls = intext.nextInt();
		
		
		System.out.println("Would you like me to create a random set of polls?");
		Scanner intext2 = new Scanner(System.in);
		String randomornot = intext2.nextLine();
		
		
		if(randomornot.toUpperCase().equals("YES")) {
			/*PollList polllist = new PollList(numOfPolls, 
					                         numOfSeats);*/
			Factory factory = new Factory(numOfSeats);
			factory.setPartyNames(partyNames);
			
			/*
			for(String s: factory.getPartyNames()) {
				System.out.println("factory party names: " + s);
			} */
			PollList polllist = factory.createRandomPollList(numOfPolls);
			TextApplication newapp = new TextApplication(polllist);
		
		
		
		System.out.println("Options: all (show result of all polls), aggregate (show aggregate result), quit (end application)Choose an option:");
		Scanner intext3 = new Scanner(System.in);
		String form = intext3.nextLine();
		
		if(form.toUpperCase().equals("AGGREGATE")) {
			
			/*
			for(Poll poll : polllist.getPolls()) {
				System.out.println(poll.getPollName());
				System.out.println("");
				for(Party p: poll.getPartiesSortedBySeats()) {
					System.out.println(p);
				}
			} */
			newapp.displayPollDataBySeat(polllist.getAggregatePoll(partyNames));
			
			
		}
		if(form.toUpperCase().equals("ALL")) {
			newapp.displayPollsBySeat(partyNames);
		}
		
		
		}
		
		/*
		
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		System.out.println("Welcome to the poll tracker");
		String QuitOrNot = "all";
		while(QuitOrNot != "quit") {
			System.out.print("How many seats are avaliable in the election?");
			int numberOfSeats;
			Scanner in2 = new Scanner(System.in);
			numberOfSeats = in2.nextInt();
			
			System.out.print("Which parties are in the election (provide names, comma separated):");
			String[] partyNames;
			partyNames = in1.nextLine().split(",");
			
			System.out.print("How many polls do you want to track with this application?");
			int numOfPolls;
			numOfPolls = in.nextInt();
			
			System.out.print("Would you like me to creat a random set of polls?");
			String answer;
			answer = in1.nextLine();
			
			Factory factory = new Factory (numberOfSeats);
			factory.setPartyNames(partyNames);
			
			if (answer =="Yes") {
				factory.createRandomPollList(numOfPolls);
			}
			
			else {
				factory.promptForPollList(numOfPolls);
			}
			
			TextApplication app = new TextApplication(polls);
			System.out.print("Options: all (show result of all polls), aggregate(show aggregate result), quit(end application)");
			QuitOrNot = in.nextLine();
			
			if(QuitOrNot == "all") {
				app.displayPollsBySeat(factory.getPartyNames());
			}
			
			else if (QuitOrNot == "aggregate") {
				app.displayPollDataBySeat(polls.getAggregatePoll(factory.getPartyNames()));
			}
		}
		
		*/
	}
		
	


}