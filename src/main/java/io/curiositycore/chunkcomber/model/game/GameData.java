package io.curiositycore.chunkcomber.model.game;

import java.io.File;

public interface GameData {
    File loadData();
    void saveData();
    boolean hasScanHistory();

}
