package Execute;

import Menu.Menu;
import Utils.FloydWarshell;

public class Executor {
    public static void main(String[] args) throws Exception {
//        Menu menu = new Menu();
//        menu.menuSelect();
        FloydWarshell floyd = new FloydWarshell();
        floyd.calculateShortestRange(floyd.getAllCities().get(0), floyd.getAllCities().get(5));
    }
}

