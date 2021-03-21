package com.rocio.poma.practica9_navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FRAGMENTO UNO PARA QUE APARESCA AL PRINCIPIO
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contedor_principal,new FragmentUno());
        transaction.commit();
        //
        DrawerLayout drawerLayout=findViewById(R.id.drawerLayout);
        MaterialToolbar toolbar=findViewById(R.id.toolbarPrincipal);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navView=findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                if (item.getItemId()==R.id.item1){
                    Toast.makeText(getApplicationContext(),"Hizo clic en Item 1", Toast.LENGTH_SHORT).show();
                    return true;
                }else if (item.getItemId()==R.id.item2){
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contedor_principal,new FragmentDos());
                    transaction.commit();
                }else if (item.getItemId()==R.id.item3){
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contedor_principal,new FragmentTres());
                    transaction.commit();
                }
                return false;
            }
        });
    }
}