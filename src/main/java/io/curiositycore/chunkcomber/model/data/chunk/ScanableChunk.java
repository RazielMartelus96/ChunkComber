package io.curiositycore.chunkcomber.model.data.chunk;

import io.curiositycore.chunkcomber.model.Scanable;
import io.curiositycore.chunkcomber.model.containers.Container;
import io.curiositycore.chunkcomber.model.data.GameData;
import io.curiositycore.chunkcomber.model.items.Item;

import java.util.Set;

public interface ScanableChunk<T extends Scanable> extends GameData, Scanable {
    Set<Container> getContainers();
    Set<T> getItems();
    boolean isCorrupt();

}
