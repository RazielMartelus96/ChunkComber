package io.curiositycore.chunkcomber.managers;

import io.curiositycore.chunkcomber.model.game.world.chunk.BaseChunk;
import io.curiositycore.chunkcomber.model.game.world.region.BaseRegion;
import io.curiositycore.chunkcomber.model.game.world.region.ScannableRegion;


import java.util.Set;
import java.util.UUID;

public abstract class BaseRegionManager extends BaseManager<BaseRegion> implements RegionManager {
    @Override
    public void scanRegion(UUID regionId) {
        BaseRegion regionToScan = this.managerCache.get(regionId);
        Set<BaseChunk<?>> scannableChunks = this.managerCache.get(regionId).getChunks();
        scannableChunks.forEach(BaseChunk::scan);
        regionToScan.delete();
        if(regionToScan.getChunks().isEmpty()){
            unregister(regionToScan.getId());
        }
    }

}
