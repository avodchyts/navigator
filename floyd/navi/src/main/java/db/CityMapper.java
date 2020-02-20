package db;

import db.model.CityModel;

import java.util.List;

public interface CityMapper {
    List<CityModel> getCities ();
    CityModel getCitiesById (int id);
}
