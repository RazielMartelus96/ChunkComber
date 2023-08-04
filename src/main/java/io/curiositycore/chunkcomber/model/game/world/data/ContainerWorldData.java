package io.curiositycore.chunkcomber.model.game.world.data;

import br.com.gamemods.regionmanipulator.Region;
import io.curiositycore.chunkcomber.model.game.world.region.BaseRegion;
import io.curiositycore.chunkcomber.model.game.world.region.ContainerChunkRegion;

import java.io.File;

public class ContainerWorldData extends BaseWorldData {
    protected ContainerWorldData(File worldFile) {
        super(worldFile);
    }

    @Override
    protected BaseRegion initRegion(Region regionToInit) {
        return new ContainerChunkRegion(regionToInit);
    }
}
