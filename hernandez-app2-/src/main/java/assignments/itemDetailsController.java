package assignments;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class itemDetailsController {

    public void initData(inventoryItem item){
        //set text field 1 to the item name
        nameTextFeild.setText(item.getNameItem());
        //set text field 2 to the item serial number
        serialTextFeild.setText(item.getSerialNumber());
        //set text field 3 to the item monetary value
        valueTextFeild.setText(item.getMonetaryValue());
    }

    @FXML
    private TextField nameTextFeild;

    @FXML
    private TextField serialTextFeild;

    @FXML
    private TextField valueTextFeild;

}
