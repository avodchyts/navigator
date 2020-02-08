package Utils;

import DB.Model.City;
import DB.Model.CityRange;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshell {
    private List<CityRange> ranges = new ArrayList<>();
    private List<City> allCities = new ArrayList<>();

    public FloydWarshell() {
        City brest = new City(0, "Brest");
        City minsk = new City(1, "Minsk");
        City grodno = new City(2, "Grodno");
        City gomel = new City(3, "Gomel'");
        City mogilev = new City(4, "Mogilev");
        City vitebsk = new City(5, "Vitebsk");
        allCities.add(brest);
        allCities.add(minsk);
        allCities.add(grodno);
        allCities.add(gomel);
        allCities.add(mogilev);
        allCities.add(vitebsk);
        ranges.add(new CityRange(1, brest, minsk, 300));
        ranges.add(new CityRange(2, brest, grodno, 200));
        ranges.add(new CityRange(3, brest, gomel, 400));
        ranges.add(new CityRange(4, minsk, brest, 300));
        ranges.add(new CityRange(5, minsk, grodno, 320));
        ranges.add(new CityRange(6, minsk, vitebsk, 280));
        ranges.add(new CityRange(7, minsk, mogilev, 180));
        ranges.add(new CityRange(8, minsk, gomel, 270));
        ranges.add(new CityRange(9, grodno, brest, 200));
        ranges.add(new CityRange(10, grodno, minsk, 320));
        ranges.add(new CityRange(11, grodno, vitebsk, 293));
        ranges.add(new CityRange(12, vitebsk, grodno, 293));
        ranges.add(new CityRange(13, vitebsk, minsk, 280));
        ranges.add(new CityRange(14, vitebsk, mogilev, 181));
        ranges.add(new CityRange(14, mogilev, vitebsk, 181));
        ranges.add(new CityRange(15, mogilev, minsk, 180));
        ranges.add(new CityRange(16, mogilev, gomel, 160));
        ranges.add(new CityRange(17, gomel, mogilev, 160));
        ranges.add(new CityRange(18, gomel, minsk, 270));
        ranges.add(new CityRange(18, gomel, brest, 200));
    }

    public List<City> getAllCities() {
        return allCities;
    }

    // Recursive Function to print path of given
    // vertex u from source vertex v
    private void printPath(int[][] path, int v, int u) {
        if (path[v][u] == v)
            return;
        printPath(path, v, path[v][u]);
        System.out.print(allCities.get(path[v][u]).getName() + "->");
    }

    // Function to print the shortest cost with path
    // information between all pairs of vertices
    private void printSolution(int[][] cost, int[][] path, int N, int sourceCityId, int destinationCityId) {
        for (int v = 0; v < N; v++) {
            if (v == sourceCityId) {
                for (int u = 0; u < N; u++) {
                    if (u == destinationCityId) {
                        if (u != v && path[v][u] != -1) {
                            System.out.print("Shortest Path from city " + allCities.get(v).getName() +
                                    " to vertex " + allCities.get(u).getName() + " is (" + allCities.get(v).getName() + "->");
                            printPath(path, v, u);
                            System.out.println(allCities.get(u).getName() + ")");
                            System.out.println("The distance between cities :" + cost[v][u]);
                        }
                    }
                }
            }
        }
    }

    // Function to run Floyd-Warshell algorithm
    public void FloydWarshell(int[][] adjMatrix, int N, int sourceCityIndex, int destinationCityIndex) {
        // cost[] and parent[] stores shortest-path
        // (shortest-cost/shortest route) information
        int[][] cost = new int[N][N];
        int[][] path = new int[N][N];

        // initialize cost[] and parent[]
        for (int v = 0; v < N; v++) {
            for (int u = 0; u < N; u++) {
                // initially cost would be same as weight
                // of the edge
                cost[v][u] = adjMatrix[v][u];
                if (v == u) {
                    path[v][u] = 0;
                } else if (cost[v][u] != Integer.MAX_VALUE) {
                    path[v][u] = v;
                } else {
                    path[v][u] = -1;
                }
            }
        }

        // run Floyd-Warshell
        for (int k = 0; k < N; k++) {
            for (int v = 0; v < N; v++) {
                for (int u = 0; u < N; u++) {
                    // If vertex k is on the shortest path from v to u,
                    // then update the value of cost[v][u], path[v][u]
                    if (cost[v][k] != Integer.MAX_VALUE
                            && cost[k][u] != Integer.MAX_VALUE
                            && (cost[v][k] + cost[k][u] < cost[v][u])) {
                        cost[v][u] = cost[v][k] + cost[k][u];
                        path[v][u] = path[k][u];
                    }
                }
                // if diagonal elements become negative, the
                // graph contains a negative weight cycle
                if (cost[v][v] < 0) {
                    System.out.println("Negative Weight Cycle Found!!");
                    return;
                }
            }
        }
        // Print the shortest path between all pairs of vertices
        printSolution(cost, path, N, sourceCityIndex, destinationCityIndex);
    }

    public void calculateShortestRange(City sourceCity, City destinationCity) {
        int M = Integer.MAX_VALUE;
        int[][] matrix = new int[allCities.size()][allCities.size()];
        for (int x = 0; x < allCities.size(); x++) {
            int[] line = new int[allCities.size()];
            for (int y = 0; y < allCities.size(); y++) {
                if (x == y) {
                    line[y] = 0;
                    continue;
                }
                line[y] = M;
                for (CityRange range : ranges) {
                    if (range.getSourceCity() == allCities.get(x) && range.getTargetCity() == allCities.get(y)) {
                        line[y] = range.getRange();
                        break;
                    }
                }
            }
            matrix[x] = line;
        }
        int sourceIndex = 0;
        int destinationIndex = 0;
        for (int i = 0; i < allCities.size(); i++) {
            if (allCities.get(i) == sourceCity) {
                sourceIndex = i;
            }
            if (allCities.get(i) == destinationCity) {
                destinationIndex = i;
            }
        }
        FloydWarshell(matrix, allCities.size(), sourceIndex, destinationIndex);
    }
}
