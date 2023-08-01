package io.curiositycore.chunkcomber.model.data;

import java.io.File;

public interface GameData {
    File loadData();
    void saveData();
    boolean hasScanHistory();

}
