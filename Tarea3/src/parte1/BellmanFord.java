package parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {

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

        int[][] costosMinimos = new int[n][n];

        long startTime = System.currentTimeMillis(); // Inicio del timestamp

        for (int i = 0; i < n; i++) {
            costosMinimos[i] = bellmanFord(grafo, i);
        }

        long endTime = System.currentTimeMillis(); // Fin del timestamp

        long tiempoEjecucion = endTime - startTime;

        System.out.println("El algoritmo de Bellman-Ford se ejecutó en: " + tiempoEjecucion + " milisegundos");

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(costosMinimos[i]));
       }
    }

    static int[] bellmanFord(int[][] grafo, int origen) {
        int n = grafo.length;
        int[] distancias = new int[n];
        Arrays.fill(distancias, INFINITO);
        distancias[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (grafo[u][v] != -1 && distancias[u] != INFINITO && distancias[u] + grafo[u][v] < distancias[v]) {
                        distancias[v] = distancias[u] + grafo[u][v];
                    }
                }
            }
        }

        // Comprobación de ciclos negativos
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (grafo[u][v] != -1 && distancias[u] != INFINITO && distancias[u] + grafo[u][v] < distancias[v]) {
                    System.out.println("El grafo contiene un ciclo de peso negativo.");
                }
            }
        }

        return distancias;
    }
}
