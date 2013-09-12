package info.culebrasgis.calculadoradefechas;

/**
 * By Culebras, Culebras GIS (www.culebrasgis.info) (https://github.com/culebras)
 *
 * Calculadora De Fechas is free software and is licensed under the GPL v2:
 * GNU GENERAL PUBLIC LICENSE Version 2, June 1991
 * See LICENSE.md for more details.
 */

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class IntervaloActivity extends FragmentActivity {

    // variables
    private Button fechaUsuario;
    private Button fechaUsuario2;
    private TextView resultado;
    private Button reiniciar;
    private Button calcular;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intervalo);

        fechaUsuario = (Button) findViewById(R.id.buttonFechaUsuario);
        fechaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        fechaUsuario2 = (Button) findViewById(R.id.buttonFechaUsuario2);
        fechaUsuario2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment2();
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });

        resultado = (TextView) findViewById(R.id.textViewResultado);

        volver = (Button) findViewById(R.id.buttonVolver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        reiniciar = (Button) findViewById(R.id.buttonReiniciar);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText("Resultado...");
                fechaUsuario.setText("DD/MM/AAAA");
                fechaUsuario2.setText("DD/MM/AAAA");
            }
        });

        calcular = (Button) findViewById(R.id.buttonCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int dia, mes, anno, dia2, mes2, anno2;
                    dia = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(0,2));
                    mes = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(3, 5));
                    anno = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(6,10));

                    dia2 = Integer.parseInt(String.valueOf(fechaUsuario2.getText()).substring(0,2));
                    mes2 = Integer.parseInt(String.valueOf(fechaUsuario2.getText()).substring(3, 5));
                    anno2 = Integer.parseInt(String.valueOf(fechaUsuario2.getText()).substring(6,10));

                    DateTime fecha = new DateTime(anno, mes, dia, 0, 0);
                    DateTime fecha2 = new DateTime(anno2, mes2, dia2, 0, 0);

                    Period periodo;

                    if (fecha.isBefore(fecha2)) { // si la primera fecha es anterior
                        periodo = new Period(fecha, fecha2, PeriodType.yearMonthDay());
                    }
                    else { // si la que es anterior es la segunda fecha
                        periodo = new Period(fecha2, fecha, PeriodType.yearMonthDay());
                    }

                    resultado.setText("El intervalo es de "+periodo.getYears()+" año(s), "+periodo.getMonths()+" mese(s) y "+periodo.getDays()+" día(s).");

                }
                catch (Exception e) {
                    resultado.setText("Por favor, compruebe que ha introducido las fechas correctamente.");
                }
            }
        });

    }

}
