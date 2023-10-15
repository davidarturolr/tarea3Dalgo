package parte2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ComponentesConectados {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> entradas = new ArrayList<>();
        System.out.println("Ingrese la matriz de adyacencia fila por fila: (copiar y pegar contenido de 'Parte2.txt')");

        String primeraFila = sc.nextLine();
        int n = primeraFila.split(" ").length;
        entradas.add(primeraFila);

        for (int i = 1; i < n; i++) {
            entradas.add(sc.nextLine());
        }

        int[][] grafo = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] fila = entradas.get(i).split(" ");
            for (int j = 0; j < n; j++) {
                grafo[i][j] = Integer.parseInt(fila[j]);
            }
        }

        List<List<Integer>> componentes = encontrarComponentesConectados(grafo);

        for (List<Integer> componente : componentes) {
            System.out.println(componente);
        }

        sc.close();
    }

    public static List<List<Integer>> encontrarComponentesConectados(int[][] grafo) {
        List<List<Integer>> componentes = new ArrayList<>();
        boolean[] visitados = new boolean[grafo.length];

        for (int i = 0; i < grafo.length; i++) {
            if (!visitados[i]) {
                List<Integer> componente = bfs(grafo, i, visitados);
                componentes.add(componente);
            }
        }

        return componentes;
    }

    public static List<Integer> bfs(int[][] grafo, int inicio, boolean[] visitados) {
        List<Integer> componente = new ArrayList<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int vertice = cola.poll();
            if (!visitados[vertice]) {
                visitados[vertice] = true;
                componente.add(vertice);

                for (int i = 0; i < grafo.length; i++) {
                    if (grafo[vertice][i] == 1 && !visitados[i]) {
                        cola.add(i);
                    }
                }
            }
        }

        return componente;
    }
}
