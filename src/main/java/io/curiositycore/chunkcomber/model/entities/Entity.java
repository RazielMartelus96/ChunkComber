package io.curiositycore.chunkcomber.model.entities;

import io.curiositycore.chunkcomber.model.Deletable;
import io.curiositycore.chunkcomber.model.Scanable;

public interface Entity extends Scanable, Deletable {

    UUID getEntityId();


}
