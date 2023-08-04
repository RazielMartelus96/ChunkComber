package io.curiositycore.chunkcomber.model.game.containers;

import io.curiositycore.chunkcomber.model.game.items.Item;
import javafx.geometry.Point3D;

import java.util.Set;

public class ConcreteContainer implements Container{
    public ConcreteContainer(Set<Item> containerContents, String containerId, Point3D containerLocation){
        this.containerId = containerId;
        this.containerLocation = containerLocation;
    }
    private String containerId;
    private Set<Item> containerContents;
    private Point3D containerLocation;

    @Override
    public Set<Item> getContents() {
        return this.containerContents;
    }

    @Override
    public Item getItem(int slot) {
        return this.containerContents.stream().filter(item-> item.getSlot() == slot).findFirst().orElseThrow();
    }

    @Override
    public Point3D getLocation() {
        return this.containerLocation;
    }

    @Override
    public void setContainerFields() {
        this.containerContents.forEach(item-> item.setContainer(this));
    }


}
