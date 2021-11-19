/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

public class inventoryItem {
    //define private String variable nameItem to store item name
    //define private String variable serialNumber to store item serial number
    //define private String variable monetaryValue to store item monetary value in USD

    public inventoryItem(String name, String value, String serialNumber){
        //constructor sets name, date, serialNumber, and completed boolean status
        //into respective variables
    }

    public void setMonetaryValue(String value){
        //set object's monetaryValue variable to input variable
    }

    public String getMonetaryValue(){
        //return object's monetaryValue variable
        return"";
    }

    public String getNameItem(){
        //return object's nameItem variable
        return"";
    }

    public void setNameItem(String nameItem) {
        //set object's nameItem variable to input variable
    }

    public void setSerialNumber(String serial){
        //set object's serialNumber variable to input variable
    }

    public String getSerialNumber(){
        //return object's serialNumber variable
        return"";
    }

    //override toString method to make this "inventoryItem" item formatted into a readable string to store or display
    @Override
    public String toString(){
        //return string formated as "Item Name: " + item's name + "\nSerial Number: " + item's serial number
        // + "\nMonetary Value: $" + item's monetary value is USD
        return"";
    }
}
