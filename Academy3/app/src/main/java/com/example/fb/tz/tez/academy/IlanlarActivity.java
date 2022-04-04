package com.example.fb.tz.tez.academy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class IlanlarActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar2;
    private RecyclerView ilanlarRv;
    private ArrayList<Ilanlar> ilanlarArrayList;
    private IlanlarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlar);

        toolbar2=findViewById(R.id.toolbar2);
        ilanlarRv=findViewById(R.id.ilanlarRv);

        toolbar2.setTitle("Academy İlan Ekranı");
        toolbar2.setNavigationIcon(R.drawable.backbeyaz);
        setSupportActionBar(toolbar2);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        ilanlarRv.setHasFixedSize(true);
        ilanlarRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        ilanlarArrayList = new ArrayList<>(  );
        Ilanlar i1 = new Ilanlar(1, "deu", "Dokuz Eylül Üniversitesi", "11 Araştırma görevlisi arıyor", "Dokuz eylül Üniversitesi 11 araştırma görevlisi alacaktır.",null);
        Ilanlar i2 = new Ilanlar(2, "ege", "Ege Üniversitesi", "8 araştırma görevlisi aramaktadır", "Ege Üniversitesi bünyesinde görevlendirmek üzere YBS alanında 8 ar.gör alacaktır.",null);
        Ilanlar i3 = new Ilanlar(3, "ktu", "Karadeniz Teknik Üniversitesi", "5 Araştırma görevlisi ilanıdır.", "Karadeniz Teknik Üniversitesi bünyesinde görevlendirmek üzere araştırma görevlisi alacaktır.",null);

        ilanlarArrayList.add(i1);
        ilanlarArrayList.add(i2);
        ilanlarArrayList.add(i3);

        adapter= new IlanlarAdapter(this, ilanlarArrayList);
        ilanlarRv.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("mesaj", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("harf", newText);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.arama_drawer, menu);
        MenuItem item= menu.findItem(R.id.action_arama);
        SearchView searchView= (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }
}