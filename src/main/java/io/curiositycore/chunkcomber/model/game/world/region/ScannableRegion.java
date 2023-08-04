package io.curiositycore.chunkcomber.model.game.world.region;

import io.curiositycore.chunkcomber.model.game.Scannable;
import io.curiositycore.chunkcomber.model.game.GameData;
import io.curiositycore.chunkcomber.model.game.world.chunk.BaseChunk;

import java.util.Set;

public interface ScannableRegion extends GameData, Scannable {

    Set<BaseChunk<?>> getChunks();

}
