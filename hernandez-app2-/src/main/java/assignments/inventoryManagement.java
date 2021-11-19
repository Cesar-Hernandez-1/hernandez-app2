/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class inventoryManagement {
    //create ArrayList object to store "inventoryItem" inside

    public inventoryManagement(){
        //initialize the ArrayList variable with a new ArrayList
    }

    public void addItem(inventoryItem listEvent){
        //add an "inventoryItem" object into the inventoryManagement ArrayList
    }

    public inventoryItem getItem(int index){
        //return "inventoryItem" object in list at given index
        return null;
    }
    public void deleteItem(int event){
        //remove the "inventoryItem" object at the received index
    }

    public void clearList(){
        //delete every element in the itemList by using ArrayList method clear
        //create a fresh itemList
    }

    public void changeSerialNumber(int index, String description){
        //use "inventoryItem" object at received index method setSerialNumber to change description to received one
    }

    public void changeValue(int index, String date){
        //use "inventoryItem" object at received index method setMonetaryValue to change due date to received one
    }

    public void changeName(int index, String name){
        //use "inventoryItem" object at received index method setMonetaryValue to change due date to received one
    }

    public boolean validateValue(String value){
        //try to return the truth value of parce double of input value variable greater than 0 AND the value matches the
            //regular expression of "[0-9]+.[0-9]{2}"
        //catch exception and return false
        return true;
    }

    public inventoryItem getBySerial(String serial){
        //for each inventoryItem is the itemList
        //if the serial number equals the input serial variable, return true
        //return null otherwise
        return null;
    }

    public inventoryItem getByName(String name){
        //for each inventoryItem is the itemList
        //if the item name equals the input name variable, return true
        //return null otherwise
        return null;
    }

    public boolean uniqueSerial(String serial){
        //for each inventoryItem in the itemList
        //if any serial number from the items match the input serial variable, return false
        //return true otherwise
        return true;
    }

    public boolean validateSerial(String serial){
        //if first character is not an alphabet, the chars in positions 1,5, and 9 are not -,
        //the chars in positions 2-4, 6-8, and 10-12 are not numbers or letters, return false
        //return true otherwise
        return true;
    }

    public List<inventoryItem> getList(){
        //return the ArrayList of "inventoryItem"
        return null;
    }

    public void sortByValue(){
        //traverse list and sort by monetary value
        //swap values using Collections.swap()
    }

    public void sortByName(){
        //traverse list and sort by name
        //swap values using Collections.swap()
    }

    public void sortBySerialNumber(){
        //traverse list and sort by serial number
        //swap values using Collections.swap()
    }

    public void saveListTSV(String saveFile) throws IOException{

        //try to open a new text file at specified directory path received
            //String builder to convert list and items to text and tabs
            //write text to text file
    }

    public void saveListJSON(String saveFile) throws IOException{
        //define a Gson object named gson and set it to a new gson()
        //use gson method "toJson" to write the itemList to a json file to the saveFile location
    }

    public void loadListJSON(String loadFile) throws IOException{
        //define a Gson object named gson and set it to a new gson()
        //set itemList to the value returned from "fromJson" from the file defined from the incoming variable
    }

    public void loadListHTML(File file) throws FileNotFoundException {
        //try to open file argument
        //parse the html life to get data
        //construct an itemList from data
        //set this itemList to the newly constructed one
    }

    public void saveListHTML(String saveFile) throws IOException{
        //create string builder variable to construct html table
        //traverse item list and put each item within the table in a html format
        //try to open file ar argument location and write to the file the string builder html string
    }

    public void loadListTSV(File loadFile) throws IOException{

        //try to open file specified in received File Chooser

            //make new todolist to populate
            //get every line and construct an "inventoryItem" object on received data
            //clear current todolist and add make the new list the current list
    }
}
