package info.culebrasgis.calculadoradefechas;

/**
 * By Culebras, Culebras GIS (www.culebrasgis.info) (https://github.com/culebras)
 *
 * Calculadora De Fechas is free software and is licensed under the GPL v2:
 * GNU GENERAL PUBLIC LICENSE Version 2, June 1991
 * See LICENSE.md for more details.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    // variables
    private Button edad;
    private Button tiempoEntreFechas;
    private Button diasHastaFecha;
    private Button diasDesdeFecha;
    private Button acercaDe;
    private Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edad = (Button) findViewById(R.id.buttonEdad);
        edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EdadActivity.class);
                startActivity(intent);
            }
        });

        tiempoEntreFechas = (Button) findViewById(R.id.buttonTiempoEntreFechas);
        tiempoEntreFechas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntervaloActivity.class);
                startActivity(intent);
            }
        });

        diasHastaFecha = (Button) findViewById(R.id.buttonDiasHastaFecha);
        diasHastaFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiasHastaActivity.class);
                startActivity(intent);
            }
        });

        diasDesdeFecha = (Button) findViewById(R.id.buttonDiasDesdeFecha);
        diasDesdeFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiasDesdeActivity.class);
                startActivity(intent);
            }
        });

        acercaDe = (Button) findViewById(R.id.buttonAcercaDe);
        acercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder altDialog= new AlertDialog.Builder(MainActivity.this);
                altDialog.setMessage(R.string.acercaDe);
                altDialog.setNeutralButton("OK", null);
                altDialog.show();
            }
        });

        salir = (Button) findViewById(R.id.buttonSalir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

}
