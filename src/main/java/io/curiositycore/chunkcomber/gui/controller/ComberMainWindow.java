package io.curiositycore.chunkcomber.gui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;

/**
 *
 */
public class ComberMainWindow {
    @FXML
    private ListView<String> addableItems;

    @FXML
    private ListView<String> addedItems;
    @FXML
    private CheckBox players;
    @FXML
    private CheckBox containers;
    @FXML
    private CheckBox items;
    @FXML
    private CheckBox pets;
    @FXML
    private CheckBox enchantments;
    @FXML
    private CheckBox blocks;

    @FXML
    private void petClickEvent(){
        ObservableList<String> stringList = FXCollections.observableArrayList("Pet1","Pet2","Pet3");
        eventHandler(this.pets,stringList);
    }

    @FXML
    private void itemsClickEvent(){
        ObservableList<String> stringList = FXCollections.observableArrayList("Item1","Item2","Item3");
        eventHandler(this.items,stringList);
    }
    @FXML
    private void enchantClickEvent(){
        ObservableList<String> stringList = FXCollections.observableArrayList("Enchant1","Enchant2","Enchant3");
        eventHandler(this.enchantments,stringList);
    }
    @FXML
    private void blockClickEvent(){
        ObservableList<String> stringList = FXCollections.observableArrayList("Block1","Block2","Block3");
        eventHandler(this.blocks,stringList);
    }
    @FXML
    private void playersClickEvent(){
        ObservableList<String> stringList = FXCollections.observableArrayList("Player1","Player2","Player3");
        eventHandler(this.players,stringList);
    }

    @FXML
    private void containersClickEvent(){
        ObservableList<String> stringList = FXCollections.observableArrayList("Container1","Container2","Container3");
        eventHandler(this.containers,stringList);
    }
    private void eventHandler(CheckBox boxToHandle, ObservableList<String> checkBoxitems){
        if(!boxToHandle.isSelected()){
            remove(checkBoxitems);
            return;
        }
        initialise(checkBoxitems);
    }
    private void initialise(ObservableList<String> itemsToAdd) {
        itemsToAdd.addAll(this.addableItems.getItems());
        addableItems.setItems(itemsToAdd);
    }

    private void remove(ObservableList<String> itemsToRemove){
        addableItems.getItems().removeAll(itemsToRemove);

    }

}
