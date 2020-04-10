package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.PollList; 

public class SetupPollTrackerController extends PollTrackerController{

	
/**
 * Goal: To setup a new poll tracker (PollList Class) by prompting for and collecting input from the user regarding the number of seats
 * in the election and the number of polls to track. 
 * Note: Dr. Verwaal instructed us to ignore all parts of the assignment dealing with the Party class
 */
	
	
// VARIABLES

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clearButton;
    
    @FXML
    private Button submitButton;

    @FXML
    private TextField numberOfSeats;

    @FXML
    private TextField numberOfPolls;


// METHODS

    /**
     * Goal: Clear all Text Fields in the tab 
     * @param Actionevent
     */
    @FXML
    void reactToClear(ActionEvent event) {
    	numberOfSeats.clear(); 
    	numberOfPolls.clear(); 
    }
    
  /**
  * Goal: Get the user's input on the number of Polls and number of seats using the text field, parse them into integers
  * and assign to appropriate variables. Create a new instance of PollList and set the user input to the appropriate variables in the instance.   
  * @param Actionevent*/ 
   @FXML
    void reactToSubmit(ActionEvent event) {

    	 int numOfSeats = Integer.parseInt(numberOfSeats.getText()); 
    	 int numOfPolls = Integer.parseInt(numberOfPolls.getText());
    	
    
    	//PollList newList = getFactory().createRandomPollList(numOfPolls);   		// Option 1: use when not getting user input
    	PollList newList = new PollList(numOfPolls, numOfSeats);					// Option 2: use when getting user input
    	setPolls(newList);
    	
    }

    /**
     * Goal: Initialize all SceneBuilder Nodes that interact with the user
     */
    @FXML
    void initialize() {
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'setupPollTrackerView.fxml'.";
        assert numberOfSeats != null : "fx:id=\"numberOfSeats\" was not injected: check your FXML file 'setupPollTrackerView.fxml'.";
        assert numberOfPolls != null : "fx:id=\"numberOfPolls\" was not injected: check your FXML file 'setupPollTrackerView.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'setupPollTrackerView.fxml'.";
    }  
    
  /**
  * Goal: Override the refresh() method from PollTrackerController Class so that the data displayed is based on the current information 
  * in the polls and factory classes 
  */
	@Override
	public void refresh() {
    	numberOfSeats.clear(); 
    	numberOfPolls.clear();;
	} 									
	
}

