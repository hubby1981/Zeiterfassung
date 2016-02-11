package com.collex.zeit.zeiterfassung.data.entries;

import com.collex.zeit.zeiterfassung.data.Entry;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public class Kommen extends Entry {

    public Kommen(){
        this(0);
    }
    public Kommen(long booking) {
        super(booking);
    }

    @Override
    protected void registerEntries() {
        entries.add(Gehen.class);
        entries.add(Dienstgang.class);

    }
}
