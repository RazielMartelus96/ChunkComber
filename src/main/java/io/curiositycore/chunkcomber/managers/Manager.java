package io.curiositycore.chunkcomber.managers;

import java.util.UUID;

public interface Manager<T> {
    void register(T objectToUnregister);
    void unregister(UUID objectId);

}
