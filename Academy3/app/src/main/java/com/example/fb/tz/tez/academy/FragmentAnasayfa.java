package com.example.fb.tz.tez.academy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.io.IOException;
import java.util.ArrayList;

public class FragmentAnasayfa extends Fragment {
    private RecyclerView kategoriRv;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_birinci_anasayfa,container,false);
        kategoriRv=rootview.findViewById(R.id.kategoriRv);



        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(getContext()));



        kategorilerArrayList= new ArrayList<>(  );
        Kategoriler k1= new Kategoriler( 1, "Araştırma Görevlisi" );
        Kategoriler k2= new Kategoriler( 2, "Doktor" );
        Kategoriler k3= new Kategoriler( 3, "Doçent" );
        Kategoriler k4= new Kategoriler( 4, "Profesör" );

        kategorilerArrayList.add(k1);
        kategorilerArrayList.add(k2);
        kategorilerArrayList.add(k3);
        kategorilerArrayList.add(k4);

        adapter= new KategoriAdapter(getContext(), kategorilerArrayList);
        kategoriRv.setAdapter(adapter);


        return rootview;


    }




}
