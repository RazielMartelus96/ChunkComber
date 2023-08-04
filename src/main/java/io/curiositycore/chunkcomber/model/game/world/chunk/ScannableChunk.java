package io.curiositycore.chunkcomber.model.game.world.chunk;

import io.curiositycore.chunkcomber.model.game.Scannable;
import io.curiositycore.chunkcomber.model.game.containers.Container;
import io.curiositycore.chunkcomber.model.game.GameData;

import java.util.Set;

public interface ScannableChunk<T> extends GameData, Scannable {
    Set<Container> getContainers();
    boolean isCorrupt();

}
