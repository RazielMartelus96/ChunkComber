package io.curiositycore.chunkcomber.gui.util;

import io.curiositycore.chunkcomber.model.game.world.data.FileType;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;

import java.util.Arrays;


public class LoadedWorldDataUtil {
    public static void setWorldLabels(File worldFile, Label[] worldLabels){
        worldLabels[0].setText(getRegionAmount(worldFile));
        worldLabels[1].setText(getPlayerAmount(worldFile));
        try{
        worldLabels[2].setText(getSize(worldFile));
        } catch(IOException ioException){
            worldLabels[2].setText("Unknown Size");
        }
        worldLabels[3].setText("World selected: " + worldFile.getName());

    }
    private static String getRegionAmount(File worldFile){
        return Integer.toString(getDirectory(FileType.REGION, worldFile).listFiles().length);
    }
    private static String getPlayerAmount(File worldFile){
        return Integer.toString(getDirectory(FileType.PLAYER, worldFile).listFiles().length/2);
    }
    private static String getSize(File worldFile) throws IOException {
        return getDirectorySize(worldFile)/1000000 + "MB";
    }

    private static File getDirectory(FileType fileType, File parentFile) throws NullPointerException{
        return Arrays.stream(parentFile.listFiles()).filter(fileToCheck -> fileToCheck.getName().contains(fileType.getFileName())).findFirst().orElseThrow();
    }

    public static long getDirectorySize(File directory) {
        long totalSize = 0;

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        totalSize += file.length();
                    } else if (file.isDirectory()) {
                        totalSize += getDirectorySize(file); // Recursively get the size of subdirectories
                    }
                }
            }
        }

        return totalSize;
    }
}
