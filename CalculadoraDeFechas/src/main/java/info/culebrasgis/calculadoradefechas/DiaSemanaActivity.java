package info.culebrasgis.calculadoradefechas;

/**
 * By Culebras, Culebras GIS (www.culebrasgis.info) (https://github.com/culebras)
 *
 * Calculadora De Fechas is free software and is licensed under the GPL v2:
 * GNU GENERAL PUBLIC LICENSE Version 2, June 1991
 * See LICENSE.md for more details.
 */

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.joda.time.DateTime;

public class DiaSemanaActivity extends FragmentActivity {

    // variables
    private Button fechaUsuario;
    private TextView resultado;
    private Button reiniciar;
    private Button calcular;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_semana);

        fechaUsuario = (Button) findViewById(R.id.buttonFechaUsuario);
        fechaUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
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
                resultado.setText(R.string.resultado);
                fechaUsuario.setText(R.string.fecha);
            }
        });

        calcular = (Button) findViewById(R.id.buttonCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int dia, mes, anno, diaSemana;
                    dia = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(0,2));
                    mes = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(3, 5));
                    anno = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(6,10));

                    DateTime fecha = new DateTime(anno, mes, dia, 0, 0);
                    diaSemana = fecha.getDayOfWeek();

                    Resources res = getResources();
                    String[] diasNombres = res.getStringArray(R.array.days_of_week);

                    resultado.setText(String.format(getString(R.string.resultado_dia_semana),
                            diasNombres[diaSemana-1]));
                }
                catch (Exception e) {
                    resultado.setText(R.string.fecha_incorrecta);
                }
            }
        });

    }

}
