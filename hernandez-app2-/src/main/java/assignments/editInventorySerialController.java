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

public class editInventorySerialController {

    public void initData(String string){
        //if received string is not empty
        //set text box to contain the text of the string
    }

    public String getNewSerial(){
        //return the text within the text box
        return"";
    }

    @FXML
    private TextArea newSerialTextBox;

    @FXML
    private Button saveSerialButton;

    @FXML
    void saveSerialNumber(ActionEvent event) throws IOException {
        //create an inventory management object named validator to use validation methods

        //if the text in the text box is a valid serial id
        //close stage

        //else
        //display error scene
    }

}
