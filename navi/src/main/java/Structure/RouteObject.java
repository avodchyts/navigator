package Structure;

import Utils.ScannerInput;

import java.io.IOException;

public class RouteObject {
   public static Route setProperties(Route route) throws IOException{
      ScannerInput scannerInput = new ScannerInput();
      System.out.println("Enter city of departure");
      String cityDeparture = scannerInput.strInput();
      route.setCityDeparture(cityDeparture);

      System.out.println("Enter city of destination");
      String cityDestination = scannerInput.strInput();
      route.setCityDestination(cityDestination);
      scannerInput.closeSession();

   return route;
   }
}
