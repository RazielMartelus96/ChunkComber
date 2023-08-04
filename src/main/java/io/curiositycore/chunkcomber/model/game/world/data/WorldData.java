package io.curiositycore.chunkcomber.model.game.world.data;

import io.curiositycore.chunkcomber.model.game.GameData;
import io.curiositycore.chunkcomber.model.game.world.region.ScannableRegion;

import java.io.File;
import java.util.Set;

public interface WorldData extends GameData {
    Set<ScannableRegion> scanRegions();
}
