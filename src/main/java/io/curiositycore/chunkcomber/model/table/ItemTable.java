package io.curiositycore.chunkcomber.model.table;

import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import io.curiositycore.chunkcomber.model.game.items.Item;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public abstract class ItemTable<T extends Item> extends TableView<T> {
    protected ItemTable(){
        this.getColumns().addAll(initColumns());
    }

    protected abstract List<TableColumn<T, ?>> initColumns();
    protected<S> TableColumn<T,S> constructColumn(String columnName,String fieldName){
        TableColumn<T,S> tableColumn = new TableColumn<>(columnName);
        tableColumn.setCellValueFactory(new PropertyValueFactory<>(fieldName));
        return tableColumn;
    }

}
