package DB.Model;

public class CityRange {
    private int id;
    private City sourceCity;
    private City targetCity;
    private int range;

    public CityRange(int id, City sourceCity, City targetCity, int range) {
        this.id = id;
        this.sourceCity = sourceCity;
        this.targetCity = targetCity;
        this.range = range;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(City sourceCity) {
        this.sourceCity = sourceCity;
    }

    public City getTargetCity() {
        return targetCity;
    }

    public void setTargetCity(City targetCity) {
        this.targetCity = targetCity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
