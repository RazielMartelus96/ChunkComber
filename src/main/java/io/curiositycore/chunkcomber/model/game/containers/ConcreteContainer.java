package io.curiositycore.chunkcomber.model.game.containers;

import io.curiositycore.chunkcomber.model.game.items.Item;
import io.curiositycore.chunkcomber.util.minecraft.NameUtil;
import javafx.geometry.Point3D;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ConcreteContainer implements Container{
    public ConcreteContainer(Set<Item> containerContents, String containerId, Point3D containerLocation){
        this.containerId = NameUtil.setId(containerId);
        this.containerContents = (containerContents.toArray(new Item[0]));
        this.containerLocation = containerLocation;
    }
    private final int containerId;
    private final Item[] containerContents;
    private final Point3D containerLocation;

    @Override
    public Set<Item> getContents() {
        return Arrays.stream(this.containerContents).collect(Collectors.toSet());
    }

    @Override
    public Item getItem(int slot) {

        return Arrays.stream(this.containerContents).filter(item-> item.getSlot() == slot).findFirst().orElseThrow();
    }

    @Override
    public Point3D getLocation() {
        return this.containerLocation;
    }

    @Override
    public int getId() {
        return this.containerId;
    }

    @Override
    public void setContainerFields() {
        Arrays.stream(this.containerContents).forEach(item-> item.setContainer(this));
    }


}
