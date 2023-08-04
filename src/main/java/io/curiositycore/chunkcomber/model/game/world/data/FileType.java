package io.curiositycore.chunkcomber.model.game.world.data;

public enum FileType {
    REGION("region"), PLAYER("playerdata");
    FileType(String fileName){
        this.fileName = fileName;
    }
    private String fileName;

    public String getFileName() {
        return fileName;
    }
}
