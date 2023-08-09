package io.curiositycore.chunkcomber.model.game.id;

public class NameId{
    int nameId;
    String name;
    public NameId(String name, int nameId){
        this.name = name;
        this.nameId = nameId;
    }
    public int getNameId() {
        return nameId;
    }

    public String getName() {
        return name;
    }
}
