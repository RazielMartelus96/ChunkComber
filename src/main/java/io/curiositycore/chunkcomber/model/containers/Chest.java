package io.curiositycore.chunkcomber.model.containers;

import io.curiositycore.chunkcomber.model.items.Item;
import io.curiositycore.chunkcomber.util.minecraft.MaterialUtil;
import javafx.geometry.Point2D;

import java.util.Set;

public class Chest implements Container{
    private final String name;
    private final String materialId;
    private Set<Item> contents;
    private Point2D location;
    public Chest(String materialId, Point2D location,Set<Item> contents){
        this.materialId = materialId;
        this.name = MaterialUtil.convertToCustomFormat(materialId);
        this.location = location;
        this.contents = contents;
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public Set<Item> getContents() {
        return this.contents;
    }

    @Override
    public Item getItem(int slot) {
        return this.contents.stream().filter(item-> item.getSlot() == slot).findFirst().orElse(null);
    }
}
