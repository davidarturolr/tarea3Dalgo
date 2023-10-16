Ana Cristina Rodríguez – 202123530 
David León – 201615216
Luis Alfredo Castelblanco – 201910966

Instrucciones para ejecutar los programas:

- Parte 1: 

Formato del archivo de entrada:
El archivo de entrada debe contener una matriz de adyacencia, donde:

La entrada en la fila i y columna j debe ser un número entero que representa el costo o distancia del vértice i al vértice j.
Si no hay arista entre los vértices i y j, el valor debe ser -1.


Para la ejecución: 

Modificar la linea 14 del algoritmo que se va a ejecutar con la ruta del archivo que contiene la matriz de adyacencia. Por ejemplo "data/distances5.txt". 

Descripción de salida: 

La primera linea nos dice el tiempo de ejecución, lo cual es necesario para la creación del excel con las comparaciones y posteriormente nos retorna la matriz que contiene los costos entre todos los vértices fuente y todos los vértices destino.

NOTA: En la carpeta 'docs' se encuentra un excel que contiene la comparación de los tiempos de ejecución de los diferentes algoritmos con diferentes tamaños de grafos. 

- Parte 2: 

Formato del archivo de entrada:

Una matriz de adyacencia del grafo. La matriz debe ser cuadrada, y cada número debe estar separado por un espacio. Cada fila de la matriz debe estar en una nueva línea. Ejemplo:

-1 -1 -1 1 -1 -1 -1
-1 -1 -1 -1 -1 1 -1
-1 -1 -1 1 -1 -1 -1
1 -1 1 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1 1
-1 1 -1 -1 -1 -1 -1
-1 -1 -1 -1 1 -1 -1

El valor de -1 indica la ausencia de un borde y un valor de 1 indica la presencia de un borde entre los nodos.


Para la ejecución: 

Se ejecuta la clase ComponentesConectados.java, la cual nos pedirá que ingresemos por consola la matriz sobre la cual queremos conocer los componentes conectados. Para este punto tomamos la matriz del ejemplo y la guardamos en el archivo 'Parte2.txt'.

Copiar y pegar el contenido de 'Parte2.txt' o la matriz de ejemplo que se encuentra en el apartado de 'Formato del archivo de entrada' para la parte 2 en el README.txt


Descripción de la salida:

Una vez ingresada la matriz, el programa mostrará la lista de componentes conectados del grafo. Cada componente estará representado por una lista de nodos que pertenecen a ese componente.


- Parte 3: 

Formato del archivo de entrada:

Un archivo que contiene la matriz de adyacencia del grafo. La matriz debe ser cuadrada, y cada número debe estar separado por un espacio. Cada fila de la matriz debe estar en una nueva línea.

Un valor de -1 indica la ausencia de un borde y un valor de 1 indica la presencia de un borde entre los nodos.

Para la ejecución: 

En la linea 55, modificar la ruta del archivo que contiene la matriz de adyacencia que representa el grafo del cual se quiere verificar la existencia de ciclos. Por ejemplo: "data/Parte3.txt" 

En la carpeta 'data' el archivo 'Parte3.txt' contiene la matriz de adyacencia para el grafo de la parte 1, el cual contiene ciclos. 

También añadimos una matriz de adyacencia que representa un grafo que no tiene ciclos, el cual se llama 'Parte3NoCiclos.txt' y se encuentre en la carpeta 'data'

Descripción de la salida:

Tras ingresar la matriz, el programa mostrará si el grafo tiene ciclos o no.

Ejemplos de salida:

Con el archivo 'Parte3.txt': "El grafo tiene al menos un ciclo."
Con el archivo 'Parte3NoCiclos.txt': "El grafo no tiene ciclos."

