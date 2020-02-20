import db.model.CityModel;
import menu.Menu;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import service.DBService;
import utils.ScannerInput;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class SessionTest {

   @Test
    public void testSqlSession(){

        DBService service = new DBService();
        CityModel city= service.getCitiesById(0);
        Assert.assertEquals(city.getName(),"Brest","SqlSession Exception");
        servise.close();
    }


    @Test
    public void testInput() throws IOException {
        Menu menu = new Menu();
       ScannerInput scannerInput = new ScannerInput();
       System.out.println("Enter :");
       int typeMeny = scannerInput.intInput();
        Assert.assertEquals(menu.getTypeMenu(),0,"Scanner error");
        scannerInput.closeSession();
    }
}
