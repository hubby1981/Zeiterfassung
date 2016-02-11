package com.collex.zeit.zeiterfassung.data.flows;

import com.collex.zeit.zeiterfassung.data.Entry;
import com.collex.zeit.zeiterfassung.data.Flow;
import com.collex.zeit.zeiterfassung.data.Model;
import com.collex.zeit.zeiterfassung.data.entries.Kommen;
import com.collex.zeit.zeiterfassung.data.models.TagModel;

/**
 * Created by marcel.weissgerber on 11.02.2016.
 */
public class TagFlow extends Flow {

    public TagFlow() {
        super(Kommen.class, new TagModel());
    }
}
