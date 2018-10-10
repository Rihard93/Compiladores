miniC 
Status Proyecto: Fase #2 - Analizador Sintactico

/* ESTRUCTURA GENERAL DEL PROGRAMA */

- Al iniciar el programa, este solicita atravez de la interfaz grafica la carga de un archivo con extension .frag o .txt.
- El programa analiza el archivo y determina que elementos pertencen al diccionario previamente definido.
- El programa analiza la sintaxis del archivo y determina si esta escrito correctamente en el lenguaje de programacion definido.
- Por cada error detectado se escribira en pantalla el mensaje de error.
- Por cada error de sintaxis detectado se escribira en pantalla y se notificara la linea, columna y simbolo del error encontrado.
- Al finalizar el escaneo se mostrara un mensaje en pantalla indicando que el escaneo ha finalizado.


/* FUNCIONAMIENTO DEL PROGRAMA */

- El programa esta diseñado en base a los requerimientos del enunciado de cada fase.
- Las expresiones estan diseñadas para que cada palabra,caracter,identificador,numero y comentario puedan ser reconocidos adecuadamente
- El manejo de errores que tengo en mi sistema, es que todo aquel caracter que no este previamente definido en las expresiones 
  regulares sera tomado como un caracter desconocido.