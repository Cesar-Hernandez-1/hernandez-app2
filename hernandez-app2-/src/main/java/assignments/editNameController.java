/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
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
        //set text in text box to text in string
    }

    public String getDescription(){
        //return text within the text box
        return"";
    }

    @FXML
    private TextArea newDescriptionTextBox;

    @FXML
    private Button saveDescriptionButton;

    @FXML
    void saveDescription(ActionEvent event) throws IOException {
        //if the text in the text box is a greater than or equal to 2 and less than or equal to 256 in legnth
        //close stage

        //else
        //display error scene
    }

}
