package io.curiositycore.chunkcomber.model.game.world.region;

import br.com.gamemods.regionmanipulator.Chunk;
import br.com.gamemods.regionmanipulator.ChunkPos;
import br.com.gamemods.regionmanipulator.Region;
import io.curiositycore.chunkcomber.model.game.world.chunk.BaseChunk;
import javafx.geometry.Point2D;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public abstract class BaseRegion implements ScannableRegion {
    protected Region regionInstance;
    protected Set<BaseChunk<?>> regionChunks = new HashSet<>();
    protected Point2D location;
    protected File regionFile;
    protected BaseRegion(Region regionInstance){
        this.regionInstance = regionInstance;
        this.regionChunks = initRegionChunks(regionInstance.getEntries());
    }

    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public File loadData() {
        return this.regionFile;
    }

    @Override
    public void saveData() {
        //TODO TBD
    }

    @Override
    public boolean hasScanHistory() {
        return this.regionChunks.isEmpty();
    }

    @Override
    public Set<BaseChunk<?>> getChunks() {
        return this.regionChunks;
    }
    protected abstract Set<BaseChunk<?>> initRegionChunks(Set<Map.Entry<ChunkPos,Chunk>> chunks);
}
