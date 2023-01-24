package test;

import java.util.ArrayList;

// deadline 18.12.2022!!!

public class test {
    public static void main(String[] args) {
        // wartość domyślna
        int firstArg = 5;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }
        int numberOfVertices = firstArg;
        int src = 0;
        int des = 3;
        ArrayList<String> cities = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            // przykladowe nazwy miast
            cities.add("Vertex" + i);
        }

        // tworzenie macierzy sasiedztwa o danej wielkosci
        AdjList adj = new AdjList();
        int[][][] adjList = adj.adjacencyList(cities.size());
        System.out.println();

//        for (int k = 0; k < numberOfVertices; k++) {
//            for (int i = 0; i < numberOfVertices; i++) {
//                for (int j = 0; j < numberOfVertices; j++) {
//                    if(adjList[k][i][j] == 100000){
//                        System.out.print("0, ");
//                    }
//                    else{
//                        System.out.print(adjList[k][i][j] + ", ");
//                    }
//
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        // wywołanie algorytmu Dijkstra oraz wypisanie obliczonych odległości
        Graph g = new Graph(numberOfVertices);
        g.algorytmDijkstra(adjList, src);
        g.printMinPath(src, des, cities);
        g.printPathArray();

//        for (int k = 0; k < numberOfVertices; k++) {
//            for (int i = 0; i < numberOfVertices; i++) {
//                for (int j = 0; j < numberOfVertices; j++) {
//                    if(adjList[k][i][j] == g.infinity){
//                        System.out.print("0, ");
//                    }
//                    else{
//                        System.out.print(adjList[k][i][j] + ", ");
//                    }
//
//                }
//                System.out.println();
//            }
//            System.out.println();
//            System.out.println();
//        }

        // wywołanie algorytmu Bellmana-Forda oraz wypisanie obliczonych odległości
        Graph2 g2 = new Graph2(numberOfVertices);
        g2.algorytmBellmanaForda(adjList);
        g2.printMinPath(src, des, cities);
        g2.printPathArray();
    }

}