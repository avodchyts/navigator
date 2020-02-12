package Menu;

import structure.Route;
import structure.RouteObject;
import utils.ScannerInput;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
           if(!(typeMeny == 0) || !(typeMenu == 1)){
               System.out.println("Incorrect value of menu selected. Please select 0 or 1 ");
           }

           switch (typeMeny) {
               case 0:   //Show all cities
//                   SqlSessionFactory sqlSessionFactory= new OpenSession().getOpenSession();
//                   List<CityModel> cities = new CityDAO(sqlSessionFactory).getNameCity();
//                   Iterator<CityModel> cityIterator= cities.iterator();
//                   while(cityIterator.hasNext()){
//                      System.out.println(cityIterator.next());
//                   }
                   break;
               case 1:
                   Route route = new Route();
                   RouteObject.setProperties(route);
                   System.out.println("The distance between cities :" + route.getDistance() + "km");
                   break;
           }
       }catch (IOException menuex){
           menuex.printStackTrace();
           LOGGER.debug(menuex);
       }
    }
}
