package com.collex.zeit.zeiterfassung.data.entries;

import com.collex.zeit.zeiterfassung.data.Entry;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public class Gehen extends Entry {


    @Override
    protected void registerEntries() {
        entries.add(Kommen.class);
        entries.add(Dienstgang.class);

    }
}