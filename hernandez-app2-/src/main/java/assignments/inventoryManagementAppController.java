/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import com.google.gson.Gson;
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
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class inventoryManagementAppController {

    @FXML
    private TextField valueText;

    @FXML
    private TextField eventTextButton;

    @FXML
    private ListView<inventoryItem> toDoEventList;

    //create observable list to display data event objects
    private final listObserve manageList = new listObserve();
    private inventoryManagement items = new inventoryManagement();


    @FXML
    void addEvent(ActionEvent event) throws IOException {

        //if no event name is provided, no event to be made and exit method.
        if(eventTextButton.getText().isEmpty() || valueText.getText().isEmpty()){
            return;
        }
        //validate if text boxes have correctly formatted data
        //if not display error
        if(!items.validateValue(valueText.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("invalidValue.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Value Error");
            stage.setScene(scene);
            stage.show();
            return;
        }else if(!items.validateSerial(eventTextButton.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("invalidSerial.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Serial Number Error");
            stage.setScene(scene);
            stage.show();
            return;
        }else if(!items.uniqueSerial(eventTextButton.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("duplicateSerial.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Duplicate Serial Number Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //display scene to get inventory name
        String returnInventoryName;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editInventoryName.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Add Inventory Name");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            editNameController controller = loader.getController();
            returnInventoryName = controller.getDescription();
        }while(!(returnInventoryName.length() >= 2 && returnInventoryName.length() <= 256));
        //try to
        try{
            //create a new event and store it in inventoryManagement object
            items.addItem(new inventoryItem(returnInventoryName, valueText.getText(), eventTextButton.getText()));

            //display item onto the observable listview.
            manageList.addEvent(new inventoryItem(returnInventoryName, valueText.getText(), eventTextButton.getText()));
            toDoEventList.setItems(manageList.getList());
        }catch (Exception e){
            //catch exception and print error screen
            return;
        }
    }

    @FXML
    void guideUser(ActionEvent event) throws IOException {

        //when user guide button is pressed
        //open new scene
        //display a fxml screen with only text explaining how all the requirements are implemented in the application
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("guideUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("User Guide");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteAllInventoryItems(ActionEvent event){
        //clear all items from internal inventoryManagement
        items.clearList();
        //update display
        updateDisplay(items.getList());
    }

    @FXML
    void deleteItem(ActionEvent event) throws IOException {
        //try
        //use inventoryManagement method to remove an event object from the inventoryManagement
        //use listview method to get index of selected object and method will remove object at the received index
        try{
            items.deleteItem(toDoEventList.getSelectionModel().getSelectedIndex());
        }
        //catch exception
        catch (Exception e){
        //if an exception occurs, then no object in the to do list was selected
        //display a new scene with error message saying no object was selected
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }
        //update listview to display the inventoryManagement with the object removed
        updateDisplay(items.getList());
    }

    @FXML
    void sortValue(ActionEvent event){
        //invoke sortByValue method on items
        items.sortByValue();
        //update display
        updateDisplay(items.getList());
    }

    @FXML
    void sortName(ActionEvent event){
        //invoke sortByName method on items
        items.sortByName();
        //update display
        updateDisplay(items.getList());
    }

    @FXML
    void sortSerialNumber(ActionEvent event){
        //invoke sortBySerialNumber method on items
        items.sortBySerialNumber();
        //update display
        updateDisplay(items.getList());
    }

    @FXML
    void editItemName(ActionEvent event) throws IOException { //edit item name

        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        int index;
        if((index = toDoEventList.getSelectionModel().getSelectedIndex()) < 0){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //if valid index selected
        //open another scene and prompt user to enter a name between 2 and 256 characters.
        //this function will send the current object name to the scene to edit it.
        //if description entered is not in range, display error message.
        String returnInventoryName;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editInventoryName.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        editNameController controller = loader.getController();
        controller.initData(toDoEventList.getSelectionModel().getSelectedItem().getNameItem());

        Stage stage = new Stage();
        stage.setTitle("Edit Name");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            returnInventoryName = controller.getDescription();
        }while(!(returnInventoryName.length() >= 1 && returnInventoryName.length() <= 256));

        //if name is in range, return string name back to this function.
        //use set name method in inventoryManagement to update event at given index with new name
        items.changeName(index, returnInventoryName);

        //update listview to display the new name on the selected item
        updateDisplay(items.getList());
    }

    @FXML
    void editItemSerial(ActionEvent event) throws IOException {   //edit serial
        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        int index;
        if((index = toDoEventList.getSelectionModel().getSelectedIndex()) < 0){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //if valid index selected
        //open scene to get valid serial number
        String returnInventorySerial;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editInventorySerial.fxml")); //change
        Parent root = loader.load();
        Scene scene = new Scene(root);

        editInventorySerialController controller = loader.getController();
        controller.initData(toDoEventList.getSelectionModel().getSelectedItem().getSerialNumber()); // create initData method and reword controller class

        Stage stage = new Stage();
        stage.setTitle("Edit Serial");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            returnInventorySerial = controller.getNewSerial();
        }while(!items.validateSerial(returnInventorySerial));

        //if serial number is valid, return string serial number back to this function.
        //use set serial number method in inventoryManagement to update event at given index with new serial number
        items.changeSerialNumber(index, returnInventorySerial);

        //update listview to display the new serial number on the selected item
        updateDisplay(items.getList());
    }

    @FXML
    void loadList(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select file to get to load list into the current GUI
        //creates a file object with the path of the entered file name
        try{
            final FileChooser fileChooser = new FileChooser();
            Stage stage = new Stage();
            File file = fileChooser.showOpenDialog(stage);

            StringBuilder fileName = new StringBuilder();

            for(int i = 4; i > 0; i--){
                fileName.append(file.toString().charAt(file.toString().length() - i));
            }

            //Load file and read stored text format to create list object
            switch (fileName.toString()) {
                case ".txt" -> items.loadListTSV(file);
                case "html" -> items.loadListHTML(file);
                case "json" -> {
                    items = items.loadListJSON(file.toString());
                }
                default -> {
                    return;
                }
            }

            //replace current observable list in listview with the loaded inventoryManagement
            updateDisplay(items.getList());
        }
        //if file doesn't exist, display error message and end class method
        catch (Exception e){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotLoadedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error Loading File");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void editItemValue(ActionEvent event) throws IOException {  //edit item value

        //use listview method getSelectedModel and getSelectedIndex to get currently selected index
        //if index is below 0, then nothing is selected and display an error scene
        //exit method
        int index;
        if((index = toDoEventList.getSelectionModel().getSelectedIndex()) < 0){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NoItemSelectedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("No Item Selected Error");
            stage.setScene(scene);
            stage.show();
            return;
        }

        //if valid index selected
        //open scene to get valid USD value
        String returnInventoryValue;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editInventoryValue.fxml")); //change
        Parent root = loader.load();
        Scene scene = new Scene(root);

        editInventoryValueController controller = loader.getController();
        controller.initData(toDoEventList.getSelectionModel().getSelectedItem().getMonetaryValue()); // create initData method and reword controller class

        Stage stage = new Stage();
        stage.setTitle("Edit Value");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            returnInventoryValue = controller.getNewValue();
        }while(!items.validateValue(returnInventoryValue));

        //if value is valid, return string value back to this function.
        //use set value method in inventoryManagement to update item at given index with new value
        items.changeValue(index, returnInventoryValue);

        //update listview to display the new value on the selected item
        updateDisplay(items.getList());
    }

    @FXML
    void saveListTSV(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        try{
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = new Stage();
            File file = directoryChooser.showDialog(stage);

            //Open another GUI screen to ask user to enter desired save file name.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("nameSaveFile.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            nameSaveFileController controller = loader.getController();
            stage = new Stage();
            stage.setTitle("Name Save File");
            stage.setScene(scene);
            stage.showAndWait();
            String fileName = file.getAbsolutePath() + "\\" + controller.getName() + ".txt";

            //convert list into text data and store date in the text file at the desired directory and with the desired name
            items.saveListTSV(fileName);
        }//catch exception if there file can not be loaded
        catch (Exception e){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotSavedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error Saving File");
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void saveListHTML(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        try {
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = new Stage();
            File file = directoryChooser.showDialog(stage);
            //Open another GUI screen to ask user to enter desired save file name.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("nameSaveFile.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            nameSaveFileController controller = loader.getController();
            stage = new Stage();
            stage.setTitle("Name Save File");
            stage.setScene(scene);
            stage.showAndWait();
            String fileName = file.getAbsolutePath() + "\\" + controller.getName() + ".html";
            //convert list into text data and store date in the text file at the desired directory and with the desired name
            items.saveListHTML(fileName);
        }//catch exception if there file can not be saved
        catch (Exception e){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotSavedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error Saving File");
            stage.setScene(scene);
            stage.show();
        }

    }

    @FXML
    void saveListJSON(ActionEvent event) throws IOException {
        //prompt user in another GUI screen to select directory to save file too.
        try {
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            Stage stage = new Stage();
            File file = directoryChooser.showDialog(stage);

            //Open another GUI screen to ask user to enter desired save file name.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("nameSaveFile.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            nameSaveFileController controller = loader.getController();
            stage = new Stage();
            stage.setTitle("Name Save File");
            stage.setScene(scene);
            stage.showAndWait();
            String fileName = file.getAbsolutePath() + "\\" + controller.getName();

            //convert list into text data and store date in the text file at the desired directory and with the desired name
            items.saveListJSON(items, fileName);

        }//catch exception if there file can not be saved
        catch (Exception e){
            Parent root =
                    FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNotSavedError.fxml")));

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Error Saving File");
            stage.setScene(scene);
            stage.show();
        }

    }

    public void searchSerial(ActionEvent event) throws IOException {
        //open scene to ask what serial to look for
        String searchSerial;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editInventorySerial.fxml")); //change
        Parent root = loader.load();
        Scene scene = new Scene(root);

        editInventorySerialController controller = loader.getController();

        Stage stage = new Stage();
        stage.setTitle("Search By Serial");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            searchSerial = controller.getNewSerial();
        }while(!items.validateSerial(searchSerial));
        //get valid serial
        //invoke search serial method to get object item that has the same serial
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("itemDetails.fxml")); //change
        root = loader.load();
        scene = new Scene(root);

        itemDetailsController controller2 = loader.getController();
        if(items.getBySerial(searchSerial) == null){
            //error screen
            return;
        }
        //open another scene with detailed data on item
        controller2.initData(items.getBySerial(searchSerial));
        stage = new Stage();
        stage.setTitle("Item Details");
        stage.setScene(scene);
        stage.show();

    }

    public void searchName(ActionEvent event) throws IOException {
        //open scene to ask what name to look for
        String searchName;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("editInventoryName.fxml")); //change
        Parent root = loader.load();
        Scene scene = new Scene(root);

        editNameController controller = loader.getController();

        Stage stage = new Stage();
        stage.setTitle("Search By Name");
        stage.setScene(scene);
        do {
            stage.showAndWait();
            searchName = controller.getDescription();
        }while(!(searchName.length() >= 2 && searchName.length() <= 256));
        //get valid name
        //invoke search name method to get object item that has the same name
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("itemDetails.fxml")); //change
        root = loader.load();
        scene = new Scene(root);

        itemDetailsController controller2 = loader.getController();
        if(items.getByName(searchName) == null){
            //error screen
            return;
        }
        //open another scene with detailed data on item
        controller2.initData(items.getByName(searchName));
        stage = new Stage();
        stage.setTitle("Item Details");
        stage.setScene(scene);
        stage.show();

    }

    //create class to manage display list
    private void updateDisplay(List<inventoryItem> update){
        //update listview to display the new date on the selected event
        manageList.removeEventIndexes(0, manageList.getSize());

        manageList.addAllEvents(update);
        toDoEventList.setItems(manageList.getList());
    }
}

class listObserve{
    private final ObservableList<inventoryItem> list;

    listObserve(){
        list = FXCollections.observableArrayList();
    }

    public void addEvent(inventoryItem item){
        list.add(item);
    }

    public void removeEventIndexes(int start, int end){
        list.remove(start, end);
    }

    public void addAllEvents(List<inventoryItem> items){
        list.addAll(items);
    }

    public int getSize(){
        return list.size();
    }

    public ObservableList<inventoryItem> getList(){
        return list;
    }
}