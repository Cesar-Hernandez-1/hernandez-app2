package assignments;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class inventoryManagementAppControllerTest {

    @Test
    void addEvent() {
        //create "inventoryItem" object
        //set name, serial number, value to inventoryItem object using methods
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");

        //create inventoryManagement object
        inventoryManagement manager = new inventoryManagement();

        //use addItem method to add item
        manager.addItem(item);

        //assertEquals, if method getItem at index 0 returns the save created "inventoryItem" object, then successful
        //false otherwise
        assertEquals(item, manager.getItem(0));
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
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        manager.addItem(item);
        //invoke clearList method on manager object.
        manager.clearList();
        //If inventoryManagement is equal to the freshly created empty manager, then success
        //false otherwise
        assertEquals(new inventoryManagement().getList(), manager.getList());
    }

    @Test
    void deleteItem() {
        //create inventoryManagement object and populate it with "inventoryItem" objects
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        manager.addItem(item);
        manager.addItem(item2);

        inventoryManagement expected = new inventoryManagement();
        expected.addItem(item2);
        //invoke deleteItem method on first item
        manager.deleteItem(0);
        //If inventoryManagement is equal to the expected list, then success
        //false otherwise
        assertEquals(expected.getList(), manager.getList());
    }

    @Test
    void sortValue() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);

        inventoryManagement expected = new inventoryManagement();
        expected.addItem(item3);
        expected.addItem(item2);
        expected.addItem(item);

        //sort by value on methods
        manager.sortByValue();
        //compare list to expected list, true if the same; false otherwise
        assertEquals(expected.getList(), manager.getList());
    }

    @Test
    void sortName() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item3);
        manager.addItem(item);
        manager.addItem(item2);

        inventoryManagement expected = new inventoryManagement();
        expected.addItem(item);
        expected.addItem(item2);
        expected.addItem(item3);
        //sort by name on methods
        manager.sortByName();
        //compare list to expected list, true if the same; false otherwise
        assertEquals(expected.getList(), manager.getList());
    }

    @Test
    void sortSerialNumber() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);

        inventoryManagement expected = new inventoryManagement();
        expected.addItem(item3);
        expected.addItem(item2);
        expected.addItem(item);
        //sort by serial number on methods
        manager.sortBySerialNumber();
        //compare list to expected list, true if the same; false otherwise
        assertEquals(expected.getList(), manager.getList());
    }

    @Test
    void editItemName() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);
        //invoke change item name method on item on position 1 to predetermined name
        manager.changeName(1, "Changed");
        //use get name method to compare result to expected string; true if the same, false otherwise
        assertEquals("Changed", manager.getItem(1).getNameItem());
    }

    @Test
    void editItemSerial() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);
        //invoke change item serial method on item on position 1 to predetermined serial
        manager.changeSerialNumber(1,"A-111-111-111");
        //use get serial method to compare result to expected string; true if the same, false otherwise
        assertEquals("A-111-111-111", manager.getItem(1).getSerialNumber());
    }

    @Test
    void loadList() {
        //tested in save methods
    }

    @Test
    void editItemValue() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);
        //invoke change item value method on item on position 1 to predetermined value
        manager.changeValue(1, "0.01");
        //use get value method to compare result to expected string; true if the same, false otherwise
        assertEquals("0.01", manager.getItem(1).getMonetaryValue());
    }

    @Test
    void saveListTSV() throws IOException {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);

        inventoryManagement expected = manager;
        //save to predetermined location
        manager.saveListTSV("C:\\Users\\cesar\\Desktop\\hernandez-app2\\hernandez-app2-\\docs\\saveTest");
        //clear current list
        manager.clearList();

        //load file from location to cleared manager to prove load works
        File file = new File("C:\\Users\\cesar\\Desktop\\hernandez-app2\\hernandez-app2-\\docs\\saveTest");
        manager.loadListTSV(file);
        //is contents in list are the same from loaded to expected, success
        assertEquals(expected, manager);
    }

    @Test
    void saveListHTML() throws IOException {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);

        inventoryManagement expected = manager;

        //save to predetermined location
        manager.saveListHTML("C:\\Users\\cesar\\Desktop\\hernandez-app2\\hernandez-app2-\\docs\\saveTest2");

        //clear manager to prove load works
        manager.clearList();

        //load file from location
        File file = new File("C:\\Users\\cesar\\Desktop\\hernandez-app2\\hernandez-app2-\\docs\\saveTest2");
        manager.loadListHTML(file);

        //is contents in list are the same from loaded to expected, success
        assertEquals(expected, manager);
    }

    @Test
    void saveListJSON() throws IOException {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);

        inventoryManagement expected = manager;

        //save to predetermined location
        manager.saveListJSON("C:\\Users\\cesar\\Desktop\\hernandez-app2\\hernandez-app2-\\docs\\saveTest3");

        //clear manager to prove load works
        manager.clearList();

        //load file from location
        manager.loadListJSON("C:\\Users\\cesar\\Desktop\\hernandez-app2\\hernandez-app2-\\docs\\saveTest3");

        //is contents in list are the same from loaded to expected, success
        assertEquals(expected, manager);
    }

    @Test
    void searchSerial() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);
        //invoke search serial method with determined string to get object
        inventoryItem actual = manager.getBySerial("A-999-999-998");
        //compare returned object to expected object; if objects are the same, success
        assertEquals(item2, actual);
    }

    @Test
    void searchName() {
        //create and populate inventory manager object with items
        inventoryManagement manager = new inventoryManagement();
        inventoryItem item = new inventoryItem("Test","20.00","A-999-999-999");
        inventoryItem item2 = new inventoryItem("Test2","20.10","A-999-999-998");
        inventoryItem item3 = new inventoryItem("Test3","99.10","A-999-999-997");
        manager.addItem(item);
        manager.addItem(item2);
        manager.addItem(item3);
        //invoke search serial method with determined string to get object
        inventoryItem actual = manager.getByName("Test2");
        //compare returned object to expected object; if objects are the same, success
        assertEquals(item2, actual);
    }
}