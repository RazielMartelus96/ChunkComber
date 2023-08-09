package io.curiositycore.chunkcomber.util.minecraft;

import io.curiositycore.chunkcomber.managers.IdManager;

public class NameUtil {

    public static String getName(int nameId){
        return IdManager.getInstance().getNameFromId(nameId);
    }
    public static int setId(String name){
        return IdManager.getInstance().getIdFromName(name);
    }

    public static void registerId(String name){
        IdManager.getInstance().register(name);
    }
}
