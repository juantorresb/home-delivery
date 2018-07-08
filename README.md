Su corrientazo a domicilio
===============

Esta prueba tecnica es realizada para S4N como parte del proceso de selección.

Realizada por Juan Carlos Torres - Ingeniero de Sistemas, en la cual se han aplicado conocimientos de programación Orientada a Objetos, buenas practicas de desarrollo y pruebas unitarias.

Requerimientos Funcionales
--------------------
Se definen los principales requerimientos:
+ RQ01-Distancia valida para un domicilio, un dron solo entregará domicilios a diez cuadras a la redonda de su barrio.
+ RQ02-Cantidad de domicilios, el dron solo es capaz de cargar hasta tres almuerzos por vez.
+ RQ03-Realizar domicilio, un dron sea capaz de entragar a domicilio a partir de las directrices suministradas por un fichero (in.txt) con los movimientos del dron.
+ RQ04-Estado del dron, una vez finalizado el domicilio se debe generar un fichero out.txt con las coordenadas en las que el dron a dejado el domicio. 

Indicaciones de movimientos
--------------------
Las siguientes indicaciones son utilizadas desde la perspectiva del dron para realizar los movimientos:
+ La letra A corresponde a un movimiento hacia adelante.
+ La letra I corresponde a un giro de 90 grados del dron a la izquierda.
+ La letra D corresponde a un giro de 90 grados del dron a la derecha.

Aclaraciones
--------------------
+ Cada línea del archivo de texto corresponde a una entrega de un almuerzo.
+ El dron siempre inicia en la posición (0, 0) orientación Norte.
