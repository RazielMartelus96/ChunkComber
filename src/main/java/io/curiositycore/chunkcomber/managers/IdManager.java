package io.curiositycore.chunkcomber.managers;

import io.curiositycore.chunkcomber.model.game.id.NameId;

import java.util.*;
import java.util.stream.Collectors;

public class IdManager implements Manager<String,Integer>{
    private static IdManager instance;

    private IdManager() {
    }

    public static synchronized IdManager getInstance() {
        if (instance == null) {
            instance = new IdManager();
        }
        return instance;
    }
    private Set<NameId> nameCache= new HashSet<>();
    private int currentMaxInteger = 0;


    @Override
    public void register(String nameToRegister) {
        if(storedInCache(nameToRegister)){
            return;
        }
        addToCache(nameToRegister);
    }

    @Override
    public void unregister(Integer nameId) {
        this.nameCache = nameCache.stream().filter(storedName-> storedName.getNameId() != nameId).collect(Collectors.toSet());
    }
    private void addToCache(String nameToRegister){
        this.currentMaxInteger += 1;
        this.nameCache.add(new NameId(nameToRegister,currentMaxInteger));
    }
    public String getNameFromId(int nameId){
        try{
        return this.nameCache.
                stream().
                filter(storedName-> storedName.getNameId() == nameId).
                findFirst().
                orElseThrow().
                getName();
        }
        catch(NoSuchElementException exception){
            System.out.println("The id: "+nameId + " is not in the cache!");
            return null;
        }
    }
    public int getIdFromName(String name){
        try{
            return this.nameCache.
                    stream().
                    filter(storedName-> Objects.equals(storedName.getName(), name)).
                    findFirst().
                    orElseThrow().
                    getNameId();
        }
        catch(NoSuchElementException exception){
                addToCache(name);
                System.out.println("Not in Cache, added now with id: "+ this.currentMaxInteger );
                return currentMaxInteger;
            }
    }

    private boolean storedInCache(String name){
        return this.nameCache.
                stream().
                anyMatch(nameId-> Objects.equals(nameId.getName(), name));
    }
}
