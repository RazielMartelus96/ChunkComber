package io.curiositycore.chunkcomber.model.data.chunk;

import br.com.gamemods.regionmanipulator.Chunk;
import br.com.gamemods.regionmanipulator.ChunkPos;
import io.curiositycore.chunkcomber.model.Scanable;
import io.curiositycore.chunkcomber.util.minecraft.ChunkUtil;
import javafx.geometry.Point2D;
import io.curiositycore.chunkcomber.model.containers.Container;

import java.util.Set;

public abstract class BaseChunk<T extends Scanable> {
    protected Point2D location;
    protected Set<T> containers;

    protected BaseChunk(Chunk chunk){
        ChunkPos chunkPos = chunk.getPosition();
        this.location = new Point2D(chunkPos.getXPos(),chunkPos.getZPos());
        this.containers = initContents(chunk);
    }

    protected abstract Set<T> initContents(Chunk chunk);
}
