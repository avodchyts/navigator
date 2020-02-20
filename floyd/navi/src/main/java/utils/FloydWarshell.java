package utils;

import db.model.CityModel;
import db.model.CityRangeModel;
import org.apache.ibatis.session.SqlSessionException;
import service.DBService;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshell {
    private List<CityRangeModel> ranges = new ArrayList<>();
    private List<CityModel> allCities = new ArrayList<>();

    public FloydWarshell() {

        try {
            DBService service1 = new DBService();
            List<CityModel> citymodel1 = service1.getCities();
            List<CityRangeModel> cityrangemodel1 = service1.getRanges();
            ranges.addAll(cityrangemodel1);
            allCities.addAll(citymodel1);
        } catch (
                SqlSessionException e) {
            e.printStackTrace();
        }
    }

    public List<CityModel> getAllCities() {
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
    public int printSolution(int[][] cost, int[][] path, int N, int sourceCityId, int destinationCityId) {


        if (sourceCityId != destinationCityId && path[sourceCityId][destinationCityId] != -1) {
            System.out.print("Shortest Path from city " + allCities.get(sourceCityId).getName() +
                    " to city " + allCities.get(destinationCityId).getName() + " is (" + allCities.get(sourceCityId).getName() + "->");
              printPath(path, sourceCityId, destinationCityId);
              System.out.println(allCities.get(destinationCityId).getName() + ")");
             System.out.println("The distance between cities :" + cost[sourceCityId][destinationCityId]);
            return cost[sourceCityId][destinationCityId];
        }

        return -1;
    }

    // Function to run Floyd-Warshell algorithm
    public int floydWarshell(int[][] adjMatrix, int N, int sourceCityIndex, int destinationCityIndex) {
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
                    //    return;
                }
            }
        }
        // Print the shortest path between all pairs of vertices
        //  printSolution(cost, path, N, sourceCityIndex, destinationCityIndex);
        return printSolution(cost, path, N, sourceCityIndex, destinationCityIndex);
    }

    public int calculateShortestRange(CityModel sourceCity, CityModel destinationCity) {
        if (sourceCity.equals(destinationCity)) {
            System.out.println("Unable to build route!");
        }
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
                for (CityRangeModel range : ranges) {
                    if (range.getSourceCity().equals(allCities.get(x)) && range.getTargetCity().equals(allCities.get(y))) {
                        line[y] = range.getDistance();
                        break;
                    }
                }
            }
            matrix[x] = line;
        }
        int sourceIndex = 0;
        int destinationIndex = 0;
        for (int i = 0; i < allCities.size(); i++) {
            if (allCities.get(i).equals(sourceCity)) {
                sourceIndex = i;
            }
            if (allCities.get(i).equals(destinationCity)) {
                destinationIndex = i;
            }
        }
        return floydWarshell(matrix, allCities.size(), sourceIndex, destinationIndex);

    }

}
