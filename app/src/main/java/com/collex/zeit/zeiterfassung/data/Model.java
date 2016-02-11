package com.collex.zeit.zeiterfassung.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public abstract class Model {
    private double soll=-8.0;
    protected List<Class<? extends Entry>> bookable;

    public Model(){
        bookable=new ArrayList<>();
    }
    protected abstract void register();
    protected void setSoll(double soll){
        this.soll = soll;
    }

    public double getSoll(){
        return this.soll;
    }
}
