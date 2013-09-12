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

public class EdadActivity extends FragmentActivity {

    // variables
    private Button fechaUsuario;
    private TextView resultado;
    private Button reiniciar;
    private Button calcular;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad);

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
                resultado.setText("Su edad es...");
                fechaUsuario.setText("DD/MM/AAAA");
            }
        });

        calcular = (Button) findViewById(R.id.buttonCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int dia, mes, anno;
                    dia = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(0,2));
                    mes = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(3, 5));
                    anno = Integer.parseInt(String.valueOf(fechaUsuario.getText()).substring(6,10));

                    DateTime hoy = new DateTime();
                    DateTime fecha = new DateTime(anno, mes, dia, 0, 0);

                    if (fecha.isAfter(hoy)) { // si el usuario mete una fecha posterior al día actual
                        resultado.setText("Aún no es posible que hayas nacido en el futuro ;D");
                    }
                    else {
                        Period periodo = new Period(fecha, hoy, PeriodType.yearMonthDay());
                        resultado.setText("La edad es "+periodo.getYears()+" año(s), "+periodo.getMonths()+" mese(s) y "+periodo.getDays()+" día(s).");
                    }
                }
                catch (Exception e) {
                    resultado.setText("Por favor, compruebe que ha introducido la fecha correctamente.");
                }
            }
        });

    }

}
