package io.curiositycore.chunkcomber.model.table;

import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import io.curiositycore.chunkcomber.model.game.items.Item;

import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.List;


public abstract class ItemTable<T extends Item> extends TableView<T> {
    protected ItemTable(){
        this.getColumns().addAll(initColumns());
    }

    protected abstract List<TableColumn<T, ?>> initColumns();
    protected<S> TableColumn<T,S> constructColumn(String columnName,String fieldName){
        TableColumn<T,S> tableColumn = new TableColumn<>(columnName);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(fieldName));

        tableColumn.setCellFactory(tc -> new TableCell<>() {
            @Override
            protected void updateItem(S item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(String.valueOf(item)); // Convert Integer to String
                    setAlignment(Pos.CENTER); // Center align
                }
            }
        });

        fitToParent();
        return tableColumn;
    }

    protected<S> TableColumn<T,S> constructColumn(String columnName,String fieldName,int width){
        TableColumn<T,S> tableColumn = constructColumn(columnName,fieldName);
        tableColumn.setPrefWidth(width);
        return tableColumn;
    }

    protected void fitToParent(){
        AnchorPane.setTopAnchor(this, 0.0);
        AnchorPane.setBottomAnchor(this, 0.0);
        AnchorPane.setLeftAnchor(this, 0.0);
        AnchorPane.setRightAnchor(this, 0.0);
    }

}
