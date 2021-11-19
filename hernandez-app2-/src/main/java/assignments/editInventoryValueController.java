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

public class editInventoryValueController {

    public void initData(String string){
        //is input string is not empty
        if(!string.isEmpty()){
            //set text in text box to text in string
            newValueTextBox.setText(string);
        }
    }

    public String getNewValue(){
        return newValueTextBox.getText();
    }

    @FXML
    private TextArea newValueTextBox;

    @FXML
    private Button saveValueButton;

    @FXML
    void saveValue(ActionEvent event) throws IOException {
        //create an inventory management object named validator to use validation methods
        inventoryManagement validator = new inventoryManagement();

        //if the text in the text box is a valid monetary value
        //close stage
        if(validator.validateValue(newValueTextBox.getText())){
            Stage stage = (Stage) saveValueButton.getScene().getWindow();
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
