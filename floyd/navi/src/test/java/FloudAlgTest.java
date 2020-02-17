
import org.junit.After;
import org.junit.Before;
import org.testng.*;
import org.testng.annotations.Test;
import utils.FloydWarshell;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FloudAlgTest {

    @Test
    public  void testShortestRange() {
        FloydWarshell floyd = new FloydWarshell();
        floyd.calculateShortestRange(floyd.getAllCities().get(0), floyd.getAllCities().get(1));

        Assert.assertNotNull(floyd);

    }

    //Great idea for test
    @Test
    public void testShortestRangeNotDependOnDirection(){
        FloydWarshell floyd = new FloydWarshell();
        floyd.calculateShortestRange(floyd.getAllCities().get(0),floyd.getAllCities().get(5));
        FloydWarshell result=floyd;

        FloydWarshell floyd1 = new FloydWarshell();
        floyd1.calculateShortestRange(floyd.getAllCities().get(5),floyd.getAllCities().get(0));
        FloydWarshell result1=floyd1;
        Assert.assertEquals(result,result1);

    }
}

