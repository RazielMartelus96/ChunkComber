package io.curiositycore.chunkcomber.managers;

import io.curiositycore.chunkcomber.model.game.items.ConcreteItem;
import io.curiositycore.chunkcomber.model.game.world.region.ContainerChunkRegion;
import io.curiositycore.chunkcomber.model.table.ConcreteItemTable;
import io.curiositycore.chunkcomber.model.table.ItemTable;

import java.io.File;


public class ContainerRegionManager extends BaseRegionManager{

    private static ContainerRegionManager instance;

    public File getWorldFile() {
        return worldFile;
    }
    public void setWorldFile(File worldFile) {
        this.worldFile = worldFile;
    }

    private File worldFile;
    private ContainerRegionManager() {
    }

    public static synchronized ContainerRegionManager getInstance() {
        if (instance == null) {
            instance = new ContainerRegionManager();
        }
        return instance;
    }
    @Override
    public ItemTable<?> loadTable(String itemFilterId) {
        ConcreteItemTable itemTable = new ConcreteItemTable();
        this.managerCache.values().forEach(containerChunkRegion->{
            if(!regionDataChecks((ContainerChunkRegion) containerChunkRegion)){
                return;
            }
            containerChunkRegion.
                    getChunks().
                    forEach(baseChunk -> baseChunk.getContainers().
                            forEach(container -> container.getContents().
                                    forEach(item-> itemTable.getItems().
                                            add((ConcreteItem) item)
                                    )
                            )
                    );
        });
        return itemTable;
    }
    protected boolean regionDataChecks(ContainerChunkRegion containerChunkRegion){
        //Kept like this for the sake of future-proofing (More tests will be required)
        if(!containerChunkRegion.hasScanHistory()){
            return false;
        }
        return true;
    }

    public int getRegionAmount(){
        return this.managerCache.size();
    }

}
