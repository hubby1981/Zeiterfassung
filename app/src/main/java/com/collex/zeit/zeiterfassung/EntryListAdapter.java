package com.collex.zeit.zeiterfassung;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.collex.zeit.zeiterfassung.data.Entry;
import com.collex.zeit.zeiterfassung.data.entries.Dienstgang;
import com.collex.zeit.zeiterfassung.data.entries.Gehen;
import com.collex.zeit.zeiterfassung.data.entries.Kommen;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by marcel.weissgerber on 12.02.2016.
 */
public class EntryListAdapter extends ArrayAdapter<Entry> {
    private Context context;
    private List<Entry> objects;

    public EntryListAdapter(Context context, int resource, List<Entry> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.simple_list, parent, false);

        Entry e = objects.get(position);
        TextView t = (TextView) rowView.findViewById(R.id.booking_line1);
        ImageView i1 = (ImageView) rowView.findViewById(R.id.bookingPic);


        t.setText(e.toListItem());
         if(e.getClass().equals(Gehen.class))
             i1.setImageResource(R.drawable.gehen2);
        if(e.getClass().equals(Dienstgang.class))
            i1.setImageResource(R.drawable.dienstgang2);
        return rowView;
    }

}
