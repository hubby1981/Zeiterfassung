package com.collex.zeit.zeiterfassung.data.entries;

import com.collex.zeit.zeiterfassung.data.Entry;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public class Dienstgang extends Entry {

    public Dienstgang(){
        this(0);
    }
    public Dienstgang(long booking) {
        super(booking);
    }

    @Override
    protected void registerEntries() {
        entries.add(Gehen.class);
        entries.add(Kommen.class);
    }
}
