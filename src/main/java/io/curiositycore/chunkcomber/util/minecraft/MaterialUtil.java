package io.curiositycore.chunkcomber.util.minecraft;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaterialUtil {
    public static List<String> getItemNames(ScalableTypes scalableTypes){
        switch(scalableTypes){
            case ORES:
                return getNamesFromMaterials("_ORE");
        }
        return null;
    }

    private static List<String> getNamesFromMaterials(String filterPhrase){
        List<String> newStringList = new ArrayList<>();
        Material[] allMaterials = Material.values();
        for(Material material: allMaterials){
            String materialName = material.name();
            if(!materialName.contains(filterPhrase) || materialName.contains("LEGACY")){
                continue;
            }
            newStringList.add(convertToCustomFormat(material.name()));
        }
        Collections.sort(newStringList);
        return newStringList;
    }
    public static String convertToCustomFormat(String input) {
        String[] words = input.split("_");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            char firstLetter = Character.toUpperCase(word.charAt(0));
            word = firstLetter + word.substring(1);
            resultBuilder.append(word).append(" ");
        }

        return resultBuilder.toString().trim();
    }
}
