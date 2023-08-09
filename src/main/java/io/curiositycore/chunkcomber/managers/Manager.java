package io.curiositycore.chunkcomber.managers;

import java.util.UUID;

public interface Manager<T,I> {
    void register(T objectToUnregister);
    void unregister(I objectId);

}
