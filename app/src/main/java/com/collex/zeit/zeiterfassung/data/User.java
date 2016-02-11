package com.collex.zeit.zeiterfassung.data;

import java.util.UUID;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public class User {
    private  final String id;
    private final String name;
    public User(String name){
        this(name, UUID.randomUUID().toString());
    }

    public User(String name,String id){
        this.id = id;
        this.name=name;
    }

    public String getId(){
        return id;
    }

    public String getName()
    {
        return name;
    }
}
