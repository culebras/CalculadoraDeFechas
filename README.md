CalculadoraDeFechas
===================

Una calculadora de fechas para Android: simple y pequeña aplicación cuyo objetivo principal es ir
aprendiendo a desarrollar en la plataforma Android.

* Por Culebras GIS (www.culebrasgis.info) // (https://github.com/culebras)
* Iconos y gráficos por JDalebrook (www.jdalebrook.es)
* Correcciones en la traducción al inglés por A.M.D. (www.translatorana.com)
_____________________________________________

*Cambios en el archivo CHANGELOG.md

*Consulte el archivo de licencia (LICENSE.md) para detalles acerca de lo que puede hacer con
este proyecto.

*Esta aplicación utiliza la librería java Joda-Time (www.joda.org/joda-time)
_____________________________________________

Cosas pendientes por hacer:

1. Mejorar el interfaz gráfico.

2. Mejorar el código de los "DatePickerDialog", que por ahora estoy usando dos y seguramente exista
una manera de utilizar sólo uno para todos los campos de fecha.

3. No estoy usando el UTC (Tiempo Universal Coordinado) por ahora en los constructores de las
fechas para evitar el desfase que se puede dar por las madrugadas debido a la zona horaria de cada
lugar. Por ejemplo, en UTC+2 en España, si se usara UTC en los constructores en lugar de tiempo
local, no habría cambio de día para los cálculos hasta las 2:00 de la madrugada (y eso puede ser
un pequeño inconveniente). Por otra parte, no usar UTC en los constructores supone unos pequeños
"bugs" según la zona en la que esté configurado el teléfono (por ejemplo para España, se produce un
error si se usa la fecha 01-01-1901 debido a un "time gap"). Habría que seguir investigando cuál
sería la mejor solución para este asunto.

4. Mejorar el tema de los plurales en los mensajes de salida de resultados.
