package com.collex.zeit.zeiterfassung.data;

import android.os.SystemClock;
import android.text.format.Time;

import com.collex.zeit.zeiterfassung.data.helper.TimeHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public abstract class Entry {
    private final long bookingS;
    private long bookingE;
    protected final List<Class<? extends Entry>> entries;

    public Entry() {

        bookingS = TimeHelper.getActMillis();
        entries = new ArrayList<>();
        registerEntries();
    }



    public List<Class<? extends Entry>> getPossibleEntries() {
        return entries;
    }

    public Entry getNext(Class<? extends Entry> tClass) {
        bookingE = TimeHelper.getActMillis();
        return getEntry(bookingE, tClass);
    }

    public long getStartBooking() {
        return bookingS;
    }

    public long getEndBooking() {
        return bookingE;
    }

    protected Entry getEntry(long booking, Class<? extends Entry> tClass) {
        if (entries.contains(tClass))
            try {
                return (Entry) tClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return null;
    }

    protected abstract void registerEntries();


}
