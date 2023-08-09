package io.curiositycore.chunkcomber.model.game.world.chunk;

import br.com.gamemods.regionmanipulator.Chunk;
import br.com.gamemods.regionmanipulator.ChunkPos;
import io.curiositycore.chunkcomber.model.Deletable;
import io.curiositycore.chunkcomber.model.game.Searchable;
import javafx.geometry.Point2D;

import java.util.Set;
import java.util.UUID;

public abstract class BaseChunk<T extends Searchable> implements ScannableChunk<T>{
    protected Point2D location;
    protected Set<T> containers;
    protected Chunk chunk;
    protected UUID nbtChunkId;

    protected BaseChunk(Chunk chunk){
        ChunkPos chunkPos = chunk.getPosition();
        this.location = new Point2D(chunkPos.getXPos(),chunkPos.getZPos());
        this.chunk = chunk;
    }

    @Override
    public UUID getId() {
        return this.nbtChunkId;
    }



    protected abstract Set<T> initContents(Chunk chunk);


    @Override
    public void scan() {
        this.containers = initContents(this.chunk);
        this.chunk = null;
    }


}
