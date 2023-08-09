package io.curiositycore.chunkcomber.gui.controller;

import br.com.gamemods.regionmanipulator.RegionIO;

import io.curiositycore.chunkcomber.ChunkComber;
import io.curiositycore.chunkcomber.gui.util.LoadedWorldDataUtil;
import io.curiositycore.chunkcomber.managers.ContainerRegionManager;
import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import io.curiositycore.chunkcomber.model.game.world.data.FileType;
import io.curiositycore.chunkcomber.model.game.world.region.ContainerChunkRegion;
import io.curiositycore.chunkcomber.model.table.ConcreteItemTable;
import io.curiositycore.chunkcomber.util.exceptions.InvalidFileTypeException;
import io.curiositycore.chunkcomber.util.minecraft.MaterialUtil;
import io.curiositycore.chunkcomber.util.minecraft.ScanableTypes;
import io.curiositycore.chunkcomber.util.minecraft.WorldDataUtil;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//TODO break up into utilities if possible
//TODO ensure that the right buttons are disabled when a scan is on-going
//TODO ensure the window is unmodifiable
//TODO Populate the various check boxes
//TODO investigate the possibility of opening a new popup for checkbox options (or something to reduce user-confusion when
//     searching for filters.
//TODO ensure the drag and drop logic for the scan tab list views is done (i.e. when boxes are unchecked, make sure they
//     are deleted from both sides, ensure that the items of a checkbox are added and sorted in alphabetical etc).
/**
 *
 */
public class ComberMainWindow {
    private ContainerRegionManager containerRegionManager = ContainerRegionManager.getInstance();
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
    private Label regionAmount;
    @FXML
    private Label playerAmount;
    @FXML
    private Label fileSize;
    @FXML
    private Label worldSelectedName;
    @FXML
    private ProgressBar progressBar;
    @FXML
    Label scannedFileLabel;
    @FXML
    AnchorPane tablePane;
    @FXML
    Tab tableTab;
    @FXML
    Label scanStatusLabel;
    @FXML
    Button activateTable;
    @FXML
    public void initialize() {
        setDragAndDrop(addableItems,addedItems);
        setDragAndDrop(addedItems,addableItems);
    }
    private void setDragAndDrop(ListView<String> providingListView, ListView<String> recievingListView){

        providingListView.setCellFactory(lv -> {
            ListCell<String> cell = new ListCell<>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setText(null);
                    } else {
                        setText(item);
                    }
                }
            };

            cell.setOnDragDetected(event -> {
                if (!cell.isEmpty()) {
                    Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
                    ClipboardContent cc = new ClipboardContent();
                    cc.putString(cell.getItem());
                    db.setContent(cc);
                    db.setDragView(cell.snapshot(null, null));
                    event.consume();
                }
            });

            return cell;
        });



        recievingListView.setOnDragOver(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        recievingListView.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                recievingListView.getItems().add(db.getString());
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        providingListView.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                System.out.println(providingListView.getSelectionModel().getSelectedIndex());
                providingListView.getItems().remove(providingListView.getSelectionModel().getSelectedIndex());
            }
            event.consume();
        });
    }

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
        ObservableList<String> stringList = FXCollections.observableArrayList(MaterialUtil.getItemNames(ScanableTypes.ORES));
        //ObservableList<String> stringList = FXCollections.observableArrayList("Ores","Containers","Wood","Xp Farm Blocks");
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
    @FXML
    private void scanRegions(){
        registerRegions(this.containerRegionManager.getWorldFile(),getFilterNames());
    }
    @FXML
    private void chooseWorldFile(){
        DirectoryChooser worldChooser = new DirectoryChooser();
        File selectedFile = worldChooser.showDialog(ChunkComber.getMainWindowStage());
        try {
            File worldFile = WorldDataUtil.getWorldFile(selectedFile.getPath());
            LoadedWorldDataUtil.setWorldLabels(worldFile, new Label[]{regionAmount, playerAmount, fileSize, worldSelectedName});
            this.containerRegionManager.setWorldFile(worldFile);
        }
        catch(InvalidFileTypeException invalidFileTypeException){
            invalidFileTypeException.printStackTrace();
        }
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

    private void registerRegions(File worldFile, String[] filterNames){
        TableView<ConcreteItem> itemTable = new ConcreteItemTable();
        showTable(itemTable);
        File[] regionFiles = Arrays.stream(worldFile.listFiles()).
                filter(worldFileDirectory-> worldFileDirectory.
                        getName().
                        contains(FileType.REGION.getFileName())).
                findFirst().
                orElseThrow().
                listFiles();
        double progressIncrements = (double) 1 /regionFiles.length;
        scanStatusLabel.setText("Scan in progress");
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int index = 0 ; index < regionFiles.length; index++) {
                    try {
                        final String statusMessage = "Currently Scanning: "+ regionFiles[index].getName();
                        Platform.runLater(() -> scannedFileLabel.setText(statusMessage));
                        ContainerChunkRegion regionToRegister = new ContainerChunkRegion(RegionIO.readRegion(regionFiles[index]));
                        containerRegionManager.register(regionToRegister);
                        containerRegionManager.scanRegion(regionToRegister.getId());
                        if(!regionToRegister.getChunks().isEmpty()){
                            regionToRegister.getChunks().stream().forEach(baseChunk -> baseChunk.getContainers().forEach(container -> container.setContainerFields()));
                            regionToRegister.getChunks().stream()
                                    .flatMap(baseChunk -> baseChunk.getContainers().stream())
                                    .flatMap(container -> container.getContents().stream())
                                    .forEach(item -> Platform.runLater(() -> {
                                        if(item instanceof ConcreteItem && Arrays.stream(filterNames).anyMatch(filterName-> filterName.equals(item.getName()))){
                                            itemTable.getItems().add((ConcreteItem) item);
                                            itemTable.setItems(itemTable.getItems());
                                        }
                                    }));
                            System.out.println(itemTable.getItems().size());

                        }

                        // Update the status label on the JavaFX Application Thread

                        updateProgress((double) (index+1), regionFiles.length); // Update the task's progress
                    } catch (Exception e) {
                        updateProgress((double) (index+1), regionFiles.length); // Update the task's progress
                    }
                }
                return null;
            }
        };
        progressBar.progressProperty().bind(task.progressProperty()); // Bind the progress bar to the task's progress
        new Thread(task).start(); // Start the task in a new thread
        task.setOnSucceeded(event-> {
            this.scannedFileLabel.setText("");
            this.scanStatusLabel.setText("Scan Complete!");});
        task.setOnFailed(event -> this.scanStatusLabel.setText("Scan Failed!"));



    }

    private void showTable(TableView<ConcreteItem> itemTable){

        System.out.println(itemTable.getColumns().size());

        this.tablePane.getChildren().add(itemTable);
        this.tableTab.setDisable(false);
    }

    private String[] getFilterNames(){
        List<String> filterNameList = new ArrayList<>();
        this.addedItems.getItems().forEach(item-> filterNameList.
                add("minecraft:"+item.
                        toLowerCase().
                        replace(" ","_")
                )
        );
        return filterNameList.toArray(new String[0]);
    }

}
