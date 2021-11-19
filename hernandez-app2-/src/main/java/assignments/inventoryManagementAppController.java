/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class inventoryManagementAppController {

    @FXML
    private TextField valueText;

    @FXML
    private TextField eventTextButton;

    //create observable list to display data event objects


    @FXML
    void addEvent(ActionEvent event) throws IOException {

        //if no event name is provided, no event to be made and exit method.
        //validate if text boxes have correctly formatted data
        //if not display error

        //display scene to get inventory name
        //create a new item and store it in inventoryManagement object
        //display item onto the observable listview.
    }

    @FXML
    void guideUser(ActionEvent event) throws IOException {

        //when user guide button is pressed
        //open new scene
        //display a fxml screen with only text explaining how all the requirements are implemented in the application
    }

    @FXML
    void deleteAllInventoryItems(ActionEvent event){
        //clear all items from internal inventoryManagement
        //update display
    }

    @FXML
    void deleteItem(ActionEvent event) throws IOException {
        //try
        //use inventoryManagement method to remove an event object from the inventoryManagement
        //use listview method to get index of selected object and method will remove object at the received index

        //catch exception
        //if an exception occurs, then no object in the to do list was selected
        //display a new scene with error message saying no object was selected

        //update listview to display the inventoryManagement with the object removed
    }

    @FXML
    void sortValue(ActionEvent event){
        //invoke sortByValue method on items
        //update display
    }

    @FXML
    void sortName(ActionEvent event){
        //invoke sortByName method on items
        //update display
    }

    @FXML
    void sortSerialNumber(ActionEvent event){
        //invoke sortBySerialNumber method on items
        //update display
    }

    @FXML
    void editItemName(ActionEvent event) throws IOException { //edit item name

        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method

        //if valid index selected
        //open another scene and prompt user to enter a name between 2 and 256 characters.
        //this function will send the current object name to the scene to edit it.
        //if description entered is not in range, display error message.

        //if name is in range, return string name back to this function.
        //use set name method in inventoryManagement to update event at given index with new name

        //update listview to display the new name on the selected item
    }

    @FXML
    void editItemSerial(ActionEvent event) throws IOException {   //edit serial
        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method

        //if valid index selected
        //open scene to get valid serial number

        //if serial number is valid, return string serial number back to this function.
        //use set serial number method in inventoryManagement to update event at given index with new serial number

        //update listview to display the new serial number on the selected item
    }

    @FXML
    void loadList(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select file to get to load list into the current GUI
        //creates a file object with the path of the entered file name
        //Load file using respective load method based on type of file
        //update display
    }

    @FXML
    void editItemValue(ActionEvent event) throws IOException {  //edit item value

        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method

        //if valid index selected
        //open scene to get valid USD value

        //if value is valid, return string value back to this function.
        //use set value method in inventoryManagement to update item at given index with new value

        //update listview to display the new value on the selected item
    }

    @FXML
    void saveListTSV(ActionEvent event) throws IOException {

        //prompt user in another GUI screen to select directory to save file too.
        //Open another GUI screen to ask user to enter desired save file name.
        //convert list into text data and store date in the text file at the desired directory and with the desired name
        //catch exception if there file can not be saved
    }

    @FXML
    void saveListHTML(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        //Open another GUI screen to ask user to enter desired save file name.
        //convert list into text data and store date in the text file at the desired directory and with the desired name
        //catch exception if there file can not be saved

    }

    @FXML
    void saveListJSON(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        //Open another GUI screen to ask user to enter desired save file name.
        //convert list into text data and store date in the text file at the desired directory and with the desired name
        //catch exception if there file can not be saved

    }

    public void searchSerial(ActionEvent event) throws IOException {
        //open scene to ask what serial to look for
        //get valid serial
        //invoke search serial method to get object item that has the same serial
        //open another scene with detailed data on item

    }

    public void searchName(ActionEvent event) throws IOException {
        //open scene to ask what name to look for
        //get valid name
        //invoke search name method to get object item that has the same name
        //open another scene with detailed data on item

    }

    //create class to manage display list
    //private void updateDisplay(List<inventoryItem> update){

    //}
}