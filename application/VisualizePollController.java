package application;

import model.Poll;
import model.PollList;
import model.Party;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;

public class VisualizePollController extends PollTrackerController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> mychoicebox;

    @FXML
    private PieChart piechartbyseats;

    @FXML
    private PieChart piechartbypercent;
    

    private int numberofparties = 7;
    
    private void changePieChart(String pollname) {
    	PollList polls = super.getPolls();
    	if(pollname.equals("aggregate")) {
    		String[] partynames = super.getFactory().getPartyNames();
    		
    		Poll aggregate = polls.getAggregatePoll(partynames);
    		
    		PieChart.Data[] percentdata  =new PieChart.Data[numberofparties];
    		PieChart.Data[] seatsdata = new PieChart.Data[numberofparties];
    		/*
    		for(int counter =0; counter < numberofparties; counter++) {
    			percentdata[counter]=new PieChart.Data(, arg1)
    		}
    		*/
    		int counter = 0;
    		for(String party: partynames) {
    			percentdata[counter] = new PieChart.Data(party,
    					aggregate.getParty(party).getProjectedPercentageOfVotes());
    			seatsdata[counter] = new PieChart.Data(party, aggregate.getParty(party).getProjectedNumberOfSeats());
    			counter++;
    			
    		}
    		
    		piechartbypercent.setData(FXCollections.observableArrayList(percentdata));
    		piechartbyseats.setData(FXCollections.observableArrayList(seatsdata));
    	}
    	else {
    		String[] partynames = super.getFactory().getPartyNames();
    		int pollnumber = Integer.parseInt(String.valueOf(pollname.charAt(4)));
    		
    		Poll[] pollarray = polls.getPolls();
    		Poll targetpoll = pollarray[pollnumber];
    		
    		PieChart.Data[] percentdata  =new PieChart.Data[numberofparties];
    		PieChart.Data[] seatsdata = new PieChart.Data[numberofparties];
    		/*
    		for(int counter =0; counter < numberofparties; counter++) {
    			percentdata[counter]=new PieChart.Data(, arg1)
    		}
    		*/
    		int counter = 0;
    		for(String party: partynames) {
    			percentdata[counter] = new PieChart.Data(party,
    					targetpoll.getParty(party).getProjectedPercentageOfVotes());
    			seatsdata[counter] = new PieChart.Data(party, targetpoll.getParty(party).getProjectedNumberOfSeats());
    			counter++;
    			
    		}
    		
    		piechartbypercent.setData(FXCollections.observableArrayList(percentdata));
    		piechartbyseats.setData(FXCollections.observableArrayList(seatsdata));
    		
    	}
    }
    
    
    /**
     * 
     */
  
    @FXML
    void initialize() {
        
        
    }

	@Override
	public void refresh() {
		assert mychoicebox != null : "fx:id=\"mychoicebox\" was not injected: check your FXML file 'VisualizePollView.fxml'.";
        assert piechartbyseats != null : "fx:id=\"piechartbyseats\" was not injected: check your FXML file 'VisualizePollView.fxml'.";
        assert piechartbypercent != null : "fx:id=\"piechartbypercent\" was not injected: check your FXML file 'VisualizePollView.fxml'.";
        
        
        
        
        piechartbypercent.setLabelLineLength(1);
        piechartbypercent.setLegendSide(Side.BOTTOM);
        
        piechartbyseats.setLabelLineLength(1);
        piechartbyseats.setLegendSide(Side.BOTTOM);
        
        //String[] values = {"Poll1", "Poll2", "Poll3", "Poll4", "Poll5",
        	//	"aggregate"};
        
        int numofpolls = getPolls().getPolls().length;
        String[] values = new String[numofpolls +1];
        values[numofpolls]  ="aggregate";
        int i = 0;
        
        for(i = 0; i <=numofpolls-1;i++){
        	
        	values[i] =  "Poll" + i;
        }
        mychoicebox.setItems(FXCollections.observableArrayList(values));
        
        mychoicebox.getSelectionModel().selectedItemProperty().addListener((v,oldValue, newValue)->changePieChart(newValue));
		
	}
    
	
}

