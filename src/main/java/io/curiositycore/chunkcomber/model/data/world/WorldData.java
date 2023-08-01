package io.curiositycore.chunkcomber.model.data.world;

import io.curiositycore.chunkcomber.model.data.GameData;
import io.curiositycore.chunkcomber.model.data.region.ScanableRegion;

import java.util.Set;

public interface WorldData extends GameData {
    Set<ScanableRegion> getRegions();
}
