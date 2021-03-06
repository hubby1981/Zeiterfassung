package com.collex.zeit.zeiterfassung;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.collex.zeit.zeiterfassung.data.Flow;
import com.collex.zeit.zeiterfassung.data.entries.Dienstgang;
import com.collex.zeit.zeiterfassung.data.entries.Gehen;
import com.collex.zeit.zeiterfassung.data.entries.Kommen;
import com.collex.zeit.zeiterfassung.data.flows.TagFlow;

public class HeuteActivity extends AppCompatActivity {
    private Flow day = new TagFlow();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heute);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        checkButtons();
    }


    public void checkButtons(){
        findViewById(R.id.Kommen).setVisibility(View.INVISIBLE);
        findViewById(R.id.Gehen).setVisibility(View.INVISIBLE);
        findViewById(R.id.Dienstgang).setVisibility(View.INVISIBLE);

        for(Class<?> e : day.getPossibleNext()){

           String id = e.getSimpleName();
            View b = findViewById(getResources().getIdentifier(id,"id","com.collex.zeit.zeiterfassung"));
            if(b!=null){
                b.setVisibility(View.VISIBLE);
            }
       }

    }

    public void kommen(View view){
        day.next(Kommen.class);
        checkButtons();
    }

    public void gehen(View view){
        day.next(Gehen.class);
        checkButtons();
    }

    public void dienstgang(View view){
        day.next(Dienstgang.class);
        checkButtons();
    }
}
