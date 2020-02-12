package structure;

public class Route {
    private String cityDeparture;
    private String cityDestination;

    public Route (){}

    public Route(String cityDeparture, String cityDestination){
        this.cityDeparture= cityDeparture;
        this.cityDestination =cityDestination;
    }

    public void setCityDeparture(String cityDeparture) {
        this.cityDeparture = cityDeparture;
    }

    public String getCityDeparture() {
        return cityDeparture;
    }

    public void setCityDestination(String cityDestination) {
        this.cityDestination = cityDestination;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public int getDistance( ){
        int result;

        result = 300;

    return result;
    }

    public String toString(){
        return ("CityModel of departure" +cityDeparture +" "+ "CityModel of Destination"+cityDestination);
    }
}
