package com.example.android.emocionario;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;


public class Results extends AppCompatActivity {
    private PieChart pieChart;
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
        setContentView(R.layout.activity_results);

        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        pieChart = (PieChart) findViewById(R.id.pieChart);

        /*definimos algunos atributos*/
        pieChart.setHoleRadius(40f);
        pieChart.setDrawYValues(true);
        pieChart.setDrawXValues(true);
        pieChart.setRotationEnabled(true);
        pieChart.animateXY(1500, 1500);

        recupera();

		/*creamos una lista para los valores Y*/
        ArrayList<Entry> valsY = new ArrayList<Entry>();
        for (int i=0;i<arreglo.length;i++){
            valsY.add(new Entry(arreglo[i],i));
        }
        //valsY.add(new Entry(5* 100 / 25,0));
        //valsY.add(new Entry(20 * 100 / 25,1));

 		/*creamos una lista para los valores X*/
        ArrayList<String> valsX = new ArrayList<String>();
        valsX.add("Felicidad");
        valsX.add("Envidia");
        valsX.add("Compasion");
        valsX.add("Aceptacion");
        valsX.add("Admiracion");
        valsX.add("Euforia");
        valsX.add("Gratitud");
        valsX.add("Confusion");
        valsX.add("Placer");
        valsX.add("Deseo");
        valsX.add("Ilusion");
        valsX.add("Serenidad");

 		/*creamos una lista de colores*/
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.blue));
        colors.add(getResources().getColor(R.color.red));
        colors.add(getResources().getColor(R.color.verde));
        colors.add(getResources().getColor(R.color.amarillo));
        colors.add(getResources().getColor(R.color.verde_f));
        colors.add(getResources().getColor(R.color.aqua));
        colors.add(getResources().getColor(R.color.blue));
        colors.add(getResources().getColor(R.color.red));
        colors.add(getResources().getColor(R.color.verde));
        colors.add(getResources().getColor(R.color.amarillo));
        colors.add(getResources().getColor(R.color.verde_f));
        colors.add(getResources().getColor(R.color.aqua));

 		/*seteamos los valores de Y y los colores*/
        PieDataSet set1 = new PieDataSet(valsY, "Resultados");
        set1.setSliceSpace(3f);
        set1.setColors(colors);

		/*seteamos los valores de X*/
        PieData data = new PieData(valsX, set1);
        pieChart.setData(data);
        pieChart.highlightValues(null);
        pieChart.invalidate();

        /*Ocutar descripcion*/
        pieChart.setDescription("");
        /*Ocultar leyenda*/
        pieChart.setDrawLegend(false);

        // Adding Floating Action Button to bottom right of main view
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btResult);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Startup.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialogo2 = new AlertDialog.Builder(Results.this);
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
        adapter.addFragment(new ListContentFragment(), "Resultados");
        viewPager.setAdapter(adapter);
    }
}

