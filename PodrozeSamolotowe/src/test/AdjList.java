package test;

import java.util.Random;

public class AdjList {
    Random rand = new Random();

    public int[][][] adjacencyList(int numberOfVertices) {
        int[][][] graph = new int[numberOfVertices][numberOfVertices][numberOfVertices];
        int[][] arr = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = i; j < numberOfVertices; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = rand.nextInt(100) + 100; // losowa dlugosc polaczen
                    arr[j][i] = arr[i][j];
                }
            }
        }

        for (int k = 0; k < numberOfVertices; k++) {
            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = i; j < numberOfVertices; j++) {
                    if (rand.nextInt(10) > 1 && i != j) { // gestosc grafu
                        graph[k][i][j] = 100000; // brak połaczenia
                        graph[k][j][i] = graph[k][i][j];
                    } else {
                        graph[k][i][j] = arr[i][j];
                        graph[k][j][i] = graph[k][i][j];
                    }
                }
            }
        }
        return graph;
    }
}
