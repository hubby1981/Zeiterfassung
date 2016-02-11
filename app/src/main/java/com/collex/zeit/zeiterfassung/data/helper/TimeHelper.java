package com.collex.zeit.zeiterfassung.data.helper;

import android.text.format.Time;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public class TimeHelper {

    public static long getActMillis(){
        Time t = new Time();
        t.setToNow();
        return t.toMillis(false);
    }
}
