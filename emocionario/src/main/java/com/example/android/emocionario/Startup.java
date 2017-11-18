package com.example.android.emocionario;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Startup extends AppCompatActivity {

    Button btInicio, btInstrucciones, btTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        btInicio = (Button) findViewById(R.id.btInicio);
        btInstrucciones = (Button) findViewById(R.id.btInstrucciones);
        btTest = (Button) findViewById(R.id.btTest);
        // Setting ViewPager for each Tabs
        btInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });
        btInstrucciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Startup.this);
                dialogo1.setTitle("Reglas de juego");
                dialogo1.setMessage("Para lograr que este test sea acertado inicia pulsando el boton de 'Emociones' en donde" +
                        " te explicare sencillamente que es cada emoción.\n" +
                        "Despues de eso puede inicar el Test:\n" +
                        "Seleccione una o más opciones de acuerdo a lo que se le pregunte\n" +
                        "Es todo. ¡Estas listo!");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        dialogo1.cancel();
                    }
                });
                dialogo1.show();
            }
        });
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, Feelings.class);
                context.startActivity(intent);
            }
        });
        // Adding Floating Action Button to bottom right of main view
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Startup.this);
                dialogo1.setTitle("Desarrollado por:");
                dialogo1.setMessage("Laura Iaitzi Vázquez Ramírez\n" +
                        "Zaira Isabel Contreras Barreras\n" +
                        "Maritza Nuñez Medina\n" +
                        "Regina Frangleh Yudico\n" +
                        "Lissett Carina Arroyo Martínez\n" +
                        "Guadalupe Sanchez Nuñez\n" +
                        "\n" +
                        "Maestros/Materia\n" +
                        "Cecilia Arredondo González /\n" +
                        "Comunicación oral y escrita\n" +
                        "\n" +
                        "Gladys Susana Paredes Olalde/\n" +
                        "Desarrollo de la infancia y adolescencia. \n" +
                        "\n" +
                        "Guillermo Cardenas Rivera/\n" +
                        "Manejo de software aplicado a la psicología");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        dialogo1.cancel();
                    }
                });
                dialogo1.show();
            }
        });
    }
}
