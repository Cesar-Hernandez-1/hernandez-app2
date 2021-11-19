/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

public class inventoryItem {
    //define private String variable nameItem to store item name
    private String nameItem;
    //define private String variable serialNumber to store item serial number
    private String serialNumber;
    //define private String variable monetaryValue to store item monetary value in USD
    private String monetaryValue;

    public inventoryItem(String name, String value, String serialNumber){
        //constructor sets name, date, serialNumber, and completed boolean status
        //into respective variables
        this.nameItem = name;
        this.monetaryValue = value;
        this.serialNumber = serialNumber;
    }

    public void setMonetaryValue(String value){
        this.monetaryValue = value;
    }

    public String getMonetaryValue(){
        return this.monetaryValue;
    }

    public String getNameItem(){
        return this.nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public void setSerialNumber(String serial){
        this.serialNumber = serial;
    }

    public String getSerialNumber(){
        return this.serialNumber;
    }

    //override toString method to make this "inventoryItem" item formatted into a readable string to store or display
    @Override
    public String toString(){
        return "Item Name: " + getNameItem() + "\nSerial Number: " + getSerialNumber() + "\nMonetary Value: $" + getMonetaryValue();
    }
}
