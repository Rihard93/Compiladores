miniC - Analizador Lexico

/* ESTRUCTURA GENERAL DEL PROGRAMA */

- Al iniciar el programa, este solicita atravez de la interfaz grafica la carga de un archivo con extension .frag o .txt.
- El programa analiza el archivo y determina que elementos pertencen al diccionario previamente definido.
- Por cada error detectado, se escribira la palabra " *** ERROR LINEA # *** " mas el token no reconocido en el archivo de texto y en pantalla.
- Al finalizar el escaneo se mostrara un mensaje con la ubicacion del archivo .out en donde se visualizaran todos los resultados del analizador
- Tambien se muestra en pantalla el resultado del analizador lexico


/* FUNCIONAMIENTO DEL PROGRAMA */

- El programa esta diseñado en base a los requerimientos del enunciado.
- Las expresiones estan diseñadas para que cada palabra,caracter,identificador,numero y comentario puedan ser reconocidos adecuadamente
- El manejo de errores que tengo en mi sistema, es que todo aquel caracter que no este previamente definido en las expresiones 
  regulares sera tomado como un caracter desconocido.