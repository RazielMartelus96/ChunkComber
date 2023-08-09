package io.curiositycore.chunkcomber.managers;

import io.curiositycore.chunkcomber.model.game.Identifiable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class BaseManager<T extends Identifiable> implements Manager<T,UUID>{
    protected Map<UUID,T> managerCache = new HashMap<>();

    @Override
    public void register(T objectToUnregister) {
        this.managerCache.put(objectToUnregister.getId(),objectToUnregister);
    }

    @Override
    public void unregister(UUID objectId) {
        this.managerCache.remove(objectId);
    }
}
