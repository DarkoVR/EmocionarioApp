package com.example.android.emocionario;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.android.emocionario.R;

import java.util.ArrayList;
import java.util.List;

public class SpringWaltz extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    Button btMusica,btReproducir;
    CheckBox ckFelicidad,ckEnvidia,ckCompasion,ckAceptacion,ckAdmiracion,ckEuforia,ckGratitud,ckConfusion,ckPlacer,ckDeseo,ckIlusion,ckSerenidad;
    int[] arreglo = new int[12];
    String msgconcat="";

    public void recupera(){
        Bundle b=this.getIntent().getExtras(); //Obtener la matriz con la clase bundel de TableroBombas.java
        arreglo=b.getIntArray("arreglo");

        for (int i=0;i<arreglo.length;i++){
            msgconcat+=arreglo[i]+" ";
        }

        //Toast toast = Toast.makeText(getApplicationContext(),msgconcat, Toast.LENGTH_SHORT);
        //toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spring_waltz);
        //CheckedBox

        ckFelicidad = (CheckBox) findViewById(R.id.ckFelicidad);
        ckEnvidia = (CheckBox) findViewById(R.id.ckEnvidia);
        ckCompasion = (CheckBox) findViewById(R.id.ckCompasion);
        ckAceptacion = (CheckBox) findViewById(R.id.ckAceptacion);
        ckAdmiracion = (CheckBox) findViewById(R.id.ckAdmiracion);
        ckEuforia = (CheckBox) findViewById(R.id.ckEuforia);
        ckGratitud = (CheckBox) findViewById(R.id.ckGratitud);
        ckConfusion = (CheckBox) findViewById(R.id.ckConfusion);
        ckPlacer = (CheckBox) findViewById(R.id.ckPlacer);
        ckDeseo = (CheckBox) findViewById(R.id.ckDeseo);
        ckIlusion = (CheckBox) findViewById(R.id.ckIlusion);
        ckSerenidad = (CheckBox) findViewById(R.id.ckSerenidad);
        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        // Adding Floating Action Button to bottom right of main view
        final MediaPlayer sprigwaltz = MediaPlayer.create(this,R.raw.springwaltz);
        btReproducir = (Button) findViewById(R.id.btReproducir);
        btMusica = (Button) findViewById(R.id.btMusica);

        recupera();

        btMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //recupera();
                verifica_datos();
                //Toast toast = Toast.makeText(getApplicationContext(),impArreglo(), Toast.LENGTH_SHORT);
                //toast.show();
                sprigwaltz.stop();

                Bundle b=new Bundle();
                b.putIntArray("arreglo",arreglo);
                Context context = v.getContext();
                Intent intent = new Intent(context, Results.class);
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        btReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprigwaltz.start();
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialogo2 = new AlertDialog.Builder(SpringWaltz.this);
        dialogo2.setTitle("Salir...");
        dialogo2.setMessage("¿Deseas terminar el test actual?");
        dialogo2.setCancelable(false);
        dialogo2.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                Intent intent = new Intent(getApplicationContext(), Startup.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        dialogo2.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                dialogo1.cancel();
            }
        });
        dialogo2.show();
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        MainActivity.Adapter adapter = new MainActivity.Adapter(getSupportFragmentManager());
        adapter.addFragment(new ListContentFragment(), "¿Cómo me hace sentir esta canción?");
        viewPager.setAdapter(adapter);
    }

    private void verifica_datos(){
        if (ckFelicidad.isChecked()){
            arreglo[0]++;
        }if (ckEnvidia.isChecked()){
            arreglo[1]++;
        }if (ckCompasion.isChecked()){
            arreglo[2]++;
        }if (ckAceptacion.isChecked()){
            arreglo[3]++;
        }if (ckAdmiracion.isChecked()){
            arreglo[4]++;
        }if (ckEuforia.isChecked()){
            arreglo[5]++;
        }if (ckGratitud.isChecked()){
            arreglo[6]++;
        }if (ckConfusion.isChecked()){
            arreglo[7]++;
        }if (ckPlacer.isChecked()){
            arreglo[8]++;
        }if (ckDeseo.isChecked()){
            arreglo[9]++;
        }if (ckIlusion.isChecked()){
            arreglo[10]++;
        }if (ckSerenidad.isChecked()){
            arreglo[11]++;
        }
    }

    private String impArreglo(){
        String acum="";
        for (int i=0;i<arreglo.length;i++){
            acum+=" "+arreglo[i];
        }
        return acum;
    }
}
