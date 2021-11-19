package assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class editInventoryValueController {

    public void initData(String string){
        //is input string is not empty
        //set text in text box to text in string
    }

    public String getNewValue(){
        //return text within the text box
        return"";
    }

    @FXML
    private TextArea newValueTextBox;

    @FXML
    private Button saveValueButton;

    @FXML
    void saveValue(ActionEvent event) throws IOException {
        //create an inventory management object named validator to use validation methods

        //if the text in the text box is a valid monetary value
        //close stage

        //else
        //display error scene
    }

}
