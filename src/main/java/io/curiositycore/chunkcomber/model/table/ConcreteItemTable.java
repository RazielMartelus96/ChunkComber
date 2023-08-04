package io.curiositycore.chunkcomber.model.table;

import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import javafx.geometry.Point3D;
import javafx.scene.control.TableColumn;

import java.util.ArrayList;
import java.util.List;

public class ConcreteItemTable extends ItemTable<ConcreteItem>{
    @Override
    protected List<TableColumn<ConcreteItem, ?>> initColumns() {
        List<TableColumn<ConcreteItem,?>> tableColumns = new ArrayList<>();
        TableColumn<ConcreteItem, Point3D>  locationColumn= constructColumn("Coordinates","location");
        TableColumn<ConcreteItem, Integer>  itemAmountColumn =constructColumn("Amount","itemAmount");
        tableColumns.add(locationColumn);
        tableColumns.add(itemAmountColumn);
        return tableColumns;
    }
}
