package info.culebrasgis.calculadoradefechas;

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
        sAnno = String.valueOf(anno);
        ((Button) getActivity().findViewById(R.id.buttonFechaUsuario2)).setText(sDia+"/"+sMes+"/"+sAnno);
        ((TextView) getActivity().findViewById(R.id.textViewResultado)).setText("Pulse 'Calcular'");
    }

}