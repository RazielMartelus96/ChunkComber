package io.curiositycore.chunkcomber.model.items;

import io.curiositycore.chunkcomber.model.Deletable;
import io.curiositycore.chunkcomber.model.Scanable;
import io.curiositycore.chunkcomber.model.containers.Container;
import org.bukkit.Material;

public interface Item extends Scanable, Deletable {
    String getName();
    int getAmount();
    int getSlot();
    Container getContainer();
    Material getMaterial();

}
