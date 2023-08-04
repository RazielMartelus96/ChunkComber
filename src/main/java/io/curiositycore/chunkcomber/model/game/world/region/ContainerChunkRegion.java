package io.curiositycore.chunkcomber.model.game.world.region;

import br.com.gamemods.regionmanipulator.Chunk;
import br.com.gamemods.regionmanipulator.ChunkPos;
import br.com.gamemods.regionmanipulator.Region;
import io.curiositycore.chunkcomber.model.game.world.chunk.BaseChunk;
import io.curiositycore.chunkcomber.model.game.world.chunk.ContainerChunk;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainerChunkRegion extends BaseRegion{
    int totalContainers;
    public ContainerChunkRegion(Region regionInstance) {
        super(regionInstance);
    }

    @Override
    protected Set<BaseChunk<?>> initRegionChunks(Set<Map.Entry<ChunkPos, Chunk>> chunks) {
        Set<BaseChunk<?>> initializedRegionChunks = new HashSet<>();
        chunks.forEach(chunk-> initializedRegionChunks.add(new ContainerChunk(chunk.getValue())));
        return initializedRegionChunks;
    }

    @Override
    public void scan() {
        this.regionChunks.forEach(BaseChunk::scan);
    }
    protected void setTotalContainers(){
        this.totalContainers = regionChunks.stream()
                .mapToInt(containerChunk -> containerChunk.getContainers().size())
                .sum();
    }
}
