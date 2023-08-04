package io.curiositycore.chunkcomber.model.game.entities;

import io.curiositycore.chunkcomber.model.Deletable;
import io.curiositycore.chunkcomber.model.game.Searchable;

import java.util.UUID;

public interface Entity extends Searchable, Deletable {

    UUID getEntityId();


}
