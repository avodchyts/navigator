package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import db.pojo.CityPojo;
import org.apache.log4j.Logger;
import structure.RouteObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JacksonJsonToPojo {
    private static final Logger LOGGER= Logger.getLogger(JacksonJsonToPojo.class);
    ObjectMapper mapper;

    public JacksonJsonToPojo(){

        mapper = new ObjectMapper();
    }

    public CityPojo jsonToPojo(String filename) throws IOException {

        try {
            InputStream fileInputStream = new FileInputStream(filename);
            CityPojo cityPojo = mapper.readValue(fileInputStream, CityPojo.class);
            fileInputStream.close();
        }catch (IOException aio){aio.printStackTrace();
        LOGGER.debug(aio);}

        return jsonToPojo(filename);
    }
}
