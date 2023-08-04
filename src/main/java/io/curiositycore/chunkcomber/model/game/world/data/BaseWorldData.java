package io.curiositycore.chunkcomber.model.game.world.data;

import br.com.gamemods.regionmanipulator.Region;
import br.com.gamemods.regionmanipulator.RegionIO;
import io.curiositycore.chunkcomber.model.game.world.region.BaseRegion;
import io.curiositycore.chunkcomber.model.game.world.region.ScannableRegion;

import java.io.File;
import java.io.IOException;
import java.util.*;

public abstract class BaseWorldData implements WorldData{
    private List<File> playerFiles;
    private List<File> entityFiles;
    private List<File> regionFiles;
    private Set<ScannableRegion> regions;
    protected BaseWorldData(File worldFile){
        File[] files = worldFile.listFiles();
        this.regionFiles = getRegionFile(files,FileType.REGION);

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
         return !this.regions.isEmpty();
    }

    @Override
    public Set<ScannableRegion> scanRegions() {
        if(hasScanHistory()){
            return this.regions;
        }

        Set<ScannableRegion> scannableRegions = new HashSet<>();
        this.regionFiles.forEach(regionFile-> {
            try {
                scannableRegions.add(initRegion(RegionIO.readRegion(regionFile)));
            }
            catch (IOException e) {
                //TODO add a log file here for errors eventually
            }
        });
      return scannableRegions;
    }
    protected List<File> getRegionFile(File[] files, FileType fileType){
        return Arrays.
                stream(Objects.
                        requireNonNull(Arrays.
                                stream(files).
                                filter(file -> file.getName() == "region").
                                findFirst().
                                orElseThrow().
                                listFiles())).
                toList();
    }
    protected abstract BaseRegion initRegion(Region regionToInit);
}
