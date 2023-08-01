package io.curiositycore.chunkcomber.model.data.region;

import io.curiositycore.chunkcomber.model.Scanable;
import io.curiositycore.chunkcomber.model.data.GameData;
import io.curiositycore.chunkcomber.model.data.chunk.ScanableChunk;

import java.util.Set;

public interface ScanableRegion extends GameData, Scanable {

    Set<ScanableChunk> getChunks();

}
