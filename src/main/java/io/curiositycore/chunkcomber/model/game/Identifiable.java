package io.curiositycore.chunkcomber.model.game;

import java.util.UUID;

public interface Identifiable {
    UUID getId();
    default UUID setId(){
        return UUID.randomUUID();
    }
}
