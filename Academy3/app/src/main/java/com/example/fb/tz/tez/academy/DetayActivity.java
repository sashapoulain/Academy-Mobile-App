package com.example.fb.tz.tez.academy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetayActivity extends AppCompatActivity {

    private Toolbar toolbar3;
    private ImageView imageViewdetay;
    private TextView textViewdetbas, textdetayaltbas,textViewdetayicerik;
    private Ilanlar ilan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageViewdetay=findViewById(R.id.imageViewdetay);
        textViewdetbas=findViewById(R.id.textViewdetbas);
        textdetayaltbas=findViewById(R.id.textdetayaltbas);
        textViewdetayicerik=findViewById(R.id.textViewdetayicerik);

        toolbar3=findViewById(R.id.toolbar3);
        toolbar3.setTitle("İlan Detay Ekranı");
        toolbar3.setNavigationIcon(R.drawable.backbeyaz);
        setSupportActionBar(toolbar3);
        toolbar3.setNavigationOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ilan = (Ilanlar) getIntent().getSerializableExtra("nesne");
        textViewdetbas.setText(ilan.getIlan_baslik());
        textdetayaltbas.setText(ilan.getIlan_alt_baslik());
        textViewdetayicerik.setText(ilan.getIlan_icerik());

        imageViewdetay.setImageResource(getResources().getIdentifier(ilan.getIlan_foto(),
                "drawable",
                getPackageName()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_copy:
                Toast.makeText(this, "copy tıklandı", Toast.LENGTH_SHORT).show( );
                return true;
            case R.id.action_share:
                Toast.makeText(this, "paylaş tıklandı", Toast.LENGTH_SHORT).show( );
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}