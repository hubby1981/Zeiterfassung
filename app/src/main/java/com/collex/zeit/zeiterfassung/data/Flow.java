package com.collex.zeit.zeiterfassung.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public abstract class Flow {
    protected Class<? extends Entry> start;
    private List<Entry> booked;
    private Model model;

    public Flow(Model model) {
        this.model = model;
        booked = new ArrayList<>();
    }

    protected Flow(Class<? extends Entry> start, Model model) {
        this(model);
        this.start = start;

    }

    public void next(Class<? extends Entry> entry) {
        try {
            if (booked.size() == 0) {

                booked.add(start.newInstance());

            } else {
                Entry last = booked.get(booked.size() - 1);
                if (last.getPossibleEntries().contains(entry)) {
                    booked.add(last.getNext(entry));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public List<Class<? extends Entry>> getPossibleNext() {
        List<Class<? extends Entry>> result = new ArrayList<>();
        if (booked.size() == 0) {
            result.add(start);
        } else {
            result = booked.get(booked.size() - 1).getPossibleEntries();
        }
        return result;
    }

    public List<Entry> getBooked(){
        return booked;
    }


    private double getSoll() {
        List<Entry> all = new ArrayList<>();
        for (Entry e : booked) {
            if (model.bookable.contains(e.getClass())) {
                all.add(e);
            }
        }
        double result = model.getSoll();
        for (Entry e : all) {

        }
        return 0;
    }

}
