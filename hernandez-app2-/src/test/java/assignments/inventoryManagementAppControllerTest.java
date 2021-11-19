package assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class inventoryManagementAppControllerTest {

    @Test
    void addEvent() {
        //create "inventoryItem" object
        //set name, serial number, value to inventoryItem object using methods

        //create inventoryManagement object

        //use addItem method to add item

        //assertEquals, if method getItem at index 0 returns the save created "inventoryItem" object, then successful
        //false otherwise
    }

    @Test
    void guideUser() {
        //method does not need to be tested as it only
        //displays a GUI scene that only displays text
        //that shows how the application is used.
    }

    @Test
    void deleteAllInventoryItems() {
        //create inventoryManagement object and populate it with "inventoryItem" objects
        //invoke clearList method on manager object.
        //If inventoryManagement is equal to the freshly created empty manager, then success
        //false otherwise
    }

    @Test
    void deleteItem() {
        //create inventoryManagement object and populate it with "inventoryItem" objects
        //invoke deleteItem method on first item
        //If inventoryManagement is equal to the expected list, then success
        //false otherwise
    }

    @Test
    void sortValue() {
        //create and populate inventory manager object with items
        //sort by value on methods
        //compare list to expected list, true if the same; false otherwise
    }

    @Test
    void sortName() {
        //create and populate inventory manager object with items
        //sort by name on methods
        //compare list to expected list, true if the same; false otherwise
    }

    @Test
    void sortSerialNumber() {
        //create and populate inventory manager object with items
        //sort by serial number on methods
        //compare list to expected list, true if the same; false otherwise
    }

    @Test
    void editItemName() {
        //create and populate inventory manager object with items
        //invoke change item name method on item on position 3 to predetermined name
        //use get name method to compare result to expected string; true if the same, false otherwise
    }

    @Test
    void editItemSerial() {
        //create and populate inventory manager object with items
        //invoke change item serial method on item on position 3 to predetermined serial
        //use get serial method to compare result to expected string; true if the same, false otherwise
    }

    @Test
    void loadList() {
        //tested in save methods
    }

    @Test
    void editItemValue() {
        //create and populate inventory manager object with items
        //invoke change item value method on item on position 3 to predetermined value
        //use get value method to compare result to expected string; true if the same, false otherwise
    }

    @Test
    void saveListTSV() {
        //create and populate inventory manager object with items
        //save to predetermined location
        //load file from location
        //is contents in list are the same from loaded to expected, success
    }

    @Test
    void saveListHTML() {
        //create and populate inventory manager object with items
        //save to predetermined location
        //load file from location
        //is contents in list are the same from loaded to expected, success
    }

    @Test
    void saveListJSON() {
        //create and populate inventory manager object with items
        //save to predetermined location
        //load file from location
        //is contents in list are the same from loaded to expected, success
    }

    @Test
    void searchSerial() {
        //create and populate inventory manager object with items
        //invoke search serial method with determined string to get object
        //compare returned object to expected object; if objects are the same, success
    }

    @Test
    void searchName() {
        //create and populate inventory manager object with items
        //invoke search serial method with determined string to get object
        //compare returned object to expected object; if objects are the same, success
    }
}