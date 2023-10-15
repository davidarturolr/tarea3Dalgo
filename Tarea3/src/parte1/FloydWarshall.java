package parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {

    static final int INFINITO = Integer.MAX_VALUE;

    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("data/distances5.txt");
        Scanner scanner = new Scanner(archivo);
        ArrayList<int[]> datos = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] linea = scanner.nextLine().trim().split("\\s+");
            int[] fila = new int[linea.length];
            for (int j = 0; j < linea.length; j++) {
                fila[j] = Integer.parseInt(linea[j]);
            }
            datos.add(fila);
        }

        int n = datos.size();
        int[][] grafo = new int[n][n];

        for (int i = 0; i < n; i++) {
            grafo[i] = datos.get(i);
        }

        long startTime = System.currentTimeMillis();  // Inicio del timestamp

        int[][] costosMinimos = floydWarshall(grafo);

        long endTime = System.currentTimeMillis();  // Fin del timestamp

        long tiempoEjecucion = endTime - startTime;
        System.out.println("El algoritmo de Floyd-Warshall se ejecutó en: " + tiempoEjecucion + " milisegundos");

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(costosMinimos[i]));
        }
    }

    static int[][] floydWarshall(int[][] grafo) {
        int n = grafo.length;
        int[][] dist = new int[n][n];

        // Inicialización de la matriz de distancias con los valores del grafo.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (grafo[i][j] != -1) {
                    dist[i][j] = grafo[i][j];
                } else {
                    dist[i][j] = INFINITO;
                }
            }
        }

        // Actualización de la matriz de distancias.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INFINITO && dist[k][j] != INFINITO && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }
}
