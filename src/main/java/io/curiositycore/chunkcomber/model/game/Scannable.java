package io.curiositycore.chunkcomber.model.game;

import javafx.geometry.Point2D;

public interface Scannable extends Identifiable{
    Point2D getLocation();
    void scan();

    
    
}
