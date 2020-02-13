package structure;

import db.model.CityModel;
import db.pojo.CityPojo;
import service.DBService;
import utils.JacksonJsonToPojo;
import utils.ScannerInput;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class RouteObject {
   private static final Logger LOGGER= Logger.getLogger(RouteObject.class);
   public static Route setProperties(Route route) throws IOException{
    try {
       ScannerInput scannerInput = new ScannerInput();
      System.out.println("Enter id city of source :");
       DBService service2 = new DBService();
       List<CityModel> citymodel2 = service2.getCities();
       for(CityModel cities:citymodel2){
          System.out.println(cities);
       }

       int idsourceCity = scannerInput.intInput();
       LOGGER.debug("Enter id city of source:" + idsourceCity);
       route.setIdsourceCity(idsourceCity);

       System.out.println("Enter id city of target");
       int idtargetCity = scannerInput.intInput();
       LOGGER.debug("Enter id city of target" + idtargetCity);
       route.setIdtargetCity(idtargetCity);
       scannerInput.closeSession();
    }catch (IOException routeObjectException){
       routeObjectException.printStackTrace();
       LOGGER.debug(routeObjectException);
    }

   return route;
   }
}
