package io.curiositycore.chunkcomber.model.game.containers;

import io.curiositycore.chunkcomber.model.game.items.Item;
import javafx.geometry.Point3D;
import org.bukkit.Material;

import java.util.Set;

public class ConcreteShulkerBox implements ShulkerBox{
    private String shulkerBoxName;
    private Container shulkerBoxContainer;
    private String shulkerBoxColor;
    private int slot;
    private Material shulkerBoxMaterial;

    public ConcreteShulkerBox(String shulkerBoxName, String shulkerBoxColor,Container shulkerBoxContainer, int slot, Material shulkerBoxMaterial){
        this.shulkerBoxName = shulkerBoxName;
        this.shulkerBoxColor = shulkerBoxColor;
        this.shulkerBoxContainer = shulkerBoxContainer;
        this.slot = slot;
        this.shulkerBoxMaterial = shulkerBoxMaterial;
    }
    @Override
    public String getColor() {
        return this.shulkerBoxColor;
    }

    @Override
    public Set<Item> getContents() {
        return this.shulkerBoxContainer.getContents();
    }

    @Override
    public Item getItem(int slot) {
        return null;
    }

    @Override
    public Point3D getLocation() {
        return this.shulkerBoxContainer.getLocation();
    }

    @Override
    public void setContainerFields() {
        this.shulkerBoxContainer.setContainerFields();
    }

    @Override
    public void delete() {

    }

    @Override
    public String getName() {
        return this.shulkerBoxName;
    }

    @Override
    public int getAmount() {
        return 1;
    }

    @Override
    public int getSlot() {
        return this.slot;
    }


    @Override
    public Container getContainer() {
        return this.shulkerBoxContainer;
    }

    @Override
    public void setContainer(Container container) {
        this.shulkerBoxContainer = container;
    }

    @Override
    public Material getMaterial() {
        return this.shulkerBoxMaterial;
    }

}
