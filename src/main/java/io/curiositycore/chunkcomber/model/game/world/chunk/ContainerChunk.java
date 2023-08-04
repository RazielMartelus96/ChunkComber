package io.curiositycore.chunkcomber.model.game.world.chunk;

import br.com.gamemods.regionmanipulator.Chunk;
import io.curiositycore.chunkcomber.model.game.containers.Container;
import io.curiositycore.chunkcomber.util.minecraft.ChunkUtil;
import javafx.geometry.Point2D;

import java.io.File;
import java.util.Set;

public class ContainerChunk extends BaseChunk<Container> implements ScannableChunk<Container> {
    public ContainerChunk(Chunk chunk) {
        super(chunk);
    }

    @Override
    public Point2D getLocation() {
        return this.location;
    }

    @Override
    public File loadData() {
        return null;
    }

    @Override
    public void saveData() {

    }

    @Override
    public boolean hasScanHistory() {
        return false;
    }

    @Override
    public Set<Container> getContainers() {
        return this.containers;
    }

    @Override
    public boolean isCorrupt() {
        return false;
    }

    @Override
    protected Set<Container> initContents(Chunk chunk) {
        return ChunkUtil.getContainers(chunk);
    }

}
