package info.culebrasgis.calculadoradefechas;

/**
 * By Culebras, Culebras GIS (www.culebrasgis.info) (https://github.com/culebras)
 *
 * Calculadora De Fechas is free software and is licensed under the GPL v2:
 * GNU GENERAL PUBLIC LICENSE Version 2, June 1991
 * See LICENSE.md for more details.
 */

// estoy haciendo importaciones de la v4.app porque quiero
// compatibilidad por debajo de la 3.0 para los DialogFragment

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerFragment2 extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // usamos la fecha actual como la fecha por defecto en el selector
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int anno = c.get(Calendar.YEAR);

        // Crear una nueva instancia de DatePickerDialog y devolverla
        return new DatePickerDialog(getActivity(), this, anno, mes, dia);
    }

    public void onDateSet(DatePicker view, int anno, int mes, int dia) {
        // lo que se hace cuando se pulsa establecer en el DatePicker
        String sDia = "";
        String sMes = "";
        String sAnno = "";
        if (dia < 10) {sDia = "0" + String.valueOf(dia);}
        if (dia >= 10) {sDia = String.valueOf(dia);}
        if ((mes+1) < 10) {sMes = "0" + String.valueOf(mes+1);}
        if ((mes+1) >= 10) {sMes = String.valueOf(mes+1);}
        if (anno < 1000 && anno > 99) {sAnno = "0" + String.valueOf(anno);}
        if (anno < 100 && anno > 9) {sAnno = "00" + String.valueOf(anno);}
        if (anno < 10) {sAnno = "000" + String.valueOf(anno);}
        if (anno > 999) {sAnno = String.valueOf(anno);}
        ((Button) getActivity().findViewById(R.id.buttonFechaUsuario2)).setText(sDia+"/"+sMes+"/"+sAnno);
        ((TextView) getActivity().findViewById(R.id.textViewResultado)).setText(R.string.pulse_calcular);
    }

}