package io.curiositycore.chunkcomber.model.game.containers;

import io.curiositycore.chunkcomber.model.game.items.Item;

import java.util.Set;

public interface ShulkerBox extends Item, Container {
    String getColor();
    Set<Item> getContents();
}
