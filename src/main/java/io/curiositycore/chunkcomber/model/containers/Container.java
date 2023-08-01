package io.curiositycore.chunkcomber.model.containers;

import io.curiositycore.chunkcomber.model.Scanable;
import io.curiositycore.chunkcomber.model.items.Item;

import java.util.Set;

public interface Container extends Scanable {
    Set<Item> getContents();
    Item getItem(int slot);
}
