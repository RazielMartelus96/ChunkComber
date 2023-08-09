package io.curiositycore.chunkcomber.model.table;

import io.curiositycore.chunkcomber.model.game.containers.Container;
import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import javafx.geometry.Point3D;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class ConcreteItemTable extends ItemTable<ConcreteItem>{
    @Override
    protected List<TableColumn<ConcreteItem, ?>> initColumns() {
        List<TableColumn<ConcreteItem,?>> tableColumns = new ArrayList<>();
        TableColumn<ConcreteItem, String> itemNameColumn = constructColumn("Item","itemName",76);
        TableColumn<ConcreteItem, Integer>  itemAmountColumn =constructColumn("Amount","itemAmount",58);
        TableColumn<ConcreteItem, String>  containerColumn= constructColumn("Container","containerName",66);
        TableColumn<ConcreteItem, String>  locationColumn= constructColumn("Coordinates","locationString",192);


        this.setPrefSize(393,176);
        tableColumns.add(itemNameColumn);
        tableColumns.add(itemAmountColumn);
        tableColumns.add(containerColumn);
        tableColumns.add(locationColumn);

        return tableColumns;
    }
}
