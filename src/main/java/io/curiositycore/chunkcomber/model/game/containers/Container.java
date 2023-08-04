package io.curiositycore.chunkcomber.model.game.containers;

import io.curiositycore.chunkcomber.model.game.Searchable;
import io.curiositycore.chunkcomber.model.game.items.Item;
import javafx.geometry.Point3D;

import java.util.Set;

public interface Container extends Searchable {
    Set<Item> getContents();
    Item getItem(int slot);
    Point3D getLocation();
    void setContainerFields();
}
