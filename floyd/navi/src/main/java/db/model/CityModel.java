package db.model;

import java.util.Objects;

public class CityModel {
    private int id;
    private String name;

    public CityModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityModel() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityModel cityModel = (CityModel) o;
        return id == cityModel.id &&
                name.equals(cityModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
   public String toString(){
        return id+" "+name;
    }
}
