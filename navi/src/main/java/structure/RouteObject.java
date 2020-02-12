package structure;

import utils.ScannerInput;
import org.apache.log4j.Logger;

import java.io.IOException;

public class RouteObject {
   private static final Logger LOGGER= Logger.getLogger(RouteObject.class);
   public static Route setProperties(Route route) throws IOException{
    try {
       ScannerInput scannerInput = new ScannerInput();
       System.out.println("Enter city of departure");
       String cityDeparture = scannerInput.strInput();
       LOGGER.debug("Enter city of departure:" + cityDeparture);
       route.setCityDeparture(cityDeparture);

       System.out.println("Enter city of destination");
       String cityDestination = scannerInput.strInput();
       LOGGER.debug("Enter city of destination" + cityDestination);
       route.setCityDestination(cityDestination);
       scannerInput.closeSession();
    }catch (IOException routeObjectException){
       routeObjectException.printStackTrace();
       LOGGER.debug(routeObjectException);
    }

   return route;
   }
}
