package io.curiositycore.chunkcomber.util.minecraft;

import io.curiositycore.chunkcomber.util.exceptions.InvalidFileTypeException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WorldDataUtil {
    public static File getWorldFile(String filepath) throws InvalidFileTypeException{
            File selectedFile = new File(filepath);
            if(!isWorldFile(selectedFile)){
                throw new InvalidFileTypeException("The file: ("+ selectedFile.getName()+") is not a world file!");
            }
        return new File(filepath);
    }
    private static boolean isWorldFile(File fileToCheck){
        ArrayList<String> folderChecks = new ArrayList<>();

        //added as a placeholder atm, in future multiple world files will be scanned and should be determined by search type.
        String[] folderArray = new String[] {"region","advancements","data","datapacks","DIM1","DIM-1","entities","playerdata","poi","serverconfig","stats"};
        Set<String> stringSet = new HashSet<>(Arrays.asList(folderArray));
        for(String folderName : folderArray){
            folderChecks.add(folderName);
        }

        for(File currentFile:fileToCheck.listFiles()){
            if(!currentFile.isDirectory()){
                continue;
            }
            if(!stringSet.contains(currentFile.getName())){
                return false;
            }
        }

        return true;
    }
}
