/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Cesar Hernandez
 */

package assignments;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class inventoryManagement {
    //create ArrayList object to store "inventoryItem" inside
    private ArrayList<inventoryItem> itemList;

    public inventoryManagement(){
        //initialize the ArrayList variable with a new ArrayList
        itemList = new ArrayList<>();
    }

    public void addItem(inventoryItem listEvent){
        //add an "inventoryItem" object into the inventoryManagement ArrayList
        itemList.add(listEvent);
    }

    public inventoryItem getItem(int index){
        //return "inventoryItem" object in list at given index
        return itemList.get(index);
    }
    public void deleteItem(int event){
        //remove the "inventoryItem" object at the received index
        itemList.remove(event);
    }

    public void clearList(){
        //delete every element in the itemList by using ArrayList method clear
        itemList.clear();
        //create a fresh itemList
        itemList = new ArrayList<>();
    }

    public void changeSerialNumber(int index, String description){
        //use "inventoryItem" object at received index method setSerialNumber to change description to received one
        itemList.get(index).setSerialNumber(description);
    }

    public void changeValue(int index, String date){
        //use "inventoryItem" object at received index method setMonetaryValue to change due date to received one
        itemList.get(index).setMonetaryValue(date);
    }

    public void changeName(int index, String name){
        //use "inventoryItem" object at received index method setMonetaryValue to change due date to received one
        itemList.get(index).setNameItem(name);
    }

    public boolean validateValue(String value){
        //try to return the truth value of parse double of input value variable greater than 0 AND the value matches the
            //regular expression of "[0-9]+.[0-9]{2}"
        try{
            return Double.parseDouble(value) > 0 && value.matches("[0-9]+.[0-9]{2}");
        }
        //catch exception and return false
        catch (Exception e){
            return false;
        }
    }

    public inventoryItem getBySerial(String serial){
        //for each inventoryItem is the itemList
        //if the serial number equals the input serial variable, return true
        for(inventoryItem item : itemList){
            if(Objects.equals(item.getSerialNumber(), serial)){
                return item;
            }
        }
        //return null otherwise
        return null;
    }

    public inventoryItem getByName(String name){
        //for each inventoryItem is the itemList
        //if the item name equals the input name variable, return true
        for(inventoryItem item : itemList){
            if(Objects.equals(item.getNameItem(), name)){
                return item;
            }
        }
        //return null otherwise
        return null;
    }

    public boolean uniqueSerial(String serial){
        //for each inventoryItem in the itemList
        //if any serial number from the items match the input serial variable, return false
        for(inventoryItem item : itemList){
            if(Objects.equals(serial, item.getSerialNumber())){
                return false;
            }
        }
        //return true otherwise
        return true;
    }

    public boolean validateSerial(String serial){
        //if first character is not an alphabet, the chars in positions 1,5, and 9 are not -,
        //the chars in positions 2-4, 6-8, and 10-12 are not numbers or letters, return false
        if(!Character.isAlphabetic(serial.charAt(0)) || serial.charAt(1) != '-' && serial.charAt(5) != '-' && serial.charAt(9) != '-'){
            return false;
        }

        for(int i = 2; i < 5; i++){
            if(!Character.isDigit(serial.charAt(i)) && !Character.isAlphabetic(serial.charAt(i))){
                return false;
            }
        }
        for(int i = 6; i < 9; i++){
            if(!Character.isDigit(serial.charAt(i)) && !Character.isAlphabetic(serial.charAt(i))){
                return false;
            }
        }
        for(int i = 10; i < 13; i++){
            if(!Character.isDigit(serial.charAt(i)) && !Character.isAlphabetic(serial.charAt(i))){
                return false;
            }
        }
        //return true otherwise
        return true;
    }

    public List<inventoryItem> getList(){
        //return the ArrayList of "inventoryItem"
        return itemList;
    }

    public void sortByValue(){
        //traverse list and sort by monetary value
        for(int i = 0; i < itemList.size(); i++){
            for(int j = 0; j < itemList.size() - 1; j++){
                if (Double.parseDouble(itemList.get(j).getMonetaryValue()) < Double.parseDouble(itemList.get(j+1).getMonetaryValue())){
                    //swap values using Collections.swap()
                    Collections.swap(itemList, j, j + 1);
                }
            }
        }
    }

    public void sortByName(){
        //traverse list and sort by name
        for(int i = 0; i < itemList.size(); i++){
            for(int j = 0; j < itemList.size() - 1; j++){
                if (itemList.get(j).getNameItem().compareTo(itemList.get(j+1).getNameItem()) > 0){
                    //swap values using Collections.swap()
                    Collections.swap(itemList, j, j + 1);
                }
            }
        }
    }

    public void sortBySerialNumber(){
        //traverse list and sort by serial number
        for(int i = 0; i < itemList.size(); i++){
            for(int j = 0; j < itemList.size() - 1; j++){
                if (itemList.get(j).getSerialNumber().compareTo(itemList.get(j+1).getSerialNumber()) > 0){
                    //swap values using Collections.swap()
                    Collections.swap(itemList, j, j + 1);
                }
            }
        }
    }

    public void saveListTSV(String saveFile) throws IOException{
        int size = 0;
        for(inventoryItem item : itemList){
            if(item.getNameItem().length() > size){
                size = item.getNameItem().length();
            }
        }

        //try to open a new text file at specified directory path received
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))){
            //String builder to convert list and items to text
            StringBuilder saveOutput = new StringBuilder();
            int space = size - 4;

            saveOutput.append("Serial Number" + "\t" + "Name").append(" ".repeat(Math.max(0, space))).append("\t").append("Value\n");

            //convert all items to text
            for(inventoryItem item : itemList){
                saveOutput.append(item.getSerialNumber()).append("\t").append(item.getNameItem());

                if(item.getNameItem().length() < size){
                    saveOutput.append("\t\t");
                }else{
                    saveOutput.append("\t");
                }
                saveOutput.append(item.getMonetaryValue()).append("\n");
            }
            //write text to text file
            writer.write(saveOutput.toString());
        }
    }

    public void saveListJSON(inventoryManagement manager, String saveFile) throws IOException{
        //define a Gson object named gson and set it to a new gson()
        Gson gson = new Gson();

        Writer writer = Files.newBufferedWriter(Path.of(saveFile + ".json"));
        //use gson method "toJson" to write the itemList to a json file to the saveFile location
        gson.toJson(manager, writer);
        writer.close();
    }

    public inventoryManagement loadListJSON(String loadFile) throws IOException{
        //define a Gson object named gson and set it to a new gson()
        Gson gson = new Gson();

        Reader reader = Files.newBufferedReader(Paths.get(loadFile));
        //set itemList to the value returned from "fromJson" from the file defined from the incoming variable
        return gson.fromJson(reader, inventoryManagement.class);
    }

    public void loadListHTML(File file) throws FileNotFoundException {

        //try to open file argument
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {

            //parse the html life to get data
            String end = "  </tr>";
            String line;

            for(int i = 0; i < 13; i++){
                reader.readLine();
            }

            //construct an itemList from data
            //get every line and construct an "inventoryItem" object on received data
            ArrayList<String> names = new ArrayList<>();
            while(!Objects.equals(line = reader.readLine(), end)){
                //"    <th>"
                StringBuilder name = new StringBuilder();
                for(int i = 8; i < line.length() - 5; i++){
                    name.append(line.charAt(i));
                }
                names.add(name.toString());
            }

            reader.readLine();

            ArrayList<String> serial = new ArrayList<>();
            while(!Objects.equals(line = reader.readLine(), end)){
                StringBuilder serialNum = new StringBuilder();
                for(int i = 8; i < line.length() - 5; i++){
                    serialNum.append(line.charAt(i));
                }
                serial.add(serialNum.toString());
            }

            reader.readLine();

            ArrayList<String> value = new ArrayList<>();
            while(!Objects.equals(line = reader.readLine(), end)){
                StringBuilder val = new StringBuilder();
                for(int i = 8; i < line.length() - 5; i++){
                    val.append(line.charAt(i));
                }
                value.add(val.toString());
            }

            //set this itemList to the newly constructed one
            itemList.clear();
            ArrayList<inventoryItem> newList = new ArrayList<>();
            for(int i = 0; i < names.size(); i++){
                newList.add(new inventoryItem(names.get(i), value.get(i), serial.get(i)));
            }
            itemList = newList;

        }//catch an error and display error screen
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveListHTML(String saveFile) throws IOException{

        //create string builder variable to construct html table
        StringBuilder output = new StringBuilder("""
                <!DOCTYPE html>
                <html>
                <style>
                table, th, td {
                  border:1px solid black;
                }
                </style>
                <body>

                <h2>Inventory</h2>

                <table style="width:100%">
                  <tr>
                """);

        //traverse item list and put each item within the table in a html format
        for(inventoryItem item : itemList){
            output.append("    <th>").append(item.getNameItem()).append("</th>\n");
        }

        output.append("""
                  </tr>
                  <tr>
                """);

        for(inventoryItem item : itemList){
            output.append("    <td>").append(item.getSerialNumber()).append("</td>\n");
        }

        output.append("""
                  </tr>
                  <tr>
                """);

        for(inventoryItem item : itemList){
            output.append("    <td>").append(item.getMonetaryValue()).append("</td>\n");
        }

        output.append("""
                  </tr>
                </table>
                </body>
                </html>""");

        //try to open file ar argument location and write to the file the string builder html string
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))){
            writer.write(output.toString());
        }
    }

    public void loadListTSV(File loadFile) throws IOException{

        //try to open file specified in received File Chooser
        try(BufferedReader reader = new BufferedReader(new FileReader(loadFile))) {

            //make new inventory manager to populate
            String line;
            ArrayList<inventoryItem> itemManager = new ArrayList<>();
            reader.readLine();

            //get every line and construct an "inventoryItem" object on received data
            while((line = reader.readLine()) != null){
                String[] words = line.replace("\t\t","\t").split("\t");
                //add "inventoryItem" object into the todolist
                itemManager.add(new inventoryItem(words[1], words[2], words[0]));
            }

            //clear current itemList and add make the new list the current list
            itemList.clear();
            itemList = itemManager;
        }
    }
}
