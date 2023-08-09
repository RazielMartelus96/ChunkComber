package io.curiositycore.chunkcomber.util.minecraft;

import br.com.gamemods.nbtmanipulator.NbtCompound;
import br.com.gamemods.nbtmanipulator.NbtList;
import br.com.gamemods.regionmanipulator.Chunk;
import io.curiositycore.chunkcomber.model.game.containers.ConcreteContainer;
import io.curiositycore.chunkcomber.model.game.containers.ConcreteShulkerBox;
import io.curiositycore.chunkcomber.model.game.containers.Container;
import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import io.curiositycore.chunkcomber.model.game.items.Item;
import javafx.geometry.Point3D;
import org.bukkit.Material;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class ChunkUtil {
    private ChunkUtil(){}
    public static Set<Container> getContainers(Chunk chunk){
        Set<Container> containerSet = new HashSet<>();
        NbtList<NbtCompound> blockEntitiesList = chunk.getCompound().getCompoundList("block_entities");
        for (NbtCompound blockEntity : blockEntitiesList){
            try {
                Container container = getContainer(blockEntity, null, 0);
                containerSet.add(container);
            } catch (Exception e){


                if (blockEntity.containsKey("Items")){
                    e.printStackTrace();
                }
            }
        }
        return containerSet;
    }

    private static Container getContainer(NbtCompound blockEntity, @Nullable String pos, @Nullable Integer slot){
        NbtList<NbtCompound> containerItemsList = blockEntity.getCompoundList("Items");
        return new ConcreteContainer(
                getContainerContents(containerItemsList),
                blockEntity.getString("id"),
                getBlockEntityLocation(blockEntity));
    }

    private static ConcreteShulkerBox getShulkerBox(NbtCompound shulkerEntity, int slotOfShulker, String itemId){
        NbtList<NbtCompound> containerItemsList = shulkerEntity.getCompoundList("Items");
        return new ConcreteShulkerBox(itemId, itemId,
                getContainer(shulkerEntity,null,slotOfShulker),
                slotOfShulker,
                getItemMaterial(itemId));
    }

    private static Set<Item> getContainerContents(NbtList<NbtCompound> containerItemsList){
        Set<Item> containerContents = new HashSet<>();
        for(NbtCompound item : containerItemsList){
            String itemId = item.getString("id");
            byte slot = item.getByte("Slot");
            if (itemId.contains("shulker_box")){
                NbtCompound inContainerEntity = item.getCompound("tag").getCompound("BlockEntityTag");
                ConcreteShulkerBox shulkerBox = getShulkerBox(inContainerEntity,slot, itemId);
                containerContents.add(shulkerBox);
            }
            Byte itemCount = (item.getByte("Count"));
            int itemCountInt = itemCount.intValue();
            containerContents.add(new ConcreteItem(itemId,itemCountInt,slot,getItemMaterial(itemId)));

        }
        return containerContents;
    }

    private static Material getItemMaterial(String itemId){
        return null;
    }

    private static Point3D getBlockEntityLocation(NbtCompound blockEntity){
        try{
            return new Point3D(blockEntity.getInt("x"), blockEntity.getInt("y"), blockEntity.getInt("z"));
        }
        catch(NoSuchElementException noSuchElementException) {
            return null;
        }
    }
}
