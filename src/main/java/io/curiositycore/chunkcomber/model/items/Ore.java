package io.curiositycore.chunkcomber.model.items;

import io.curiositycore.chunkcomber.model.containers.Container;
import javafx.geometry.Point2D;
import org.bukkit.Material;

public class Ore implements Item{
    String name;
    String bukkitId;
    int slotNumber;
    int amount;
    Point2D location;
    Container container;


    @Override
    public void delete() {
        //TODO make utility class for item deleteion
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }

    @Override
    public int getSlot() {
        return this.slotNumber;
    }

    @Override
    public Container getContainer() {
        return null;
    }

    @Override
    public Material getMaterial() {
        return Material.getMaterial(this.bukkitId);
    }
}
