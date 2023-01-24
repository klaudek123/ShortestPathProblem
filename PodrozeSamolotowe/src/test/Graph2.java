package test;

import java.util.ArrayList;

public class Graph2 {
    private final int numberOfVertices;
    private final int infinity = 100000;
    private int[] pathArray;

    Graph2(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
    }

    // metoda wypisująca dystans między miastem początkowym, a docelowym
    void printMinPath(int srcNode, int desNode, ArrayList<String> cities) {
        if (pathArray[desNode] == infinity) {
            System.out.println("\nThe minimum distance between "
                    + (cities.get(srcNode + 1)) + " and " + (cities.get(desNode + 1)) + " is unknown");
        } else {
            System.out.println("\nThe minimum distance between " + (cities.get(srcNode + 1))
                    + " and " + (cities.get(desNode + 1)) + " is " + pathArray[desNode]);
        }
    }

    //pomocnicza metoda wypisująca dystan smiędzy miastem początkowym a resztą miast
    void printPathArray() {
        for (int i = 0; i < numberOfVertices; i++) {
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

    void algorytmBellmanaForda(int[][][] adjList) {
        // tablica wyjściowa zawierająca odległości między miastami
        pathArray = new int[numberOfVertices];

        // początkowe wartości
        for (int i = 0; i < numberOfVertices; i++) {
            pathArray[i] = adjList[0][0][i];
        }

        // algorytm znajdowania najkrótszych połączeń między wierzchołkiem 0, a resztą
        for (int k = 1; k < numberOfVertices - 2; k++) {
            for (int i = 1; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfVertices; j++) {
                    // przypadki zmian wartości w tablicy wyjściowej
                    int n;
                    if (pathArray[j] + adjList[k][j][i] > infinity) {
                        n = infinity;
                    } else {
                        n = pathArray[j] + adjList[k][j][i];
                    }
                    pathArray[i] = Math.min(pathArray[i], n);
                }
            }
        }
    }


}
