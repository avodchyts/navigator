package Menu;

import DB.DAO.CityDAO;
import DB.Model.City;
import Structure.Route;
import Structure.RouteObject;
import Utils.OpenSession;
import Utils.ScannerInput;
import org.apache.ibatis.session.SqlSessionFactory;
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
           FileInputStream file = new FileInputStream("D:/navigator/navi/src/main/resources/Menu.properties");
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
                   SqlSessionFactory sqlSessionFactory= new OpenSession().getOpenSession();
                   List<City> cities = new CityDAO(sqlSessionFactory).getNameCity();
                   Iterator<City> cityIterator= cities.iterator();
                   while(cityIterator.hasNext()){
                      System.out.println(cityIterator.next());
                   }
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
