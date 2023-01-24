package test;

import java.util.ArrayList;

public class Graph {
    private final int numberOfVertices;
    private final int infinity = 100000;
    private int[] pathArray;
    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    private int minDistance(int[] pathArray, Boolean[] shortestPathSet) {
        int min = infinity, min_index = -1;
        for (int v = 0; v < numberOfVertices; v++)
            if (!shortestPathSet[v] && pathArray[v] <= min) {
                min = pathArray[v];
                min_index = v;
            }
        return min_index;
    }
    // metoda wypisująca dystans między miastem początkowym, a docelowym
    void printMinPath(int srcNode, int desNode, ArrayList<String> cities) {
        if (pathArray[desNode] == infinity) {
            System.out.println("\nThe minimum distance between "
                    + cities.get(srcNode + 1) + " and " + cities.get(desNode + 1) + " is unknown");
        } else {
            System.out.println("\nThe minimum distance between "
                    + cities.get(srcNode + 1) + " and " + cities.get(desNode + 1) + " is " + pathArray[desNode]);
        }
    }

    //pomocnicza metoda wypisująca dystan smiędzy miastem początkowym a resztą miast
    void printPathArray() {
        for (int i = 0; i < pathArray.length; i++) {
            if (pathArray[i] == infinity) {
                System.out.print("Unknown");
            } else {
                System.out.print(pathArray[i]);
            }
            if (i + 1 < pathArray.length) {
                System.out.print(" ");
            }
        }
    }

    void algorytmDijkstra(int[][][] adjList, int srcNode) {
        // tablica wyjściowa zawierająca odległości między miastami
        pathArray = new int[numberOfVertices];

        // najkrótszy zestaw ścieżek
        Boolean[] shortestPathSet = new Boolean[numberOfVertices];

        // warunki początkowe
        for (int i = 0; i < numberOfVertices; i++) {
            pathArray[i] = infinity;
            shortestPathSet[i] = false;
        }
        pathArray[srcNode] = 0;

        // algorytm znajdowania najkrótszych połączeń między wierzchołkiem 0, a resztą
        for (int count = 0; count < numberOfVertices - 1; count++) {
            // pomocniczna metoda znajdująca wierzchołek o najmniejszej odległości
            int u = minDistance(pathArray, shortestPathSet);
            // przetwarzanie wierzchołka u
            shortestPathSet[u] = true;

            for (int v = 0; v < numberOfVertices; v++) {
                // warunek aktualizowania wyników
                if (!shortestPathSet[v] && adjList[count][u][v] != infinity
                        && adjList[count][u][v] != 0 && pathArray[u] != infinity && ((pathArray[u]
                        + adjList[count][u][v]) < pathArray[v])) {
                    pathArray[v] = pathArray[u] + adjList[count][u][v];
                }
            }
        }
    }
}
