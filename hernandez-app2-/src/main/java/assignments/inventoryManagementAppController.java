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

    //@FXML
    //private ListView<inventoryItem> toDoEventList;

    //create observable list to display data event objects
    //private final listObserve manageList = new listObserve();
    //private final inventoryManagement items = new inventoryManagement();


    @FXML
    void addEvent(ActionEvent event) throws IOException {

    }

    @FXML
    void guideUser(ActionEvent event) throws IOException {

    }

    @FXML
    void deleteAllInventoryItems(ActionEvent event){

    }

    @FXML
    void deleteItem(ActionEvent event) throws IOException {

    }

    @FXML
    void sortValue(ActionEvent event){

    }

    @FXML
    void sortName(ActionEvent event){

    }

    @FXML
    void sortSerialNumber(ActionEvent event){

    }

    void displayAllEvents(ActionEvent event) {

    }

    @FXML
    void editItemName(ActionEvent event) throws IOException { //edit item name

    }

    @FXML
    void editItemSerial(ActionEvent event) throws IOException {   //edit serial

    }

    @FXML
    void loadList(ActionEvent event) throws IOException {

    }

    @FXML
    void editItemValue(ActionEvent event) throws IOException {  //edit item value

    }

    @FXML
    void saveListTSV(ActionEvent event) throws IOException {

    }

    @FXML
    void saveListHTML(ActionEvent event) throws IOException {

    }

    @FXML
    void saveListJSON(ActionEvent event) throws IOException {

    }

    public void searchSerial(ActionEvent event) throws IOException {

    }

    public void searchName(ActionEvent event) throws IOException {

    }

    //private void updateDisplay(List<inventoryItem> update){

    //}
}