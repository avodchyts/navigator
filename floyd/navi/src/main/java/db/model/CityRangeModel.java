package db.model;

public class CityRangeModel {
    private int id;
    private CityModel sourceCity;
    private CityModel targetCity;
    private int distance;


    public CityRangeModel() { }
    public CityRangeModel(int id, CityModel sourceCity, CityModel targetCity, int range) {
        this.id = id;
        this.sourceCity = sourceCity;
        this.targetCity = targetCity;
        this.distance = range;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CityModel getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(CityModel sourceCity) {
        this.sourceCity = sourceCity;
    }

    public CityModel getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(CityModel targetCity) {
        this.targetCity = targetCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
