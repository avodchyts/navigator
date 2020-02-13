package structure;

import utils.FloydWarshell;

public class Route {
    private int idsourceCity;
    private int idtargetCity;

    public Route (){}

    public Route(int idsourceCity, int idtargetCity){
        this.idsourceCity= idsourceCity;
        this.idtargetCity =idtargetCity;
    }

    public void setIdsourceCity(int idsourceCity) {
        this.idsourceCity = idsourceCity;
    }

    public int getIdsourceCity() {
        return idsourceCity;
    }

    public void setIdtargetCity(int idtargetCity) {
        this.idtargetCity = idtargetCity;
    }

    public int getIdtargetCity() {
        return idtargetCity;
    }

    public void getDistance( ){

        FloydWarshell floyd = new FloydWarshell();
        floyd.calculateShortestRange(floyd.getAllCities().get(getIdsourceCity()), floyd.getAllCities().get(getIdtargetCity()));
    }

    public String toString(){
        return ("Id source city" +idsourceCity +" "+ "Id target city "+idtargetCity);
    }
}
