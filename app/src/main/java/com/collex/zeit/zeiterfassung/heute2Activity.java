package com.collex.zeit.zeiterfassung;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.collex.zeit.zeiterfassung.data.Entry;
import com.collex.zeit.zeiterfassung.data.Flow;
import com.collex.zeit.zeiterfassung.data.TH;
import com.collex.zeit.zeiterfassung.data.entries.Dienstgang;
import com.collex.zeit.zeiterfassung.data.entries.Gehen;
import com.collex.zeit.zeiterfassung.data.entries.Kommen;
import com.collex.zeit.zeiterfassung.data.flows.TagFlow;

import java.util.ArrayList;
import java.util.Date;

public class heute2Activity extends AppCompatActivity {
    private Flow day;

private ArrayAdapter adapter;
private int oldX=0;
private boolean touch=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heute2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getFlow();

        ListView v = (ListView) findViewById(R.id.actionsToday);
        adapter = new EntryListAdapter(this,R.layout.simple_list,day.getBooked());

        v.setAdapter(adapter);
        v.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        v.setItemsCanFocus(true);
        v.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if ((day.getBooked().size() - 1) == position) {
                    day.getBooked().remove(position);

                    checkButtons();

                }
                return false;
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        checkButtons();

    }

    private void getFlow(){

        String key = String.valueOf(new Date().getDay())+String.valueOf(new Date().getMonth())+String.valueOf(new Date().getYear());
        if(TH.FLOWS.containsKey(key))
            day=TH.FLOWS.get(key);
        else
        {
            day=new TagFlow();
            TH.FLOWS.put(key,day);
        }
    }

    public void checkButtons() {

        findViewById(R.id.Kommen).setVisibility(View.INVISIBLE);
        findViewById(R.id.Gehen).setVisibility(View.INVISIBLE);
        findViewById(R.id.Dienstgang).setVisibility(View.INVISIBLE);

        for (Class<?> e : day.getPossibleNext()) {

            String id = e.getSimpleName();
            View b = findViewById(getResources().getIdentifier(id, "id", "com.collex.zeit.zeiterfassung"));
            if (b != null) {
                b.setVisibility(View.VISIBLE);
            }
        }



        adapter.notifyDataSetChanged();
    }

    public void time(View view){
        Intent intent = new Intent(this, TimeActivity.class);
        startActivity(intent);
    }

    public void kommen(View view) {
        day.next(Kommen.class);
        checkButtons();
    }

    public void gehen(View view) {
        day.next(Gehen.class);
        checkButtons();
    }

    public void dienstgang(View view) {
        day.next(Dienstgang.class);
        checkButtons();
    }
}
