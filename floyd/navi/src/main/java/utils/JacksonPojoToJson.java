package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import db.model.CityModel;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.IOException;

public class JacksonPojoToJson {
    private static final Logger LOGGER = Logger.getLogger(JacksonPojoToJson.class);
    private ObjectMapper mapper;

    public JacksonPojoToJson() {

        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public String writeJson(CityModel cityModel) throws IOException {
        try {
            String objectJson = mapper.writeValueAsString(cityModel);
            return objectJson;
        }catch(IOException ew){ew.printStackTrace();LOGGER.error(ew);}
        return writeJson(cityModel);
    }


    public void toJsonFile(Object object, String filename) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename + ".json");
            mapper.writeValue(fileOutputStream, object);
            fileOutputStream.close();
        } catch (IOException e) {LOGGER.debug(e); e.printStackTrace();
            throw new NullPointerException();
        }
    }
}
