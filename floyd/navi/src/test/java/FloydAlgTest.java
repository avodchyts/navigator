
import org.junit.After;
import org.junit.Before;
import org.testng.*;
import org.testng.annotations.Test;
import utils.FloydWarshell;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FloudAlgTest {

      @Test
    public void getTestShortestRange(){
        FloydWarshell floyd = new FloydWarshell();
        int result = floyd.calculateShortestRange(floyd.getAllCities().get(0), floyd.getAllCities().get(1));

        Assert.assertEquals(result,300,"getTestShortestRange Exception");
    }

    //Great idea for test
    @Test
    public void testShortestRangeNotDependOnDirection(){
        FloydWarshell floyd = new FloydWarshell();
        int result=floyd.calculateShortestRange(floyd.getAllCities().get(0),floyd.getAllCities().get(5));

        FloydWarshell floyd1 = new FloydWarshell();
        int result1=floyd1.calculateShortestRange(floyd.getAllCities().get(5),floyd.getAllCities().get(0));

         Assert.assertEquals(result,result1);

    }
}

