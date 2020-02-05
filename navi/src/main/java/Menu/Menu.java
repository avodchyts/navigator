package Menu;

import Structure.Route;
import Structure.RouteObject;
import Utils.ScannerInput;
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

    public static void menuSelect() throws IOException{
       FileInputStream file =new FileInputStream("D:/navigator/navi/src/main/resources/Menu.properties");
        Properties properties =new Properties();
        properties.load(file);

        ScannerInput scannerInput = new ScannerInput();
        System.out.println("Enter :");

        for(String key : properties.stringPropertyNames()){
            System.out.println(properties.get(key));
        }
        int typeMeny = scannerInput.intInput();
        switch (typeMeny){
            case 0:
            //Show all cities
            break;
            case 1:
             Route route =new Route();
                RouteObject.setProperties(route);
                System.out.println("The distance between cities :" +route.getDistance()+"km");
            break;
        }

    }
}
