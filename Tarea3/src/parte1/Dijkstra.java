package parte1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

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
        
        long startTime = System.currentTimeMillis();  // Inicio del timestamp

        for (int i = 0; i < n; i++) {
            costosMinimos[i] = dijkstra(grafo, i);
        }

        long endTime = System.currentTimeMillis();  // Fin del timestamp

        long tiempoEjecucion = endTime - startTime;  // Calcula el tiempo total de ejecución
        
        System.out.println("El algoritmo de Dijkstra se ejecutó en: " + tiempoEjecucion + " milisegundos");

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(costosMinimos[i]));
        }

    }

    static int[] dijkstra(int[][] grafo, int origen) {
        int n = grafo.length;
        int[] distancias = new int[n];
        boolean[] visitados = new boolean[n];

        Arrays.fill(distancias, INFINITO);
        distancias[origen] = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = encontrarVerticeConDistanciaMinima(distancias, visitados);
            visitados[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitados[v] && grafo[u][v] != -1 && distancias[u] != INFINITO && distancias[u] + grafo[u][v] < distancias[v]) {
                    distancias[v] = distancias[u] + grafo[u][v];
                }
            }
        }

        return distancias;
    }

    static int encontrarVerticeConDistanciaMinima(int[] distancias, boolean[] visitados) {
        int minimo = INFINITO, indiceMinimo = -1;
        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] <= minimo) {
                minimo = distancias[i];
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }
}
