package execute;

import db.model.CityModel;
import db.model.CityRangeModel;
import service.DBService;
import utils.FloydWarshell;

import java.io.IOException;
import java.util.List;

public class Executor {
    public static void main(String[] args) throws Exception {
//        Menu menu = new Menu();
//        menu.menuSelect();
        FloydWarshell floyd = new FloydWarshell();
        floyd.calculateShortestRange(floyd.getAllCities().get(0), floyd.getAllCities().get(0));


    }
}

