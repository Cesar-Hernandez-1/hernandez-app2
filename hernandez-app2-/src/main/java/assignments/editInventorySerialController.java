/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cesar Hernandez
 */

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
        if(!string.isEmpty()){
            //set text box to contain the text of the string
            newSerialTextBox.setText(string);
        }
    }

    public String getNewSerial(){
        return newSerialTextBox.getText();
    }

    @FXML
    private TextArea newSerialTextBox;

    @FXML
    private Button saveSerialButton;

    @FXML
    void saveSerialNumber(ActionEvent event) throws IOException {
        //create an inventory management object named validator to use validation methods
        inventoryManagement validator = new inventoryManagement();

        //if the text in the text box is a valid serial id
        //close stage
        if(validator.validateSerial(newSerialTextBox.getText())){
            Stage stage = (Stage) saveSerialButton.getScene().getWindow();
            stage.close();
        }
        //else
        //display error scene
        else{
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("nameError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Serial Number Error");
            stage.setScene(scene);
            stage.show();
        }
    }

}
