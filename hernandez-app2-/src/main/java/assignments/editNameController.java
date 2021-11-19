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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class editNameController {

    public void initData(String string){
        //is input string is not empty
        if(!string.isEmpty()){
            //set text in text box to text in string
            newDescriptionTextBox.setText(string);
        }
    }

    public String getDescription(){
        return newDescriptionTextBox.getText();
    }

    @FXML
    private TextArea newDescriptionTextBox;

    @FXML
    private Button saveDescriptionButton;

    @FXML
    void saveDescription(ActionEvent event) throws IOException {
        //if the text in the text box is a greater than or equal to 2 and less than or equal to 256 in legnth
        //close stage
        if(newDescriptionTextBox.getText().length() >= 2 && newDescriptionTextBox.getText().length() <= 256){
            Stage stage = (Stage) saveDescriptionButton.getScene().getWindow();
            stage.close();
        }
        //else
        //display error scene
        else{
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("nameError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Inventory Name Length Error");
            stage.setScene(scene);
            stage.show();
        }
    }

}
