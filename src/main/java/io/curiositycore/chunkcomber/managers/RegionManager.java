package io.curiositycore.chunkcomber.managers;

import io.curiositycore.chunkcomber.model.table.ItemTable;
import javafx.scene.control.TableView;

import java.util.UUID;

public interface RegionManager{
    void scanRegion(UUID region);
    ItemTable<?> loadTable(String itemFilterId);
}
