package io.curiositycore.chunkcomber.model.game.items;

import io.curiositycore.chunkcomber.managers.IdManager;
import io.curiositycore.chunkcomber.model.game.containers.Container;
import io.curiositycore.chunkcomber.util.minecraft.NameUtil;
import javafx.geometry.Point3D;
import org.bukkit.Material;

public class ConcreteItem implements Item{
    private int itemNameId;
    private int itemAmount;
    private int itemSlot;
    private Material itemMaterial;

    public int getItemAmount() {
        return itemAmount;
    }

    public String getContainerName() {
        return NameUtil.getName(containerNameId).replace("minecraft:","").replace("_"," ");
    }
    public String getLocationString(){
        return "(x: "+ this.location.getX() + ", y: "+ this.location.getY()+ ", z: "+ this.location.getZ()+")";
    }

    public Point3D getLocation() {
        return location;
    }

    private int containerNameId;
    private Point3D location;

    public ConcreteItem(String itemName, int itemAmount, int itemSlot, Material itemMaterial){
        this.itemNameId = setId(itemName);
        this.itemAmount = itemAmount;
        this.itemSlot = itemSlot;
        this.itemMaterial = itemMaterial;
    }
    @Override
    public void delete() {

    }
    private int setId(String itemName){
        NameUtil.registerId(itemName);
        return NameUtil.setId(itemName);
    }

    @Override
    public String getName() {
        return NameUtil.getName(this.itemNameId);
    }

    public String getItemName(){
        return NameUtil.getName(this.itemNameId).replace("minecraft:","").replace("_", " ");
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
    public void setContainer(Container container) {
        this.containerNameId = container.getId();
        this.location = container.getLocation();
    }

    @Override
    public Material getMaterial() {
        return this.itemMaterial;
    }
}
