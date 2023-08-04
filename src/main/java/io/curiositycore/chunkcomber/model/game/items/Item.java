package io.curiositycore.chunkcomber.model.game.items;

import io.curiositycore.chunkcomber.model.Deletable;
import io.curiositycore.chunkcomber.model.game.containers.Container;
import io.curiositycore.chunkcomber.model.game.Searchable;
import org.bukkit.Material;

public interface Item extends Deletable, Searchable {
    String getName();
    int getAmount();
    int getSlot();
    Container getContainer();
    void setContainer(Container container);
    Material getMaterial();

}
