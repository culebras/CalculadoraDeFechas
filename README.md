CalculadoraDeFechas
===================

Una calculadora de fechas para Android.

Simple y pequeña aplicación cuyo objetivo principal es ir aprendiendo a desarrollar en la
plataforma Android.

By Culebras GIS (www.culebrasgis.info) (https://github.com/culebras)

_____________________________________________

Consultar el archivo de licencia (LICENSE.md) para detalles acerca de lo que puedes hacer con
este proyecto.
_____________________________________________

La primera versión 1.0 es ya funcional. Las cosas pendientes por hacer son:

1. Crear un icono de aplicación.

2. Mejorar el interfaz gráfico.

3. Mejorar el código de los DatePicker, que por ahora estoy usando dos y seguramente exista una
manera de utilizar sólo uno para todos los campos de fecha.

4. Investigar más los límites de fechas en Android. Por ahora el DatePicker tiene un límite
inferior del año 1900.

5. No estoy usando el UTC (Tiempo Universal Coordinado) por ahora en los constructores de las
fechas para evitar el desfase que se puede dar por las madrugadas debido a la zona horaria de cada
lugar. Por ejemplo, en UTC+2 en España, si se usara UTC en los constructores en lugar de tiempo
local, no habría cambio de día para los cálculos hasta las 2:00 de la madrugada (y eso puede ser
un pequeño inconveniente). Por otra parte, no usar UTC en los constructores supone unos pequeños
bugs según la zona en la que esté configurado el teléfono (por ejemplo para España, se produce un
error si se usa la fecha 01-01-1901 debido a un "time gap"). Habría que seguir investigando cuál
sería la mejor solución para este asunto.

6. Mejorar los mensajes de salida de resultados en el tema de los plurales.
