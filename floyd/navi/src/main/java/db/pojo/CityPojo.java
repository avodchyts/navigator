package db.pojo;

import db.model.CityModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CityPojo {
    private int id;
    private String name;
    private List<CityPojo> cityPojos=new ArrayList<CityPojo>();

    public CityPojo(){}

    public CityPojo(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityPojo> getCityPojos() {
        return cityPojos;
    }

    public void setCityPojos(List<CityPojo> cityPojos) {
        this.cityPojos = cityPojos;
    }

    @Override
    public String toString(){return "Cities: id nameCity{"+ id+" "+name+"}";}
}
