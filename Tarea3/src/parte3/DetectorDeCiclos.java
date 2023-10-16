package parte3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectorDeCiclos {

    private final int numVertices;
    private final List<List<Integer>> adjList;

    public DetectorDeCiclos(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino) {
        adjList.get(origen).add(destino);
    }

    private boolean dfsRecursivo(int v, boolean[] visitados, boolean[] enPila) {
        visitados[v] = true;
        enPila[v] = true;

        for (int vecino : adjList.get(v)) {
            if (!visitados[vecino] && dfsRecursivo(vecino, visitados, enPila)) {
                return true;
            } else if (enPila[vecino]) {
                return true;
            }
        }

        enPila[v] = false;
        return false;
    }

    public boolean tieneCiclos() {
        boolean[] visitados = new boolean[numVertices];
        boolean[] enPila = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            if (!visitados[i] && dfsRecursivo(i, visitados, enPila)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File archivo = new File("data/Parte3NoCiclos.txt");
        Scanner scanner = new Scanner(archivo);

        List<int[]> datos = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] linea = scanner.nextLine().trim().split("\\s+");
            int[] fila = new int[linea.length];
            for (int j = 0; j < linea.length; j++) {
                fila[j] = Integer.parseInt(linea[j]);
            }
            datos.add(fila);
        }
        int n = datos.size();

        DetectorDeCiclos grafo = new DetectorDeCiclos(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (datos.get(i)[j] != -1 && datos.get(i)[j] != 0) {
                    grafo.agregarArista(i, j);
                }
            }
        }

        if (grafo.tieneCiclos()) {
            System.out.println("El grafo tiene al menos un ciclo.");
        } else {
            System.out.println("El grafo no tiene ciclos.");
        }
    }
}
