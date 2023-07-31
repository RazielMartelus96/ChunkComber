module io.curiositycore.chunkcomber {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.curiositycore.chunkcomber to javafx.fxml;
    exports io.curiositycore.chunkcomber;
    exports io.curiositycore.chunkcomber.gui.controller;
    opens io.curiositycore.chunkcomber.gui.controller to javafx.fxml;
    exports io.curiositycore.chunkcomber.util.minecraft;
    opens io.curiositycore.chunkcomber.util.minecraft to javafx.fxml;
}