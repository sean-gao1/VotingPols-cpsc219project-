package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Poll;
import model.PollList;

/*
 * Goal: To assign a name given by the user to a Poll specified by the user. 
*/


public class AddPollController extends PollTrackerController {

// VARIABLES
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private TextField myTextField;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private ChoiceBox<Integer> myChoiceBox;
    
    private int index;
    
    
    private String pollName ;

    
// METHODS 

    /**
     * 	Goal: To create a random poll with a name given by the user and assign 
		it to an index specified by the user in an array of polls 
     */
    void choosing() {
    	Poll add = new Poll(pollName, 0);
    	add = getFactory().createRandomPoll(pollName);
    	PollList myPolls = getPolls(); // fetches the class 
    	Poll[] polls = myPolls.getPolls(); // Accesses models within the class 
    	polls[index] = add;
    }
    
    
    //user's input is assign to pollName
    /**
     * Goal: Collect user's input for Poll Name.
     * @param event
     */
    @FXML
    void keyTyped(KeyEvent event) {
    	pollName = event.getCharacter();
    }
    
    /**
     * Goal: Clear all Text Fields in the tab 
     * @param Actionevent
     */
    //clear the text field
    @FXML
    void ClearButtonReaction(ActionEvent event) {
    	myTextField.clear();
    }
    
    /**
     * Goal: Invoke choosing()
     * @param event
     */
    @FXML
    void addButtonReaction(ActionEvent event) {
    	choosing();
    }

    /**
     * Goal: Initialize all SceneBuilder Nodes that interact with the user.
     * Match the number chosen by the user in the choice box the an index of Poll[].
     */
    @FXML
    void initialize() {
    	/*
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'AddPollView.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'AddPollView.fxml'.";
        assert myChoiceBox != null : "fx:id=\"myChoiceBox\" was not injected: check your FXML file 'AddPollView.fxml'.";
        
        //Match the number chosen by the user in the choice box the an index of Poll[]
        PollList myPolls = getPolls();
    	Poll[] polls = myPolls.getPolls();
        int i = polls.length;
        Integer[] poll = new Integer[i];
		
		for(int e=0; e<i; e++) { 
			poll[e] = e;
		}
		myChoiceBox.setItems(FXCollections.observableArrayList(poll));
		myChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
    		 new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                        int i = newValue.intValue(); 
                        if (i >= 0)  index = poll[i];
                    }
                 }
             );
             */
    }
    

    /**myTextField.clear();
     * Goal: Override the refresh() method from PollTrackerController Class so that the data displayed is based on the current information 
     * in the polls and factory classes 
     */
	@Override
	public void refresh() {
		myTextField.clear();
		assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'AddPollView.fxml'.";
        assert clearButton != null : "fx:id=\"clearButton\" was not injected: check your FXML file 'AddPollView.fxml'.";
        assert myChoiceBox != null : "fx:id=\"myChoiceBox\" was not injected: check your FXML file 'AddPollView.fxml'.";
        
        //Match the number chosen by the user in the choice box the an index of Poll[]
        PollList myPolls = getPolls();
    	Poll[] polls = myPolls.getPolls();
        int i = polls.length;
        Integer[] poll = new Integer[i];
		
		for(int e=0; e<i; e++) { 
			poll[e] = e;
		}
		myChoiceBox.setItems(FXCollections.observableArrayList(poll));
		myChoiceBox.getSelectionModel().selectedIndexProperty().addListener(
    		 new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue observable, Number oldValue, Number newValue) {
                        int i = newValue.intValue(); 
                        if (i >= 0)  index = poll[i];
                    }
                 }
             );
	}

}
