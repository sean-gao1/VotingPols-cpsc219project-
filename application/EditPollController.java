package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Poll;
import model.PollList;
import model.Party;
import model.Factory;
//import model.TextApplication;




public class EditPollController extends PollTrackerController{

	//**THE GOAL OF EDITPOLL IS TO ALLOW USER TO EDIT INFORMATION IN THE POLLS BY UPDATING THE  EXPECTED NUMBER OF SEATS//
	// AS WELL AS THE EXPECTED PERCENTAGE OF OF THE VOTES FOR ANY PARTY//
	
	//VARIABLES//
	@FXML 
    private ResourceBundle resources;
	
	@FXML
	private URL location;
	
	@FXML
	private TextField PolltoEdit;
	
	@FXML
	private TextField Partytoupdate;
	
	
	@FXML
	private ChoiceBox<String> ChoiceBox1;
	
	@FXML
	private ChoiceBox<String> ChoiceBox2;
	
	@FXML
	private Button clearButton;
	 
	@FXML
	private Button UpdateParty;
	
	
	//METHOD 
	
		//**TO CREATE A METHOD THAT ALLOWS USER TO EDIT INFORMATION REGARDING THE ELECTION
	
	
	

	
	
	
	
	
	public void refresh() {
		
	}
	
	
}
