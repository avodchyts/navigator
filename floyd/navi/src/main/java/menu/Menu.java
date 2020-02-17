package menu;

import db.model.CityModel;
import service.DBService;
import structure.Route;
import structure.RouteObject;
import utils.JacksonPojoToJson;
import utils.ScannerInput;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Menu {
    private int typeMenu;

    private static final Logger LOGGER = Logger.getLogger(Menu.class);
    public static FileInputStream getFileInputStream (File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public Menu (){}
    public Menu(int typeMenu){
        this.typeMenu = typeMenu;
    }
    public void setTypeMenu (int typeMenu){
        this.typeMenu= typeMenu;
    }

    public int getTypeMenu() {
        return typeMenu;
    }

    public void menuSelect() throws IOException{
       try {
           String path = ClassLoader.getSystemClassLoader().getResource("Menu.properties").getFile();
           FileInputStream file = new FileInputStream(path);
           Properties properties = new Properties();
           properties.load(file);

           ScannerInput scannerInput = new ScannerInput();
           System.out.println("Enter :");

           for (String key : properties.stringPropertyNames()) {
               System.out.println(properties.get(key));
           }
           int typeMeny = scannerInput.intInput();
           LOGGER.debug("Enter type menu"+" " +this.typeMenu);

           switch (typeMeny) {
               // Show all cities
               case 0:
                   DBService service1 = new DBService();
                   List<CityModel> citymodel1 = service1.getCities();
                   for(CityModel cities:citymodel1){
                       System.out.println(cities);
                   }
                   Iterator<CityModel> cityIterator= citymodel1.iterator();
                   while(cityIterator.hasNext()){
                      JacksonPojoToJson pojoToJson = new JacksonPojoToJson();
                       pojoToJson.writeJson(cityIterator.next());
                       pojoToJson.toJsonFile(citymodel1,"cities1");
                        }
                   break;
               //Start route
                   case 1:
                   Route route = new Route();
                   RouteObject.setProperties(route);
                   route.distance();
                   break;
               case 2:
                   System.exit(0);
               default:  System.out.println("Incorrect value of menu selected. Please select 0 or 1 or 2 ");
           }
       }catch (IOException menuex){
           menuex.printStackTrace();
           LOGGER.debug(menuex);
       }
    }
}
