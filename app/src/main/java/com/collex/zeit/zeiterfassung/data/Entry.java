package com.collex.zeit.zeiterfassung.data;

import android.os.SystemClock;
import android.text.format.Time;

import com.collex.zeit.zeiterfassung.data.helper.TimeHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public abstract class Entry {
    private long bookingS;
    private long bookingE;
    protected final List<Class<? extends Entry>> entries;

    public Entry(long booking) {

        rebook(booking);
        entries = new ArrayList<>();
        registerEntries();
    }

    public Entry rebook(long booking){
        bookingS = booking == 0 ? TimeHelper.getActMillis():booking;
        return this;
    }
    public Entry rebook2(long booking){
        bookingE = booking == 0 ? TimeHelper.getActMillis():booking;
        return this;
    }
    public List<Class<? extends Entry>> getPossibleEntries() {
        return entries;
    }

    public Entry getNext(Class<? extends Entry> tClass,long booking) {
        rebook2(booking);
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
                return  tClass.newInstance().rebook(booking);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return null;
    }

    public String toListItem(){
        String result="";
        Date d = new Date(bookingS);
        result = result.concat(new SimpleDateFormat("HH:mm",Locale.getDefault()).format(d));
        result = result.concat(" - ");
        result = result.concat(this.getClass().getSimpleName().toUpperCase());
        return result;
    }

    protected abstract void registerEntries();


}
