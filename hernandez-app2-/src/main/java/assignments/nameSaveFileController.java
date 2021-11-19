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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class nameSaveFileController {

    public String getName(){
        return nameTextBox.getText();
    }

    @FXML
    private TextField nameTextBox;

    @FXML
    private Button saveButton;

    @FXML
    void saveAndClose(ActionEvent event) throws IOException {
        //if the length of the text in the text box is equal to or greater than 1
        //close the stage
        if(nameTextBox.getText().length() >= 1){
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }
        //else
        //display error scene that there is a file save error
        else{
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotSavedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("File Save Error");
            stage.setScene(scene);
            stage.show();
        }
    }
}
