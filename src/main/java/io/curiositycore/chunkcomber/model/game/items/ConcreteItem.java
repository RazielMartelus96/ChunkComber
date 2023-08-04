package io.curiositycore.chunkcomber.model.game.items;

import io.curiositycore.chunkcomber.model.game.containers.Container;
import javafx.geometry.Point3D;
import org.bukkit.Material;

public class ConcreteItem implements Item{
    private String itemName;
    private int itemAmount;
    private int itemSlot;
    private Material itemMaterial;
    private Container container;
    private Point3D location;

    public ConcreteItem(String itemName, int itemAmount, int itemSlot, Material itemMaterial){
        this.itemName = itemName;
        this.itemAmount = itemAmount;
        this.itemSlot = itemSlot;
        this.itemMaterial = itemMaterial;
    }
    @Override
    public void delete() {

    }

    @Override
    public String getName() {
        return this.itemName;
    }

    @Override
    public int getAmount() {
        return this.itemAmount;
    }

    @Override
    public int getSlot() {
        return this.itemSlot;
    }

    @Override
    public Container getContainer() {
        return this.container;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
        this.location = container.getLocation();
    }

    @Override
    public Material getMaterial() {
        return this.itemMaterial;
    }
}
