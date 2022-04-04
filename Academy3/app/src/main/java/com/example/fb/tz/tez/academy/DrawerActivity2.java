package com.example.fb.tz.tez.academy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity2 extends AppCompatActivity implements SearchView.OnQueryTextListener, NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Fragment fragment;
    private BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer2);

        bottom_navigation=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tutucu, new FragmentAnasayfa()).commit();
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener( ) {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.action_birinci_home){
                    Toast.makeText(getApplicationContext(), "anasayfa tıklandı", Toast.LENGTH_LONG).show();
                    fragment=new FragmentAnasayfa();
                }
                if (item.getItemId()==R.id.action_ikinci_arama){
                    Toast.makeText(getApplicationContext(), "arama tıklandı", Toast.LENGTH_LONG).show();
                    fragment=new FragmentArama();

                }
                if (item.getItemId()==R.id.action_ücüncü_profil){
                    Toast.makeText(getApplicationContext(), "profil tıklandı", Toast.LENGTH_LONG).show();
                    fragment=new FragmentProfil();

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu, fragment).commit();

                return true;
            }
        });

        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);
        drawer=findViewById(R.id.drawer);
        toolbar.setTitle("ACADEMY");
        setSupportActionBar(toolbar);

        fragment= new MevzuatFragment();
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawer, toolbar,
                0,0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        View baslik = navigationView.inflateHeaderView(R.layout.navigation_baslik);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.arama_drawer, menu);
        MenuItem item=menu.findItem(R.id.action_arama);
        SearchView searchView= (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
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
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            Intent yeniIntent = new Intent( Intent.ACTION_MAIN );
            yeniIntent.addCategory(Intent.CATEGORY_HOME);
            yeniIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(yeniIntent);
        }
        super.onBackPressed( );
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.mevzuat){
            Toast.makeText(getApplicationContext(), "mevzuat tıklandı", Toast.LENGTH_LONG).show();
            fragment= new MevzuatFragment();

        }
        if (item.getItemId()==R.id.arsiv){
            Toast.makeText(getApplicationContext(), "arşiv tıklandı", Toast.LENGTH_LONG).show();
            fragment= new ArsivFragment();

        }
        if (item.getItemId()==R.id.destek){
            Toast.makeText(getApplicationContext(), "destek tıklandı", Toast.LENGTH_LONG).show();
            fragment=new DestekFragment();

        }
        if (item.getItemId()==R.id.gizlilik){
            Toast.makeText(getApplicationContext(), "gizlilik tıklandı", Toast.LENGTH_LONG).show();
            fragment=new GizlilikFragment();

        }
        if (item.getItemId()==R.id.qrkod){
            Toast.makeText(getApplicationContext(), "Qr Kod tıklandı", Toast.LENGTH_SHORT).show( );
            fragment= new QrFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_tutucu, fragment).commit();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
